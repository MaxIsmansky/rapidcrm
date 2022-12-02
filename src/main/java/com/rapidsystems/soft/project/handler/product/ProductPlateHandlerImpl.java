package com.rapidsystems.soft.project.handler.product;

import com.rapidsystems.soft.project.dao.PlateDao;
import com.rapidsystems.soft.project.model.dto.OperationStatusResponse;
import com.rapidsystems.soft.project.model.plate.ProductPlate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductPlateHandlerImpl implements ProductPlateHandler {

    private final PlateDao plateDao;

    @Override
    public Mono<ServerResponse> findById(ServerRequest request) {
        Optional<String> id = request.queryParam("id");
        Mono<ProductPlate> plateMono = plateDao.findById(id.orElseThrow(() -> new RuntimeException("Parameter id can't be empty!")));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(plateMono, ProductPlate.class);
    }

    @Override
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(plateDao.findAll(), ProductPlate.class);
    }

    @Override
    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<ProductPlate> productPlateMono = request.bodyToMono(ProductPlate.class);
        Mono<ProductPlate> savedProductMono = productPlateMono.flatMap(productPlate -> {
            Mono<ProductPlate> savedProductPlate = plateDao.save(productPlate);
            return savedProductPlate;
        });
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(savedProductMono, ProductPlate.class);
    }

    @Override
    public Mono<ServerResponse> update(ServerRequest request) {
        Mono<ProductPlate> productPlateMono = request.bodyToMono(ProductPlate.class);
        final Mono<ProductPlate> updatedProductMono = productPlateMono.flatMap(productPlate -> {
            Mono<ProductPlate> updatedProductPlate = plateDao.save(productPlate);
            return updatedProductPlate;
        });
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(updatedProductMono, ProductPlate.class);
    }

    @Override
    public Mono<ServerResponse> deleteById(ServerRequest request) {
        Optional<String> id = request.queryParam("id");
        Mono<OperationStatusResponse> responseMono = plateDao.deleteById(id.orElseThrow(() -> new RuntimeException("Parameter id can't be empty!")));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseMono, OperationStatusResponse.class);
    }
}
