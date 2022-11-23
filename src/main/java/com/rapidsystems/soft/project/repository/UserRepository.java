package com.rapidsystems.soft.project.repository;

import com.rapidsystems.soft.project.model.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends R2dbcRepository<User, Long> {

    @Query("SELECT u.* FROM users u WHERE u.id = :id")
    Mono<User> findById(Long id);
}
