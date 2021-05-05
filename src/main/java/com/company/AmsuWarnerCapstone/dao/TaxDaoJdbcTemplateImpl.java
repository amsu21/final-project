package com.company.AmsuWarnerCapstone.dao;


import com.company.AmsuWarnerCapstone.dto.Tax;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TaxDaoJdbcTemplateImpl implements TaxDao {
    // PREPARED STATEMENTS
    private static final String SELECT_TAX_SQL =
            "Select * From sales_tax_rate";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TaxDaoJdbcTemplateImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Tax getTax(String state) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TAX_SQL, this::mapToRowTax, state);
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public BigDecimal getRate(String state) {
        Tax tax = this.getTax(state);
        return tax.getRate();
    }

    // ROW MAPPER
    private Tax mapToRowTax(ResultSet rs, int rowNumber) throws SQLException {
        Tax tax = new Tax();
        tax.setState(rs.getString("state"));
        tax.setRate(rs.getBigDecimal("rate"));

        return tax;
    }
}
