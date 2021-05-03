package com.company.AmsuWarnerCapstone.service;


import com.company.AmsuWarnerCapstone.dao.ConsolesInventoryDao;
import com.company.AmsuWarnerCapstone.dao.GamesInventoryDao;
import com.company.AmsuWarnerCapstone.dao.TShirtInventoryDao;
import com.company.AmsuWarnerCapstone.dto.Games;
import com.company.AmsuWarnerCapstone.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceLayer {
    private ConsolesInventoryDao consolesInventoryDao;
    private GamesInventoryDao gamesInventoryDao;
    private TShirtInventoryDao tShirtInventoryDao;

    @Autowired
    public ServiceLayer(ConsolesInventoryDao consolesInventoryDao, GamesInventoryDao gamesInventoryDao, TShirtInventoryDao tShirtInventoryDao) {
        this.consolesInventoryDao = consolesInventoryDao;
        this.gamesInventoryDao = gamesInventoryDao;
        this.tShirtInventoryDao = tShirtInventoryDao;
    }

    // GET GAMES
    public List<Games> getAllGames() {
        return gamesInventoryDao.getAllGames();
    }

    // GET GAMES BY STUDIO
    public List<Games> getGamesByStudio(String studio) {
       return gamesInventoryDao.getGamesByStudio(studio);
    }

    // GET GAMES BY ESRB RATING
    public List<Games> getGamesByESRB(String rating) {
        return gamesInventoryDao.getGamesByESRB(rating);
    }

    // GET GAMES BY TITLE
    public List<Games> getGamesByTitle(String title) {
        return gamesInventoryDao.getGamesByTitle(title);
    }


    // *TSHIRTS SECTION*

    // GET TSHIRTS
    public List<TShirt> getAllTShirts() {
        return tShirtInventoryDao.getAllTShirts();
    }

    // GET TSHIRTS BY COLOR
    public List<TShirt> getTShirtsByColor(String color) {
        return tShirtInventoryDao.getTShirtsByColor(color);
    }

    // GET TSHIRTS BY SIZE
    public List<TShirt> getTShirtsBySize(String size) {
        return tShirtInventoryDao.getTShirtsBySize(size);
    }

}