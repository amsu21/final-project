package com.company.AmsuWarnerCapstone.controller;

import com.company.AmsuWarnerCapstone.dto.Consoles;
import com.company.AmsuWarnerCapstone.dto.Games;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsoleController {
    // private final List<Consoles> consolesList;
    private static int idCounter = 1;

    // GET ALL CONSOLES
    // METHOD NOTATIONS
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Consoles getConsole() {
        // return Consoles;
        return null;
    }
}
