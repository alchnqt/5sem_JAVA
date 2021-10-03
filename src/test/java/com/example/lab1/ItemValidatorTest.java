package com.example.lab1;

import com.example.lab1.dto.ItemDTO;
import org.junit.Assert;
import com.example.lab1.services.ItemService;
import com.example.lab1.validation.ItemValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.DataBinder;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;

@SpringBootTest
public class ItemValidatorTest {

    @Autowired
    private ItemValidator itemValidator;
    @Autowired
    private ItemService itemService;

    @Test
    void Test(){
        ItemDTO item = itemService.findByName("Shirt");

        final DataBinder dataBinder = new DataBinder(item);
        dataBinder.addValidators(itemValidator);
        dataBinder.validate();

        Assert.assertTrue(dataBinder.getBindingResult().hasErrors());
    }

    @Test
    void Test2(){
        ItemDTO item = itemService.findByName("Shirt");
        Assert.assertTrue(item != null);
    }

    @Test
    void Test3(){
        List<ItemDTO> item = itemService.getAll();
        Assert.assertFalse(item == null);
    }

    @Test
    void Test4(){
        assertThrows(
                NullPointerException.class,
                () -> itemService.findByName("asdasd"),
                "Expected doThing() to throw, but it didn't"
        );
    }
}
