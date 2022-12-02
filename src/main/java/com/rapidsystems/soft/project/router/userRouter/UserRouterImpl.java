package com.rapidsystems.soft.project.router.userRouter;

import com.rapidsystems.soft.project.handler.user.UserHandler;
import com.rapidsystems.soft.project.router.Router;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class UserRouterImpl implements Router {


    private final UserHandler userHandler;


    @Override
    @Bean(name = "userRouter")
    public RouterFunction<ServerResponse> routerFunction() {
        return  RouterFunctions.route()
                .GET("/api/users/find", userHandler::findById)
                .GET("/api/users", userHandler::findAll)
                .POST("/api/users/save", userHandler::save)
                .PUT("/api/users/update", userHandler::update)
                .DELETE("/api/users/delete", userHandler::deleteById)
                .build();
    }
}
