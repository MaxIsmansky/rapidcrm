package com.rapidsystems.soft.project.dao.orderDao;

import com.rapidsystems.soft.project.model.dto.OperationStatusResponse;
import com.rapidsystems.soft.project.model.order.Order;
import com.rapidsystems.soft.project.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class OrderDaoImpl implements OrderDao<Order, OperationStatusResponse>  {

    private final OrderRepository orderRepository;

    @Override
    public Mono<Order> findById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public Flux<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Mono<Order> save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Mono<Order> update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Mono<OperationStatusResponse> deleteById(String id) {
        orderRepository.deleteById(id).subscribe();
        return Mono.just(new OperationStatusResponse(true));
    }

    @Override
    public Mono<Order> updateProcessingOrder(Order order) {
        return orderRepository.save(order);
    }


    public Mono<Order> findById(String id, String userId) {
        return orderRepository.findById(id)
                .filter(order -> order.getUserId().equals(userId));
    }


    public Flux<Order> findAll(String userId) {
        return orderRepository.findAll()
                .filter(order -> order.getUserId().equals(userId));
    }



    public Flux<Order> findAllNotCompleted() {
        return orderRepository.findAll()
                .filter(order -> order.getCompleteDate() == null);
    }

    public Flux<Order> findAllNotInProcess() {
        return orderRepository.findAll()
                .filter(order -> order.getStartInProgressDate() == null);
    }


    public Mono<Order> save(Order order, String userId) {
        if (order.getId()!= null && findById(order.getId(), userId) == null) {
            return null;
        }
        return orderRepository.save(order);
    }


    public Mono<Order> update(Order order, String userId) {
        if (order.getId()!= null && findById(order.getId(), userId) == null) {
            return null;
        }
        return orderRepository.save(order);
    }



}
