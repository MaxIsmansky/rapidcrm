package com.rapidsystems.soft.project.dao.userDao;

import com.rapidsystems.soft.project.model.dto.OperationStatusResponse;
import com.rapidsystems.soft.project.model.plate.ProductPlate;
import com.rapidsystems.soft.project.model.user.User;
import com.rapidsystems.soft.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao<User, OperationStatusResponse> {


    private final UserRepository userRepository;


    @Override
    public Mono<User> findById(String id) {
        return userRepository.findById(id);
    }
    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<OperationStatusResponse> deleteById(String id) {
        userRepository.deleteById(id).subscribe();
        return Mono.just(new OperationStatusResponse(true));
    }
}
