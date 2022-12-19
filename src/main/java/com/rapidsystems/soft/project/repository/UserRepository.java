package com.rapidsystems.soft.project.repository;

import com.rapidsystems.soft.project.model.user.SecurityUser;
import com.rapidsystems.soft.project.model.user.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<SecurityUser, String> {

    Mono<SecurityUser> findByUsername(String name);
}
