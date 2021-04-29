package com.company.AmsuWarnerCapstone.controller;

import com.company.AmsuWarnerCapstone.dao.GamesInventoryDao;
import com.company.AmsuWarnerCapstone.dto.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GamesController {
    @Autowired
    GamesInventoryDao gamesInventoryDao;

    // GET ALL GAMES
    // METHOD NOTATION
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Games> getGames() {
        return gamesInventoryDao.getAllGames();
    }
}
