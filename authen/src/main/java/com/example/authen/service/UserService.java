package com.example.authen.service;


import com.example.authen.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
