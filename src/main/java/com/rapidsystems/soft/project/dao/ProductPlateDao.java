package com.rapidsystems.soft.project.dao;

import com.rapidsystems.soft.project.model.ProductPlate;
import com.rapidsystems.soft.project.repository.ProductPlateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductPlateDao implements Dao<ProductPlate> {

    private final ProductPlateRepository productPlateRepository;

    @Override
    public Mono<ProductPlate> findById() {
        return null;
    }

    @Override
    public Flux<ProductPlate> findAll() {
        return null;
    }

    @Override
    public Mono<ProductPlate> save(ProductPlate productPlate) {
        final Mono<ProductPlate> savedProductPlateMono = productPlateRepository.save(productPlate);
        return savedProductPlateMono;
    }
}
