package com.example.lab1.validation;

import com.example.lab1.dto.ItemDTO;
import com.example.lab1.services.ItemService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Service
public class ItemValidator implements Validator {
    private final ItemService itemService;

    public ItemValidator(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return ItemDTO.class.equals(aClass);
    }

    @SneakyThrows
    @Override
    public void validate(Object o, Errors errors) {
        ItemDTO item = (ItemDTO) o;

        try{
            if (itemService.findByName(item.getName()) != null) {
                errors.rejectValue("name", "", "This name is already exists");
            }
        }
        catch (Exception e){

        }

    }
}
