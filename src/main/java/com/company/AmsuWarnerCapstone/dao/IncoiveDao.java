package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.Invoice;

import java.util.List;

public interface IncoiveDao {
    Invoice getInvoice(int id);

    List<Invoice> getAllInvoices();

    Invoice addInvoice(Invoice invoice);

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int id);
}
