package com.rapidsystems.soft.project.repository;

import com.rapidsystems.soft.project.model.ProductPlate;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPlateRepository extends R2dbcRepository<ProductPlate, Long> {
}
