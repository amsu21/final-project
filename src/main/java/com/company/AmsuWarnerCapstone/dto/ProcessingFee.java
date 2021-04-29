package com.company.AmsuWarnerCapstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFee {
    // PROPS AND VARS
    private String product_type;
    private BigDecimal fee;

    // GETTTERS AND SETTERS

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    // EQUALS AND HASH CODE

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessingFee)) return false;
        ProcessingFee that = (ProcessingFee) o;
        return Objects.equals(getProduct_type(), that.getProduct_type()) && Objects.equals(getFee(), that.getFee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct_type(), getFee());
    }
}
