package com.company.AmsuWarnerCapstone.dao;


import com.company.AmsuWarnerCapstone.dto.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.beans.Transient;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GamesDaoJdbcTemplateImpl implements GamesInventoryDao {
    // PREPARED STATEMENTS
    private static final String INSERT_GAME_SQL =
            "Insert into game (title, esrb_rating, description, price, studio, quantity) values (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_GAME_SQL =
            "Select * From game where game_id = ?";
    private static final String SELECT_ALL_GAME_SQL =
            "Select * From game";
    private static final String DELETE_GAME_SQL =
            "Delete from game where game_id = ?";
    private static final String UPDATE_GAME_SQL =
            "Update game set title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? where game_id = ?";
    private static final String SELECT_GAMES_BY_STUDIO_SQL =
            "Select * From game where studio = ?";
    private static final String SELECT_GAME_BY_ESRB_SQL =
            "Select * From game where esrb_rating = ?";
    private static final String SELECT_GAME_BY_TITLE_SQL =
            "Select * From game where title = ?";



    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GamesDaoJdbcTemplateImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Games getGames(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, id);
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // GET ALL GAMES
    @Transactional
    @Override
    public List<Games> getAllGames() {
        return jdbcTemplate.query(SELECT_ALL_GAME_SQL, this::mapRowToGame);
    }

    // GET GAMES BY STUDIO
    @Transactional
    @Override
    public List<Games> getGamesByStudio(String name) {
        return jdbcTemplate.query(SELECT_GAMES_BY_STUDIO_SQL, this::mapRowToGame, name);
    }

    // GET GAMES BY ESRB_RATING
    @Transactional
    @Override
    public List<Games> getGamesByESRB(String rating) {
        return jdbcTemplate.query(SELECT_GAME_BY_ESRB_SQL, this::mapRowToGame, rating);
    }

    // GET GAMES BY TITLE
    @Transactional
    @Override
    public List<Games> getGamesByTitle(String title) {
        return jdbcTemplate.query(SELECT_GAME_BY_TITLE_SQL, this::mapRowToGame, title);
    }


    // ADD A GAME
    @Transactional
    @Override
    public Games addGames(Games games) {
        jdbcTemplate.update(INSERT_GAME_SQL,
                games.getTitle(),
                games.getEsrb_rating(),
                games.getDescription(),
                games.getPrice(),
                games.getStudio(),
                games.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        games.setGameId(id);

        return games;
    }

    // UPDATE GAME
    @Override
    public void updateGames(Games games) {
    jdbcTemplate.update(UPDATE_GAME_SQL,
            games.getTitle(),
            games.getEsrb_rating(),
            games.getDescription(),
            games.getPrice(),
            games.getStudio(),
            games.getQuantity(),
            games.getGameId());
    }

    // DELETE GAME
    @Override
    public void deleteGames(int id) {
        jdbcTemplate.update(DELETE_GAME_SQL, id);
    }

    // ROW MAPPER
    private Games mapRowToGame(ResultSet rs, int rowNumber) throws SQLException {
        Games games = new Games();
        games.setGameId(rs.getInt("game_id"));
        games.setTitle(rs.getString("title"));
        games.setEsrb_rating(rs.getString("esrb_rating"));
        games.setDescription(rs.getString("description"));
        games.setPrice(rs.getBigDecimal("price"));
        games.setStudio(rs.getString("studio"));
        games.setQuantity(rs.getInt("quantity"));

        return games;
    }

}
