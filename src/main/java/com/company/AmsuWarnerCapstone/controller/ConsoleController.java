package com.company.AmsuWarnerCapstone.controller;

import com.company.AmsuWarnerCapstone.dto.Consoles;
import com.company.AmsuWarnerCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsoleController {
    @Autowired
    ServiceLayer serviceLayer;

    // GET ALL CONSOLES
    // METHOD NOTATIONS
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Consoles> getConsole() {
        return serviceLayer.getAllConsoles();
    }

    // GET CONSOLES BY MANUFACTURER
    // METHOD NOTATIONS
    @RequestMapping(value = "/console/manufact/{brand}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Consoles> getAllConsolesByManufacturer(@PathVariable String brand) {
        return serviceLayer.getAllConsolesByManufacturer(brand);
    }
}
