package com.rapidsystems.soft.project.router;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

public interface Router {
    @Bean
    RouterFunction<ServerResponse> routerFunction();
}
