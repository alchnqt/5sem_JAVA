package com.example.lab1.services;

import com.example.lab1.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getByName(String name);
    void add(User user) throws Exception;
}
