package com.rapidsystems.soft.project.handler.order;

import com.rapidsystems.soft.project.handler.Handler;
import com.rapidsystems.soft.project.model.order.Order;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface OrderHandler extends Handler {
    public Mono<ServerResponse> updateOrderProcessing(ServerRequest request);

    public Mono<ServerResponse> updateOrderComplete(ServerRequest request);
}
