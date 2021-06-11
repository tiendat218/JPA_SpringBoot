package com.example.authen.service;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}

