package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.ProcessingFee;

import java.math.BigDecimal;

public interface ProcessingFeeDao {
    ProcessingFee getProcessingFee(String productType);

}
