package com.rapidsystems.soft.project.handler.user;

import com.rapidsystems.soft.project.dao.userDao.UserDao;
import com.rapidsystems.soft.project.model.dto.OperationStatusResponse;
import com.rapidsystems.soft.project.model.plate.ProductPlate;
import com.rapidsystems.soft.project.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserHandlerImpl implements UserHandler{

    @Autowired
    private final UserDao userDao;


    @Override
    public Mono<ServerResponse> findById(ServerRequest request) {
        Optional<String> id = request.queryParam("id");
        Mono<User> userMono = userDao.findById(id.orElseThrow(() -> new RuntimeException("Parameter id can't be empty!")));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userMono, User.class);
    }

    @Override
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return  ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userDao.findAll(), User.class);
    }

    @Override
    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<User> UserMono = request.bodyToMono(User.class);
        Mono<User> savedUserMono = UserMono.flatMap(user -> {
            Mono<User> savedUser = userDao.save(user);
            return savedUser;
        });
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(savedUserMono, User.class);
    }

    @Override
    public Mono<ServerResponse> deleteById(ServerRequest request) {
        Optional<String> id = request.queryParam("id");
        Mono<OperationStatusResponse> responseMono = userDao.deleteById(id.orElseThrow(() -> new RuntimeException("Parameter id can't be empty!")));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseMono, OperationStatusResponse.class);
    }

    @Override
    public Mono<ServerResponse> update(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        final Mono<User> updatedUserMono = userMono.flatMap(user -> {
            Mono<User> updatedUser = userDao.save(user);
            return updatedUser;
        });
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(updatedUserMono, User.class);
    }
}
