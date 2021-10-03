package com.example.lab1.services.impl;

import com.example.lab1.dto.ItemDTO;
import com.example.lab1.model.Item;
import com.example.lab1.model.Song;
import com.example.lab1.repository.ItemRepository;
import com.example.lab1.repository.SongRepository;
import com.example.lab1.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Override
    public void add(ItemDTO item) {
        itemRepository.saveAndFlush(ItemDTO.ConvertToItem(item));
    }

    @Override
    public List<ItemDTO> getAll() {
        List<ItemDTO> items = new ArrayList<ItemDTO>();
        for (var item:
                itemRepository.findAll()) {
            items.add(ItemDTO.ConvertToItemDTO(item));
        }
        return items;
    }

    @Override
    public ItemDTO findByName(String name) {
        return ItemDTO.ConvertToItemDTO(itemRepository.findByName(name));
    }

    @Override
    public void edit(Item editableItem) {
        Item item = itemRepository.findByName(editableItem.getName());
    }
    @Override
    public void deleteByName(String name) {
        Item item = itemRepository.findByName(name);
        itemRepository.delete(item);
    }
}
