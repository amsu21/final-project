package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}