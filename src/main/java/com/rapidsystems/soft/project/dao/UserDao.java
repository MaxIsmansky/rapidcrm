package com.rapidsystems.soft.project.dao;

import com.rapidsystems.soft.project.model.User;
import com.rapidsystems.soft.project.repository.UserRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Component
@Primary
public class UserDao implements Dao<User>{

    private final UserRepository userRepository;




    @Autowired
    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Flux<User> findAll() {
        return null;
    }

    @Override
    public Mono<User> save(User user) {
        return null;
    }
}
