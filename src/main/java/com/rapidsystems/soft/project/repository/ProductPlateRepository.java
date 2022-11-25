package com.rapidsystems.soft.project.repository;

import com.rapidsystems.soft.project.model.plate.ProductPlate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProductPlateRepository extends ReactiveMongoRepository<ProductPlate, String> {

}
