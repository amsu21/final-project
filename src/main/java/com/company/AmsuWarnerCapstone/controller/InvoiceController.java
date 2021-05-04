package com.company.AmsuWarnerCapstone.controller;

import com.company.AmsuWarnerCapstone.dto.Invoice;
import com.company.AmsuWarnerCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {
    @Autowired
    ServiceLayer serviceLayer;

    // GET INVOICE
    // METHOD NOTATIONS
    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getInvoice() {
        return serviceLayer.getAllInvoices();
    }
}
