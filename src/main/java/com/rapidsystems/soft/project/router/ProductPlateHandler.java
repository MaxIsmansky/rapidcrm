package com.rapidsystems.soft.project.router;

import com.rapidsystems.soft.project.dao.Dao;
import com.rapidsystems.soft.project.model.ProductPlate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductPlateHandler implements Handler {

    private final Dao dao;

    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        //todo параметризовать, метод должен сохранять любые объекты
        final Mono<ProductPlate> productPlateMono = request.bodyToMono(ProductPlate.class);
        final Mono<ProductPlate> savedProductMono = productPlateMono.flatMap(productPlate -> {
            final Mono<ProductPlate> savedProductPlate = dao.save(productPlate);
            return savedProductPlate;
        });
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(savedProductMono, ProductPlate.class);
    }
}
