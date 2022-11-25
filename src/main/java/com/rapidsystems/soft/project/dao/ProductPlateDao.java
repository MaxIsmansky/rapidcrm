package com.rapidsystems.soft.project.dao;

import com.rapidsystems.soft.project.model.plate.ProductPlate;
import com.rapidsystems.soft.project.model.dto.OperationStatusResponse;
import com.rapidsystems.soft.project.repository.ProductPlateRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductPlateDao implements PlateDao<ProductPlate, OperationStatusResponse> {

    private final ProductPlateRepository productPlateRepository;

    @Override
    public Mono<ProductPlate> findById(String id) {
        return productPlateRepository.findById(id);
    }

    @Override
    public Flux<ProductPlate> findAll() {
        return productPlateRepository.findAll();
    }

    @Override
    public Mono<ProductPlate> save(ProductPlate productPlate) {
        return productPlateRepository.save(productPlate);
    }

    @Override
    public Mono<ProductPlate> update(ProductPlate productPlate) {
        return productPlateRepository.save(productPlate);
    }

    @Override
    public Mono<OperationStatusResponse> deleteById(String id) {
        productPlateRepository.deleteById(id).subscribe();
        return Mono.just(new OperationStatusResponse(true));
    }
}
