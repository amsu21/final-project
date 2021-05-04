package com.company.AmsuWarnerCapstone.service;


import com.company.AmsuWarnerCapstone.dao.*;
import com.company.AmsuWarnerCapstone.dto.Consoles;
import com.company.AmsuWarnerCapstone.dto.Games;
import com.company.AmsuWarnerCapstone.dto.Invoice;
import com.company.AmsuWarnerCapstone.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceLayer {
    private ConsolesInventoryDao consolesInventoryDao;
    private GamesInventoryDao gamesInventoryDao;
    private TShirtInventoryDao tShirtInventoryDao;

    private IncoiveDao incoiveDao;
    private ProcessingFeeDao processingFeeDao;

    @Autowired
    public ServiceLayer(ConsolesInventoryDao consolesInventoryDao, GamesInventoryDao gamesInventoryDao, TShirtInventoryDao tShirtInventoryDao, IncoiveDao incoiveDao, ProcessingFeeDao processingFeeDao) {
        this.consolesInventoryDao = consolesInventoryDao;
        this.gamesInventoryDao = gamesInventoryDao;
        this.tShirtInventoryDao = tShirtInventoryDao;
        this.incoiveDao = incoiveDao;
        this.processingFeeDao = processingFeeDao;
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


    //* FEE SECTION*

    // GET PROCESSINGFEE
    public List<ProcessingFee> getAllFees() {return ProcessingFeeDao.getAllProcessingFees}

}