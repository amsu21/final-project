package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProcessingFeeJdbcTemplateImpl implements ProcessingFeeDao {
    // PREPARED STATEMENTS
    private static final String SELECT_PROCESSINGFEE_SQL =
            "Select * From processing_fee where product_type = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeJdbcTemplateImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProcessingFee getProcessingFee(String productType) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PROCESSINGFEE_SQL, this::mapToRowProcessingFee, productType);
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public BigDecimal getFeeNum(String productType) {
        ProcessingFee processingFee = this.getProcessingFee(productType);
        return processingFee.getFee();

    }





    // ROW MAPPER
    private ProcessingFee mapToRowProcessingFee(ResultSet rs, int rowNumber) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));

        return processingFee;
    }



}

