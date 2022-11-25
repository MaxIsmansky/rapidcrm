package com.rapidsystems.soft.project.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface Handler {

    Mono<ServerResponse> findById(ServerRequest request);

    Mono<ServerResponse> findAll(ServerRequest request);

    Mono<ServerResponse> save(ServerRequest request);

    Mono<ServerResponse> deleteById(ServerRequest request);

    Mono<ServerResponse> update(ServerRequest request);

}
