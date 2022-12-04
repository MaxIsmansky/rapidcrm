package com.rapidsystems.soft.project.handler.product;

import com.rapidsystems.soft.project.model.dto.OperationStatusResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductImageHandlerImpl implements ProductImageHandler {

    @Value("${application.static.images}")
    private String imagesDirectory;

    @Override
    public Mono<ServerResponse> save(ServerRequest request) {
        //todo На фронте при сохранении генерировать уникальное имя файла и класть его в документа плитки
        final Mono<MultiValueMap<String, Part>> multipartData = request.multipartData();
        final Mono<OperationStatusResponse> result = multipartData
                .map(map -> map.toSingleValueMap().get("file"))
                .map(file -> {
                    final FilePart uploadedFile = (FilePart) file;
                    final Mono<Void> voidMono = uploadedFile.transferTo(new File(imagesDirectory + uploadedFile.filename()));
                    voidMono.subscribe();
                    return new OperationStatusResponse(true);
                }).doOnError(ex -> log.error(ex.getMessage()));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result, OperationStatusResponse.class);
    }

    @Override
    @SneakyThrows
    public Mono<ServerResponse> findById(ServerRequest request) {
        final String id = request.queryParam("id").orElseThrow(() -> new RuntimeException("Parameter id can't be empty!"));
        final Path pathToImage = Paths.get(imagesDirectory + "/" + id);
        final Mono<byte[]> fileBytesMono = Mono.create(sink -> {
            try {
                byte[] fileBytes = Files.readAllBytes(pathToImage);
                sink.success(fileBytes);
            } catch (IOException e) {
                sink.error(new RuntimeException("Error during file reading!\n" + e.getMessage()));
            }
        });
        return ServerResponse.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(fileBytesMono, byte[].class);
    }

    @Override
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> deleteById(ServerRequest request) {
        final String id = request.queryParam("id").orElseThrow(() -> new RuntimeException("Parameter id can't be empty!"));
        final Path pathToImage = Paths.get(imagesDirectory + "/" + id);
        final Mono<OperationStatusResponse> resultStatus = Mono.create(sink -> {
            try {
                final boolean result = Files.deleteIfExists(pathToImage);
                sink.success(new OperationStatusResponse(result));
            } catch (IOException e) {
                sink.error(new RuntimeException("Error during file reading!\n" + e.getMessage()));
            }
        });
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(resultStatus, OperationStatusResponse.class);
    }

    @Override
    public Mono<ServerResponse> update(ServerRequest request) {
        return null;
    }
}
