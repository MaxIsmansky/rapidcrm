package com.rapidsystems.soft.project.router;

import com.rapidsystems.soft.project.dao.PlateDao;
import com.rapidsystems.soft.project.handler.ProductPlateHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class ProductPlateRouter implements Router {
    private final ProductPlateHandler productHandler;

    @Override
    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/api/product/find", productHandler::findById)
                .GET("/api/product/all", productHandler::findAll)
                .POST("/api/product/save", productHandler::save)
                .PUT("/api/product/update", productHandler::update)
                .DELETE("/api/product/delete", productHandler::deleteById)
                .build();
    }
}
