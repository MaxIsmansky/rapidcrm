package com.rapidsystems.soft.project.router;

import com.rapidsystems.soft.project.handler.product.ProductImageHandler;
import com.rapidsystems.soft.project.handler.product.ProductPlateHandler;
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
    private final ProductImageHandler productImageHandler;

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

    @Bean
    //todo вообще если хранить картинки на том же сервере что и данные, то можно все это отправлять и получать в том же запросе,
    // но лучше в будущем использовать внешнее хранилище, поэтому пока будет дополнительный запрос на получение.
    // В будущем разверну ceph и переедем туда
    public RouterFunction<ServerResponse> imageRouterFunction() {
        return RouterFunctions.route()
                .GET("/api/product/picture", productImageHandler::findById)
                .POST("/api/product/image", productImageHandler::save)
                .DELETE("/api/product/image/delete", productImageHandler::deleteById)
                .build();
    }
}
