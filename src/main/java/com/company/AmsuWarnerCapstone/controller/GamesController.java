package com.company.AmsuWarnerCapstone.controller;

import com.company.AmsuWarnerCapstone.dto.Games;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamesController {
    private static int idCounter = 1;

    // GET ALL GAMES
    // METHOD NOTATION
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Games getGames() {
        return null;
    }
}
