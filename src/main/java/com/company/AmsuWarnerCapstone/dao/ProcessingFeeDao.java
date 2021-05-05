package com.company.AmsuWarnerCapstone.dao;



import com.company.AmsuWarnerCapstone.dto.ProcessingFee;

import java.math.BigDecimal;
import java.util.List;

public interface ProcessingFeeDao {
    ProcessingFee getProcessingFee(String productType);

    BigDecimal getFeeNum(String productType);
}
