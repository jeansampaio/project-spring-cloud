package com.wysoft.user.controller;

import com.wysoft.user.VO.ResponseTempleteVO;
import com.wysoft.user.entity.User;
import com.wysoft.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTempleteVO getUserWithfindUserById(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithfindUserById method of UserController");
        return userService.getUserWithfindUserById(userId);
    }
}
