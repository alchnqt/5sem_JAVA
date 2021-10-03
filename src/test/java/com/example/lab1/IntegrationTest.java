package com.example.lab1;

import com.example.lab1.dto.ItemDTO;
import com.example.lab1.model.Item;
import com.example.lab1.services.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class IntegrationTest {
    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    protected void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void Test1() throws Exception {
        setUp();
        mockMvc.perform(MockMvcRequestBuilders.get("/api/java/items/all"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void Test2() throws Exception {
        setUp();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/java/items/add"))
                .andExpect(status().is4xxClientError());
    }
}