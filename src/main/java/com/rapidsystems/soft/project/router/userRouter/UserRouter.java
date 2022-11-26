package com.rapidsystems.soft.project.router.userRouter;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

public interface UserRouter {

    @Bean
    RouterFunction<ServerResponse> objectUserRouterFunction();
}
