package com.rapidsystems.soft.project.handler.product;

import com.rapidsystems.soft.project.model.dto.OperationStatusResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.File;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductImageHandlerImpl implements ProductImageHandler {

    @Value("${application.static.images}")
    private String imagesDirectory;

    @Override
    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<MultiValueMap<String, Part>> multipartData = request.multipartData();
        final Mono<OperationStatusResponse> result = multipartData
                .map(map -> map.toSingleValueMap().get("file"))
                .map(file -> {
                    final FilePart uploadedFile = (FilePart) file;
                    final Mono<Void> voidMono = uploadedFile.transferTo(new File(imagesDirectory + uploadedFile.filename()));
                    voidMono.subscribe();
                    return new OperationStatusResponse(true);
                }).doOnError(ex -> log.error(ex.getMessage())).log();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result, OperationStatusResponse.class);
    }

    @Override
    public Mono<ServerResponse> findById(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> deleteById(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> update(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> saveImage(ServerRequest request) {
        return null;
    }
}
