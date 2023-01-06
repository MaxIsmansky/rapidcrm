package com.rapidsystems.soft.project.handler.statistic;

import com.mongodb.lang.Nullable;
import com.rapidsystems.soft.project.dao.statisticDao.OrderStatisticDao;
import com.rapidsystems.soft.project.model.dto.statisticDto.OrderStatisticTo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class StatisticOrderHandler {

    private final OrderStatisticDao orderStatisticDao;



    @SneakyThrows
    public Mono<ServerResponse> findAll(ServerRequest request)  {
        Optional<String> startDate = request.queryParam("startDate");
        Optional<String> endDate = request.queryParam("endDate");
        try {
            return ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(orderStatisticDao.getByDate(startDate.orElseGet(() -> null), endDate.orElseGet(() -> null)), OrderStatisticTo.class);
        } catch (ParseException e) {
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST));
        }

    }





}
