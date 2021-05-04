package com.company.AmsuWarnerCapstone.controller;


import com.company.AmsuWarnerCapstone.dao.ProcessingFeeDao;
import com.company.AmsuWarnerCapstone.dto.Games;
import com.company.AmsuWarnerCapstone.dto.ProcessingFee;
import com.company.AmsuWarnerCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProcessingFeeController {

    @Autowired
    ServiceLayer serviceLayer;

    //GET ALL FEES
    //METHOD NOTATION
    @RequestMapping(value = "/fee" , method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ProcessingFee> getProcessingFee() {
        return serviceLayer.getAllFees();
    }
}



