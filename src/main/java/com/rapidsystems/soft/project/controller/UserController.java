package com.rapidsystems.soft.project.controller;

import com.rapidsystems.soft.project.dao.UserDao;
import com.rapidsystems.soft.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/api/users/{id}")
    public Mono<User> getById(@PathVariable Long id) {
        return userDao.findById(id);
    }
}
