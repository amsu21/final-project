package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.Games;
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
public class GamesDaoJdbcTemplateImplTest {

    // SET UP DAO
    @Autowired
    private GamesInventoryDao gamesInventoryDao;

    @Before
    public void setUp() throws Exception {
        // GAMES
        List<Games> gamesList = gamesInventoryDao.getAllGames();
        for (Games g: gamesList) {
            gamesInventoryDao.deleteGames(g.getGameId());
        }
    }

    @Test
    public void addGetDeleteGames() {
        // GAMES
        Games games = new Games();
    }

    // GET ALL GAMES
    @Test
    public void getAllGames() {
        // ARRANGE
        Games games = new Games();
        games.setTitle("NBA 2K");
        games.setEsrb_rating("E");
        games.setDescription("Sports Game");
        games.setPrice(new BigDecimal("59.99"));
        games.setStudio("Visual Concepts");
        games.setQuantity(1);

        // ADD ACTION
        gamesInventoryDao.addGames(games);
        games = new Games();
    }
}