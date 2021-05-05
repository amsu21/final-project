package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.Tax;

import java.math.BigDecimal;

public interface TaxDao {
    Tax getTax(String state);

    BigDecimal getRate(String state);
}
