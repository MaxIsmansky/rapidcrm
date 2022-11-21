package com.rapidsystems.soft.project.router;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface Handler {

    Mono<ServerResponse> handle(ServerRequest request);
}
