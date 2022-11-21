package com.rapidsystems.soft.project.router;

import com.rapidsystems.soft.project.dao.Dao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class ProductPlateRouter {

    private final Dao dao;
    private final Handler productHandler;

    @Bean
    public RouterFunction<ServerResponse> objectPlateRouterFunction() {
        return RouterFunctions.route()
                .POST("/api/product/save", productHandler::handle)
                .build();
    }
}
