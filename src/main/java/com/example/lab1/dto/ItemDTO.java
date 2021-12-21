package com.example.lab1.dto;

import com.example.lab1.model.Item;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class ItemDTO {
    private String name;

    private String description;

    private BigDecimal price;

    private String category;

    private String company;

    public static Item ConvertToItem(ItemDTO item){
        Item obj = new Item();
        obj.setId(UUID.randomUUID().toString());
        obj.setCreatedTime(new Date());
        obj.setName(item.name);
        obj.setDescription(item.description);
        obj.setCategory(item.category);
        obj.setCompany(item.company);
        obj.setPrice(item.price);
        return obj;
    }

    public static ItemDTO ConvertToItemDTO(Item item){
        ItemDTO obj = new ItemDTO();
        obj.setName(item.getName());
        obj.setDescription(item.getDescription());
        obj.setCategory(item.getCategory());
        obj.setCompany(item.getCompany());
        obj.setPrice(item.getPrice());
        return obj;
    }

    public ItemDTO(){

    }

    public ItemDTO(String name, String description, BigDecimal price, String category,
                   String company){
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
