package com.example.lab1.repository;

import com.example.lab1.model.Company;
import com.example.lab1.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
