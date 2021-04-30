package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeJdbcTemplateImpl implements ProcessingFeeDao {
    // PREPARED STATEMENTS



    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeJdbcTemplateImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProcessingFee getProcessingFee(String productType) {
        return null;
    }



    // ROW MAPPER
    private ProcessingFee mapTorowProcessingFee(ResultSet rs, int rowNumber) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));

        return processingFee;
    }
}
