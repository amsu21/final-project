package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceDaoJdbcTemplateImpl implements IncoiveDao {
    // PREPARED STATEMENTS
    private static final String INSERT_INVOICE_SQL =
            "Insert into invoice (name, street, city, state, zipcode, item_type, item_id, unit_price, quantity, subtotal, tax, processing_fee, total) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_INVOICE_SQL =
            "Select * From invoice where invoice_id = ?";
    private static final String SELECT_ALL_INVOICE_SQL =
            "Select * From invoice";
    private static final String DELETE_INVOICE_SQL =
            "Delete from invoice where invoice_id = ?";
    private static final String UPDATE_INVOICE_SQL =
            "Update invoice set name = ?, street = ?, city = ?, state = ?, zipcode = ?, item_type = ?, item_id = ?, unit_price = ?, quantity = ?, subtotal = ?, tax = ?, processing_fee = ?, total = ?, where invoice_id = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceDaoJdbcTemplateImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Invoice getInvoice(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_INVOICE_SQL, this::mapToRowInvoice, id);
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // GET ALL INVOICES
    @Override
    public List<Invoice> getAllInvoices() {
        return jdbcTemplate.query(SELECT_ALL_INVOICE_SQL, this::mapToRowInvoice);
    }

    // ADD INVOICE
    @Override
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(INSERT_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItem_type(),
                invoice.getItem_id(),
                invoice.getUnit_price(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessing_fee(),
                invoice.getTotal());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        invoice.setInvoice_id(id);

        return invoice;
    }

    // UPDATE INVOICE
    @Override
    public void updateInvoice(Invoice invoice) {
        jdbcTemplate.update(UPDATE_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItem_type(),
                invoice.getItem_id(),
                invoice.getUnit_price(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessing_fee(),
                invoice.getTotal(),
                invoice.getInvoice_id());
    }

    // DELETE INVOICE
    @Override
    public void deleteInvoice(int id) {
        jdbcTemplate.update(DELETE_INVOICE_SQL, id);
    }


    //  ROW MAPPER
    private Invoice mapToRowInvoice(ResultSet rs, int rowNumber) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setName(rs.getString("name"));
        invoice.setStreet(rs.getString("street"));
        invoice.setCity(rs.getString("city"));
        invoice.setState(rs.getString("state"));
        invoice.setZipcode(rs.getString("zipcode"));
        invoice.setItem_type(rs.getString("item_type"));
        invoice.setItem_id(rs.getInt("item_id"));
        invoice.setUnit_price(rs.getBigDecimal("unit_price"));
        invoice.setQuantity(rs.getInt("quantity"));
        invoice.setSubtotal(rs.getBigDecimal("subtotal"));
        invoice.setTax(rs.getBigDecimal("tax"));
        invoice.setProcessing_fee(rs.getBigDecimal("processing_fee"));
        invoice.setTotal(rs.getBigDecimal("total"));

        return invoice;
    }
}
