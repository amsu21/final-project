package com.company.AmsuWarnerCapstone.service;


import com.company.AmsuWarnerCapstone.dao.ConsolesInventoryDao;
import com.company.AmsuWarnerCapstone.dao.GamesInventoryDao;
import com.company.AmsuWarnerCapstone.dao.TShirtInventoryDao;
import com.company.AmsuWarnerCapstone.dto.Games;
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

    // GET GAMES BY STUDIO
    public List<Games> getGamesByStudio(String studio) {
       return gamesInventoryDao.getGamesByStudio(studio);
    }

}