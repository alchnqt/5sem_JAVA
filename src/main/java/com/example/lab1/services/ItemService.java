package com.example.lab1.services;

import com.example.lab1.dto.ItemDTO;
import com.example.lab1.model.Item;
import com.example.lab1.model.Song;

import java.util.List;

public interface ItemService {
    void add(ItemDTO song);

    List<ItemDTO> getAll();

    ItemDTO findByName(String name);

    void edit(Item name);

    void deleteByName(String name);
}
