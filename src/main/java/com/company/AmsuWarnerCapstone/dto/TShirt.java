package com.company.AmsuWarnerCapstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class TShirt {
    // PROPS AND VARS
    private int t_shirt_id;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private int quantity;

    // GETTERS AND SETTERS

    public int getT_shirt_id() {
        return t_shirt_id;
    }

    public void setT_shirt_id(int t_shirt_id) {
        this.t_shirt_id = t_shirt_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // EQUALS AND HASH CODE


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TShirt)) return false;
        TShirt tShirt = (TShirt) o;
        return getT_shirt_id() == tShirt.getT_shirt_id() && getQuantity() == tShirt.getQuantity() && Objects.equals(getSize(), tShirt.getSize()) && Objects.equals(getColor(), tShirt.getColor()) && Objects.equals(getDescription(), tShirt.getDescription()) && Objects.equals(getPrice(), tShirt.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getT_shirt_id(), getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }
}
