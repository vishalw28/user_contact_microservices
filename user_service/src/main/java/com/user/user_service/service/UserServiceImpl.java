package com.user.user_service.service;

import com.user.user_service.entity.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    List<User> list = Arrays.asList(new User(1L, "Vishal Wagh", "9035512755"),
            new User(2L, "Pravin Kadam", "1234567890"),
            new User(3L, "Vaibhav Kadam", "0987654321"));

    @Override
    public User getUser(Long userId) {
        return list.stream().filter(user -> user.getUserId().equals(userId)).findAny().orElse(null);
    }
}
