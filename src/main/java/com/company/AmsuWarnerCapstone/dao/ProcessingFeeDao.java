package com.company.AmsuWarnerCapstone.dao;



import com.company.AmsuWarnerCapstone.dto.ProcessingFee;

import java.math.BigDecimal;
import java.util.List;

public interface ProcessingFeeDao {
    ProcessingFee getProcessingFee(int id);

    List<ProcessingFee> getAllProcessingFees();

    BigDecimal getFeeByType(String productType);

    ProcessingFee addProcessingFee(ProcessingFee processingFee);

    void updateProcessingFee(ProcessingFee processingFee);

    void deleteProcessingFee(int id);

    ProcessingFee getProcessingFee(String productType);
}
