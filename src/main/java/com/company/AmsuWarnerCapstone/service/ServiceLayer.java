package com.company.AmsuWarnerCapstone.service;


import com.company.AmsuWarnerCapstone.dao.*;
import com.company.AmsuWarnerCapstone.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ServiceLayer {
    private ConsolesInventoryDao consolesInventoryDao;
    private GamesInventoryDao gamesInventoryDao;
    private TShirtInventoryDao tShirtInventoryDao;

    private IncoiveDao incoiveDao;
    private ProcessingFeeDao processingFeeDao;
    private TaxDao taxDao;

    @Autowired
    public ServiceLayer(ConsolesInventoryDao consolesInventoryDao, GamesInventoryDao gamesInventoryDao, TShirtInventoryDao tShirtInventoryDao, IncoiveDao incoiveDao, ProcessingFeeDao processingFeeDao, TaxDao taxDao) {
        this.consolesInventoryDao = consolesInventoryDao;
        this.gamesInventoryDao = gamesInventoryDao;
        this.tShirtInventoryDao = tShirtInventoryDao;
        this.incoiveDao = incoiveDao;
        this.processingFeeDao = processingFeeDao;
        this.taxDao = taxDao;
    }

    // GET GAMES
    public List<Games> getAllGames() {
        return gamesInventoryDao.getAllGames();
    }

    // GET GAMES BY STUDIO
    public List<Games> getGamesByStudio(String studio) {
       return gamesInventoryDao.getGamesByStudio(studio);
    }

    // GET GAMES BY ESRB RATING
    public List<Games> getGamesByESRB(String rating) {
        return gamesInventoryDao.getGamesByESRB(rating);
    }

    // GET GAMES BY TITLE
    public List<Games> getGamesByTitle(String title) {
        return gamesInventoryDao.getGamesByTitle(title);
    }


    // *TSHIRTS SECTION*

    // GET TSHIRTS
    public List<TShirt> getAllTShirts() {
        return tShirtInventoryDao.getAllTShirts();
    }

    // GET TSHIRTS BY COLOR
    public List<TShirt> getTShirtsByColor(String color) {
        return tShirtInventoryDao.getTShirtsByColor(color);
    }

    // GET TSHIRTS BY SIZE
    public List<TShirt> getTShirtsBySize(String size) {
        return tShirtInventoryDao.getTShirtsBySize(size);
    }


    // *CONSOLES SECTION*

    // GET ALL CONSOLES
    public List<Consoles> getAllConsoles() {
        return consolesInventoryDao.getAllConsoles();
    }

    // GET CONSOLES BY MANUFACTURER
    public List<Consoles> getAllConsolesByManufacturer(String brand) {
        return consolesInventoryDao.getConsolesByManufacturer(brand);
    }


    // * INVOICE SECTION*

    // GET INVOICE
    public List<Invoice> getAllInvoices() {
        return incoiveDao.getAllInvoices();
    }

    // LOGIC
    public Invoice createInvoice(Invoice invoice) {
        invoice.setTax(this.getTax(invoice.getState()));
        if (invoice.getItem_type().equals("Consoles")) {
          Consoles consolesType = consolesInventoryDao.getConsoles(invoice.getItem_id());
          invoice.setUnit_price(consolesType.getPrice());
        }
        invoice.setSubtotal();
        invoice.setProcessing_fee(this.getProcessingFee(invoice.getItem_type()));
        invoice.setTotal();
        invoice.setInvoice_id();
    }


    //* FEE SECTION*

    // GET PROCESSING FEE
    public BigDecimal getProcessingFee(String productType) {
        return processingFeeDao.getFeeNum(productType);
    }


    // *TAX SECTION*
    public BigDecimal getTax(String state) {
        return taxDao.getRate(state);
    }
}