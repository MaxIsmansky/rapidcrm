package com.rapidsystems.soft.project.dao;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Dao<T, R> {

    Mono<T> findById(String id);

    Flux<T> findAll();

    Mono<T> save(T t);

    Mono<T> update(T t);

    Mono<R> deleteById(String id);

}
