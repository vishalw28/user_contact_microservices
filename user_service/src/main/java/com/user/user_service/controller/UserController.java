package com.user.user_service.controller;

import com.user.user_service.entity.Contact;
import com.user.user_service.entity.User;
import com.user.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final RestTemplate restTemplate;

    @Autowired
    public UserController(UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        User user = this.userService.getUser(userId);
//        http://localhost:9002/contact/1
        List<Contact> list = restTemplate.getForObject("http://contact-service:9002/contact/"+user.getUserId(), List.class);
        user.setContacts(list);
        return user;
    }
}
