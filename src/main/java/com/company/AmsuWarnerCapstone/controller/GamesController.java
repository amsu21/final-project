package com.company.AmsuWarnerCapstone.controller;

import com.company.AmsuWarnerCapstone.dao.GamesInventoryDao;
import com.company.AmsuWarnerCapstone.dto.Games;
import com.company.AmsuWarnerCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GamesController {
    @Autowired
    ServiceLayer serviceLayer;

    // GET ALL GAMES
    // METHOD NOTATION
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Games> getGames() {
        // return serviceLayer.getAllGames();
        return null;
    }

    // GET GAMES BY STUDIO
    // METHOD NOTATION
    @RequestMapping(value = "/game/studio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Games> getGamesByStudio(@PathVariable String studio) {
        return serviceLayer.getGamesByStudio(studio);
    }
}
