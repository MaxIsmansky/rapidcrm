package com.rapidsystems.soft.project.handler.order;

import com.rapidsystems.soft.project.dao.orderDao.OrderDao;
import com.rapidsystems.soft.project.model.dto.OperationStatusResponse;
import com.rapidsystems.soft.project.model.order.Order;
import com.rapidsystems.soft.project.model.user.User;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderHandlerImpl implements OrderHandler{

    private final OrderDao orderDao;

    @Override
    public Mono<ServerResponse> findById(ServerRequest request) {
        Optional<String> id = request.queryParam("id");
        Mono<Order> orderMono = orderDao.findById(id.orElseThrow(() -> new RuntimeException("Parameter id can't be empty!")));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderMono, Order.class);
    }

    @Override
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderDao.findAll(), Order.class);
    }

    @Override
    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<Order> orderMono = request.bodyToMono(Order.class);
        final Mono<Order> savedOrderMono = orderMono.flatMap( order -> {
            Mono<Order> savedOrder = orderDao.save(order);
            return savedOrder;
        });
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(savedOrderMono, Order.class);
    }

    @Override
    public Mono<ServerResponse> deleteById(ServerRequest request) {
        Optional<String> id = request.queryParam("id");
        Mono<OperationStatusResponse> responseMono = orderDao.deleteById(id.orElseThrow(() -> new RuntimeException("Parameter id can't be empty!")));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseMono, OperationStatusResponse.class);
    }

    @Override
    public Mono<ServerResponse> update(ServerRequest request) {
        Mono<Order> orderMono = request.bodyToMono(Order.class);
        final Mono<Order> updateOrderMono = orderMono.flatMap( order -> {
            Mono<Order> updateOrder = orderDao.save(order);
            return updateOrder;
        });
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(updateOrderMono, Order.class);
    }



    @Override
    public Mono<ServerResponse> updateOrderProcessing(ServerRequest request) {
        Mono<Order> orderMono = orderDao.findById(request.queryParam("id").orElseThrow(() -> new RuntimeException("Parameter id can't be empty!")));
        final Mono<Order> updatedMono = orderMono.flatMap(order -> {
            //todo обработать ответ, если поле уже заполнено
           if (order.getStartInProgressDate() == null) {
               order.setStartInProgressDate(new Date());
           }
           Mono<Order> updatedOrder = orderDao.save(order);
           return updatedOrder;
        });

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(updatedMono, Order.class);

    }

    @Override
    public Mono<ServerResponse> updateOrderComplete(ServerRequest request) {
        Mono<Order> orderMono = orderDao.findById(request.queryParam("id").orElseThrow(() -> new RuntimeException("Parameter id can't be empty!")));
        final Mono<Order> updatedMono = orderMono.flatMap(order -> {
            //todo обработать ответ, если поле уже заполнено
            if (order.getCompleteDate() == null) {
                order.setCompleteDate(new Date());
            }
            Mono<Order> updatedOrder = orderDao.save(order);
            return updatedOrder;
        });

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(updatedMono, Order.class);
    }
}
