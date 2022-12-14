package com.rapidsystems.soft.project.router.orderRouter;

import com.rapidsystems.soft.project.handler.order.OrderHandler;
import com.rapidsystems.soft.project.router.Router;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class OrderAdminRouter implements Router {

    private final OrderHandler orderHandler;

    @Bean(name = "adminOrder")
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/api/admin/orders/find", orderHandler::findById)
                .GET("/api/admin/orders", orderHandler::findAll)
                .POST("/api/admin/orders/save", orderHandler::save)
                .PUT("/api/admin/orders/processing", orderHandler::updateOrderProcessing)
                .PUT("/api/admin/orders/complete", orderHandler::updateOrderComplete)
                .PUT("/api/admin/orders/update", orderHandler::update)
                .DELETE("/api/admin/orders/delete", orderHandler::deleteById)
                .build();
    }
}
