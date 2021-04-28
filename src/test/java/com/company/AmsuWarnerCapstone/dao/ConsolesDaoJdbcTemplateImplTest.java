package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.Consoles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsolesDaoJdbcTemplateImplTest {

    // SET UP DAO
    @Autowired
    private ConsolesInventoryDao consolesInventoryDao;

    @Before
    public void setUp() throws Exception {
        // CONSOLE
        List<Consoles> consolesList = consolesInventoryDao.getAllConsoles();
        for (Consoles c : consolesList) {
            consolesInventoryDao.deleteConsoles(c.getConsole_id());
        }
    }

    @Test
    public void addGetDeleteConsole() {
        // CONSOLE
        Consoles consoles = new Consoles();
    }

    // GET ALL CONSOLES
    @Test
    public void getAllConsoles() {
        // ARRANGE
        Consoles consoles = new Consoles();
        consoles.setModel("PS5");
        consoles.setManufacturer("Sony");
        consoles.setMemory_amount("1TB");
        consoles.setProcessor("GPU");
        consoles.setPrice(new BigDecimal("499.00"));
        consoles.setQuantity(1);


        // ADD ACTION
        consolesInventoryDao.addConsoles(consoles);
        consoles = new Consoles();
    }

}