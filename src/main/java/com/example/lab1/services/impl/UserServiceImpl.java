package com.example.lab1.services.impl;

import com.example.lab1.model.User;
import com.example.lab1.repository.UserRepository;
import com.example.lab1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository usersRepository;

    @Override
    public Optional<User> getByName(String name) {
        return usersRepository.findByName(name);
    }

    @Override
    public void add(User user) {
        usersRepository.saveAndFlush(user);
    }
}
