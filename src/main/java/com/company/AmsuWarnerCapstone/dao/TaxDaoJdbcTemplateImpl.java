package com.company.AmsuWarnerCapstone.dao;


import com.company.AmsuWarnerCapstone.dto.Tax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TaxDaoJdbcTemplateImpl implements TaxDao {
    // PREPARED STATEMENTS
    private static final String INSERT_TAX_SQL =
            "Insert into sales_tax_rate (state, rate) values (?, ?)";
    private static final String SELECT_TAX_SQL =
            "Select * From sales_tax_rate";
    private static final String SELECT_ALL_TAX_SQL =
            "Select * From sales_tax_rate";
    private static final String DELETE_TAX_SQL =
            "Delete from sales_tax_rate";
    private static final String UPDATE_TAX_SQL =
            "Update sales_tax_rate set state = ?, rate = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TaxDaoJdbcTemplateImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Tax getTax(String state) {
        return null;
    }

    // ROW MAPPER
    private Tax mapToRowTax(ResultSet rs, int rowNumber) throws SQLException {
        Tax tax = new Tax();
        tax.setState(rs.getString("state"));
        tax.setRate(rs.getBigDecimal("rate"));

        return tax;
    }
}
