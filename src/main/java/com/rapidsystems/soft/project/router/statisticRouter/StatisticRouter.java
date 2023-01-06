package com.rapidsystems.soft.project.router.statisticRouter;

import com.mongodb.lang.Nullable;
import com.rapidsystems.soft.project.handler.order.OrderHandler;
import com.rapidsystems.soft.project.handler.statistic.StatisticOrderHandler;
import com.rapidsystems.soft.project.router.Router;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class StatisticRouter implements Router {

    private final StatisticOrderHandler statisticOrderHandler;


    @Bean(name = "StatisticOrder")
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/api/admin/statistic/ordersPerDay", statisticOrderHandler::findAll)
                .build();
    }
}
