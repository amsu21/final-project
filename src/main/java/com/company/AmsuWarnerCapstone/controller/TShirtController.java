package com.company.AmsuWarnerCapstone.controller;

import com.company.AmsuWarnerCapstone.dao.TShirtInventoryDao;
import com.company.AmsuWarnerCapstone.dto.TShirt;
import com.company.AmsuWarnerCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TShirtController {
    @Autowired
    ServiceLayer serviceLayer;

    // GET ALL TSHIRTS
    // METHOD NOTATIONS
    @RequestMapping(value = "/tshirt", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getTShirt() {
        return serviceLayer.getAllTShirts();
    }

    // GET ALL TSHIRTS BY COLOR
    // METHOD NOTATION
    @RequestMapping(value = "/tshirt/color{color}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getTShirtsByColor(@PathVariable String color) {
        return serviceLayer.getTShirtsByColor(color);
    }
}
