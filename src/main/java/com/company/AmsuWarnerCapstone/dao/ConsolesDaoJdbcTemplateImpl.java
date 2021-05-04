package com.company.AmsuWarnerCapstone.dao;


import com.company.AmsuWarnerCapstone.dto.Consoles;
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
public class ConsolesDaoJdbcTemplateImpl implements ConsolesInventoryDao {
    // PREPARED STATEMENTS
    private static final String INSERT_CONSOLE_SQL =
            "Insert into console (model, manufacturer, memory_amount, processor, price, quantity) values (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_CONSOLE_SQL =
            "Select * From console where console_id = ?";
    private static final String SELECT_ALL_CONSOLE_SQL =
            "Select * From console";
    private static final String DELETE_CONSOLE_SQL =
            "Delete from console where console_id = ?";
    private static final String UPDATE_CONSOLE_SQL =
            "Update console set model = ?, manufacturer = ?, memory_amount = ?, processor = ?, price = ?, quantity = ? where console_id = ?";
    private static final String SELECT_CONSOLE_BY_MANU_SQL =
            "Select * From game where manufacturer = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsolesDaoJdbcTemplateImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Consoles getConsoles(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CONSOLE_SQL, this::mapRowToConsole, id);
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // GET ALL CONSOLES
    @Transactional
    @Override
    public List<Consoles> getAllConsoles() {
        return jdbcTemplate.query(SELECT_ALL_CONSOLE_SQL, this::mapRowToConsole);
    }

    // GET CONSOLES BY MANUFACTURER
    @Transactional
    @Override
    public List<Consoles> getConsolesByManufacturer(String brand) {
        return jdbcTemplate.query(SELECT_CONSOLE_BY_MANU_SQL, this::mapRowToConsole, brand);
    }

    // ADD A CONSOLE
    @Transactional
    @Override
    public Consoles addConsoles(Consoles consoles) {
        jdbcTemplate.update(INSERT_CONSOLE_SQL,
                consoles.getModel(),
                consoles.getManufacturer(),
                consoles.getMemory_amount(),
                consoles.getProcessor(),
                consoles.getPrice(),
                consoles.getQuantity());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        consoles.setConsole_id(id);

        return consoles;
    }

    @Override
    public void updateConsoles(Consoles consoles) {
        jdbcTemplate.update(UPDATE_CONSOLE_SQL,
                consoles.getModel(),
                consoles.getManufacturer(),
                consoles.getMemory_amount(),
                consoles.getProcessor(),
                consoles.getPrice(),
                consoles.getQuantity(),
                consoles.getConsole_id());
    }

    // DELETE A CONSOLE
    @Override
    public void deleteConsoles(int id) {
        jdbcTemplate.update(DELETE_CONSOLE_SQL, id);
    }

    // ROW MAPPER
    private Consoles mapRowToConsole(ResultSet rs, int rowNumber) throws SQLException {
        Consoles consoles = new Consoles();
        consoles.setConsole_id(rs.getInt("console_id"));
        consoles.setModel(rs.getString("model"));
        consoles.setManufacturer(rs.getString("manufacturer"));
        consoles.setMemory_amount(rs.getString("memory_amount"));
        consoles.setProcessor(rs.getString("processor"));
        consoles.setPrice(rs.getBigDecimal("price"));
        consoles.setQuantity(rs.getInt("quantity"));

        return consoles;
    }
}
