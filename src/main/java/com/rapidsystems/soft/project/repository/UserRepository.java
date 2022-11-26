package com.rapidsystems.soft.project.repository;

import com.rapidsystems.soft.project.model.user.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
