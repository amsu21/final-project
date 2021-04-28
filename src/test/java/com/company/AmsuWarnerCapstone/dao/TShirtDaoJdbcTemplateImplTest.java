package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoJdbcTemplateImplTest {

    // SET UP DAO
    @Autowired
    private TShirtInventoryDao tShirtInventoryDao;

    @Before
    public void setUp() throws Exception {
        // TSHIRT
        List<TShirt> tShirtList = tShirtInventoryDao.getAllTShirts();
        for (TShirt t : tShirtList) {
            tShirtInventoryDao.deleteTShirt(t.getT_shirt_id());
        }
    }

    @Test
    public void addGetDeleteTShirt() {
        // TSHIRT
        TShirt tShirt = new TShirt();
    }

    // GET ALL TSHIRTS
    @Test
    public void getAllTShirts() {
        // ARRANGE
        TShirt tShirt = new TShirt();
        tShirt.setSize("Large");
        tShirt.setColor("Red");
        tShirt.setDescription("Graphic Tee");
        tShirt.setPrice(new BigDecimal("12.99"));
        tShirt.setQuantity(1);

        // ADD ACTION
        tShirtInventoryDao.addTShirt(tShirt);
        tShirt = new TShirt();
    }

    // UPDATE
    @Test
    public void updateTShirt() {
        // ARRANGE
        TShirt tShirt = new TShirt();
        tShirt.setSize("Large");
        tShirt.setColor("Red");
        tShirt.setDescription("Graphic Tee");
        tShirt.setPrice(new BigDecimal("12.99"));
        tShirt.setQuantity(1);
    }

}