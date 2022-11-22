package com.rapidsystems.soft.project.dao;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Dao<T> {

    public Mono<T> findById(Long id);

    public Flux<T> findAll();

    public Mono<T> save(T t);

}
