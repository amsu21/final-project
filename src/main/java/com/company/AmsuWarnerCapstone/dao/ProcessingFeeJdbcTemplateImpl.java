package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProcessingFeeJdbcTemplateImpl implements ProcessingFeeDao {
    // PREPARED STATEMENTS
    private static final String INSERT_PROCESSINGFEE_SQL =
            "Insert into processing_fee (title, esrb_rating, description, price, studio, quantity) values (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_PROCESSINGFEE_SQL =
            "Select * From processing_fee where processing_fee_id = ?";
    private static final String SELECT_ALL_PROCESSINGFEE_SQL =
            "Select * From game";
    private static final String DELETE_PROCESSINGFEE_SQL =
            "Delete from game where game_id = ?";
    private static final String UPDATE_PROCESSINGFEE_SQL =
            "Update processing_fee set title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? where game_id = ?";
    private static final String SELECT_PROCESSINGFEE_BY_PRODUCTTYPE_SQL =
            "Select * From processing_fee where studio = ?";
    private static final String SELECT_PROCESSINGFEE_BY_FEE_SQL =
            "Select * From processing_fee where esrb_rating = ?";



    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeJdbcTemplateImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProcessingFee getProcessingFee(int id) {
        return null;
    }

    @Override
    public List<ProcessingFee> getAllProcessingFees() {
        return null;
    }

    @Override
    public ProcessingFee addProcessingFee(ProcessingFee processingFee) {
        return null;
    }

    @Override
    public void updateProcessingFee(ProcessingFee processingFee) {

    }

    @Override
    public void deleteProcessingFee(int id) {

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
}
