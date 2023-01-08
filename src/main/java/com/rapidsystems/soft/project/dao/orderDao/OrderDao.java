package com.rapidsystems.soft.project.dao.orderDao;

import com.rapidsystems.soft.project.dao.Dao;
import com.rapidsystems.soft.project.model.order.Order;
import org.springframework.data.mongodb.repository.Query;
import reactor.core.publisher.Mono;

public interface OrderDao<T,R> extends Dao<T,R> {

    public Mono<Order> updateProcessingOrder(Order order);


}
