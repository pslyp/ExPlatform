package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import com.training.platform.services.UserService;
import com.training.platform.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class DemoController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "")
    public String index() {
        return "Hello Spring Boot";
    }

    @GetMapping(value = "user")
    public List<User> show() {
        return userService.findAll();
    }

}
