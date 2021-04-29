package com.company.AmsuWarnerCapstone.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// CLASS ANNOTATIONS
@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)


public class ConsoleControllerTest {
    // WRITING THE MOCK MVC TEST OBJECT
    @Autowired
    private MockMvc mockMvc;

    // TEST GET "/console"
    @Test
    public void getConsole() throws Exception {
        // ACTION
        mockMvc.perform(get("/console"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}