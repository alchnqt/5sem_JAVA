package com.example.lab1.services.impl;

import com.example.lab1.model.User;
import com.example.lab1.repository.UserRepository;
import com.example.lab1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository usersRepository;

    @Override
    public Optional<User> getByName(String name) {
        return usersRepository.findByName(name);
    }

    @Override
    public void add(User user) throws Exception{
        if (!usersRepository.findByName(user.getUserLogin()).isEmpty()) {
            throw new Exception("User has already registered");
        }
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword())
                );
        usersRepository.saveAndFlush(user);
    }
}
