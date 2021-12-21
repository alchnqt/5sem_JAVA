package com.example.lab1.repository;

import com.example.lab1.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    @Query(value = "SELECT TOP 1 * FROM items WHERE name = ?1", nativeQuery = true)
    Item findByName(String name);

    @Query(value = "SELECT * FROM items ORDER BY id OFFSET (?1) ROWS FETCH NEXT (?2) ROWS ONLY", nativeQuery = true)
    List<Item> AllInRange(int from, int to);
}
