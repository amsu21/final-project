package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.Games;

import java.util.List;

public interface GamesInventoryDao {
    Games getGames(int id);

    List<Games> getAllGames();

    List<Games> getGamesByStudio(String name);

    Games addGames(Games games);

    void updateGames(Games games);

    void deleteGames(int id);
}
