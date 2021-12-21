package com.example.lab1.repository;

import com.example.lab1.model.Task;
import com.example.lab1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT TOP 1 * FROM users WHERE userLogin = ?1", nativeQuery = true)
    Optional<User> findByName(String name);
}
