package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoJdbcTemplateImplTest {

    // SET UP DAO
    @Autowired
    private IncoiveDao incoiveDao;

    @Before
    public void setUp() throws Exception {
        // INVOICE
        List<Invoice> invoiceList = incoiveDao.getAllInvoices();
        for (Invoice i : invoiceList) {
            incoiveDao.deleteInvoice(i.getInvoice_id());
        }
    }

    // GET ALL INVOICES
    @Test
    public void getAllInvoices() {
        // ARRANGE
        Invoice invoice = new Invoice();
        invoice.setName("Joe");
        invoice.setStreet("123 Blvd");
        invoice.setCity("Norfolk");
        invoice.setState("Va");
        invoice.setZipcode("23504");
        invoice.setItem_type("Game");
        invoice.setItem_id(1);
        invoice.setUnit_price(new BigDecimal("12.99"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("13.50"));
        invoice.setTax(new BigDecimal("0.50"));
        invoice.setProcessing_fee(new BigDecimal("0.5"));
        invoice.setTotal(new BigDecimal("14.00"));

        // ADD ACTION
        incoiveDao.addInvoice(invoice);
        invoice = new Invoice();
    }

    // UPDATE
    @Test
    public void updateInvoice() {
        // ARRANGE
        Invoice invoice = new Invoice();
        invoice.setName("Joe");
        invoice.setStreet("123 Blvd");
        invoice.setCity("Norfolk");
        invoice.setState("Va");
        invoice.setZipcode("23504");
        invoice.setItem_type("Game");
        invoice.setItem_id(1);
        invoice.setUnit_price(new BigDecimal("12.99"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("13.50"));
        invoice.setTax(new BigDecimal("0.50"));
        invoice.setProcessing_fee(new BigDecimal("0.5"));
        invoice.setTotal(new BigDecimal("14.00"));

    }
}