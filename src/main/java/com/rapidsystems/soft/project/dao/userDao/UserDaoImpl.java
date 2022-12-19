package com.rapidsystems.soft.project.dao.userDao;

import com.rapidsystems.soft.project.model.dto.OperationStatusResponse;
import com.rapidsystems.soft.project.model.plate.ProductPlate;
import com.rapidsystems.soft.project.model.user.SecurityUser;
import com.rapidsystems.soft.project.model.user.User;
import com.rapidsystems.soft.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao<SecurityUser, OperationStatusResponse>, ReactiveUserDetailsService {

    private final UserRepository userRepository;

    @Override
    public Mono<SecurityUser> findById(String id) {
        return userRepository.findById(id);
    }
    @Override
    public Flux<SecurityUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<SecurityUser> save(SecurityUser user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<SecurityUser> update(SecurityUser user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<OperationStatusResponse> deleteById(String id) {
        userRepository.deleteById(id).subscribe();
        return Mono.just(new OperationStatusResponse(true));
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .cast(UserDetails.class);
    }
}
