package com.company.AmsuWarnerCapstone.controller;

import com.company.AmsuWarnerCapstone.dao.TShirtInventoryDao;
import com.company.AmsuWarnerCapstone.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TShirtController {
    @Autowired
    TShirtInventoryDao tShirtInventoryDao;

    // GET ALL TSHIRTS
    // METHOD NOTATIONS
    @RequestMapping(value = "/tshirt", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getTShirt() {
        return tShirtInventoryDao.getAllTShirts();
    }
}
