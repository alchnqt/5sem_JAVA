package com.example.lab1.controller;


import com.example.lab1.dto.ItemDTO;
import com.example.lab1.logging.Loggable;
import com.example.lab1.services.ItemService;
import com.example.lab1.validation.ItemValidator;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/user/items")
class ItemController {
    private final ItemService itemService;
    private final ItemValidator itemValidator;
    @Autowired
    public ItemController(ItemService itemService, ItemValidator itemValidator) {
        this.itemService = itemService;
        this.itemValidator = itemValidator;
    }
    //, produces = { "application/json" , "application/xml"}
    @GetMapping(value = {"/all"})
    @Loggable
    public List<ItemDTO> personList() {
        return itemService.getAll();
    }
    @GetMapping(value = {"/{name}"})
    public ItemDTO findByName(@PathVariable("name") String name) throws
            ResourceNotFoundException {
        return itemService.findByName(name);
    }

    @Loggable
    @PutMapping(value = "/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editItem(@PathVariable("name") String name) throws ResourceNotFoundException {
        itemService.edit(ItemDTO.ConvertToItem(itemService.findByName(name)));
    }

    @Loggable
    @PostMapping("/add")
    public ResponseEntity<?> saveItem(ItemDTO item) {
        final DataBinder dataBinder = new DataBinder(item);
        dataBinder.addValidators(itemValidator);
        dataBinder.validate();
        if(dataBinder.getBindingResult().hasErrors()){
             return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name error");
        }
        itemService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body("Created item");
    }

    @Loggable
    @DeleteMapping(value = "/delete/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable("name") String name) throws
            ResourceNotFoundException {
        itemService.deleteByName(name);
    }
}

