package com.rapidsystems.soft.project.dao.statisticDao;

import com.mongodb.lang.Nullable;
import com.rapidsystems.soft.project.model.order.Order;
import com.rapidsystems.soft.project.repository.OrderRepository;
import com.rapidsystems.soft.project.model.dto.statisticDto.OrderStatisticTo;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderStatisticDao {

    private final OrderRepository orderRepository;

    private final ReactiveMongoTemplate mongo;

    public Flux<OrderStatisticTo> getByDate(@Nullable String startDate, @Nullable String endDate) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date start = startDate == null ? new Date(Long.MIN_VALUE) : df.parse(startDate);
        Date  end = endDate == null ? new Date(Long.MAX_VALUE) : df.parse(endDate);

        MatchOperation greaterThan = Aggregation.match(new Criteria("completeDate").gt(start));
        MatchOperation lessThan = Aggregation.match(new Criteria("completeDate").lt(end));

        ProjectionOperation completeDate = Aggregation.project()
                .and(DateOperators.dateOf("completeDate").toString("%Y-%m-%d")).as("date")
                .and("price").as("price");
        AddFieldsOperation addDate = Aggregation.addFields().addField("convertedDate").withValue(Document.parse( "{ $toDate: \"$date\" } ")).build();
        GroupOperation countOrdersPerDay = Aggregation.group("convertedDate").count().as("countOrders")
                .sum("price").as("sumPrice");
        SortOperation sortByDate = Aggregation.sort(Sort.by(Sort.Direction.ASC, "_id"));


        Aggregation aggregation = Aggregation.newAggregation(
                greaterThan,
                lessThan,
                completeDate,
                addDate,
                countOrdersPerDay,
                sortByDate
        );

        System.out.println(aggregation.toString());

        Flux<OrderStatisticTo> result = mongo.aggregate(aggregation, Order.class, OrderStatisticTo.class);
        return result;

    }
}
