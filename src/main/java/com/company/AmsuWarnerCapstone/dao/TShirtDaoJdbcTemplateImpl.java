package com.company.AmsuWarnerCapstone.dao;


import com.company.AmsuWarnerCapstone.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtInventoryDao {
    // PREPARED STATEMENTS
    private static final String INSERT_TSHIRT_SQL =
            "Insert into t_shirt (size, color, description, price, quantity) values (?, ?, ?, ?, ?)";
    private static final String SELECT_TSHIRT_SQL =
            "Select * From t_shirt where t_shirt_id = ?";
    private static final String SELECT_ALL_TSHIRT_SQL =
            "Select * From t_shirt";
    private static final String DELETE_TSHIRT_SQL =
            "Delete from t_shirt where t_shirt_id = ?";
    private static final String UPDATE_TSHIRT_SQL =
            "Update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";
    private static final String SELECT_TSHIRT_BY_COLOR_SQL =
            "Select * From t_shirt where color = ?";
    private static final String SELECT_TSHIRT_BY_SIZE_SQL =
            "Select * From t_shirt where size = ?";

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public TShirtDaoJdbcTemplateImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public TShirt getTShirt(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TSHIRT_SQL, this::mapRowToTShirt, id);
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // GET ALL TSHIRTS
    @Override
    public List<TShirt> getAllTShirts() {
        return jdbcTemplate.query(SELECT_ALL_TSHIRT_SQL, this::mapRowToTShirt);
    }

    // GET TSHIRTS BY COLOR
    @Transactional
    @Override
    public List<TShirt> getTShirtsByColor(String color) {
        return jdbcTemplate.query(SELECT_TSHIRT_BY_COLOR_SQL, this::mapRowToTShirt, color);
    }

    // GET TSHIRTS BY SIZE
    @Override
    public List<TShirt> getTShirtsBySize(String size) {
        return jdbcTemplate.query(SELECT_TSHIRT_BY_SIZE_SQL, this::mapRowToTShirt, size);
    }

    // ADD A TSHIRT
    @Transactional
    @Override
    public TShirt addTShirt(TShirt tShirt) {
        jdbcTemplate.update(INSERT_TSHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        tShirt.setT_shirt_id(id);

        return tShirt;
    }

    // UPDATE
    @Override
    public void updateTShirt(TShirt tShirt) {
        jdbcTemplate.update(UPDATE_TSHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity());
    }

    // DELETE
    @Override
    public void deleteTShirt(int id) {
        jdbcTemplate.update(DELETE_TSHIRT_SQL, id);
    }

    //  ROW MAPPER
    private TShirt mapRowToTShirt(ResultSet rs, int rowNumber) throws SQLException {
        TShirt tShirt = new TShirt();
        tShirt.setT_shirt_id(rs.getInt("t_shirt_id"));
        tShirt.setSize(rs.getString("size"));
        tShirt.setColor(rs.getString("color"));
        tShirt.setDescription(rs.getString("description"));
        tShirt.setPrice(rs.getBigDecimal("price"));
        tShirt.setQuantity(rs.getInt("quantity"));

        return tShirt;
    }
}
