package com.example.lab1.repository;

import com.example.lab1.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    @Query(value = "SELECT * FROM ITEM WHERE name = ?1 LIMIT 1", nativeQuery = true)
    Item findByName(String name);

    @Modifying
    @Query(value = "UPDATE ITEM SET name = ?2, description = ?3, " +
            "company = ?4, price = ?5, category = ?6 " +
            "WHERE ITEM.id = ?1", nativeQuery = true)
    void updateItem(UUID id,
                    String name,
                    String description,
                    String company,
                    BigDecimal price,
                    String category);

}
