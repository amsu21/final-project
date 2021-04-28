package com.company.AmsuWarnerCapstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Consoles {
    // PROPS AND VARS
    private int console_id;
    private String model;
    private String manufacturer;
    private String memory_amount;
    private String processor;
    private BigDecimal price;
    private int quantity;

    // GETTERS AND SETTERS

    public int getConsole_id() {
        return console_id;
    }

    public void setConsole_id(int console_id) {
        this.console_id = console_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemory_amount() {
        return memory_amount;
    }

    public void setMemory_amount(String memory_amount) {
        this.memory_amount = memory_amount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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
        if (!(o instanceof Consoles)) return false;
        Consoles consoles = (Consoles) o;
        return getConsole_id() == consoles.getConsole_id() && getQuantity() == consoles.getQuantity() && Objects.equals(getModel(), consoles.getModel()) && Objects.equals(getManufacturer(), consoles.getManufacturer()) && Objects.equals(getMemory_amount(), consoles.getMemory_amount()) && Objects.equals(getProcessor(), consoles.getProcessor()) && Objects.equals(getPrice(), consoles.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConsole_id(), getModel(), getManufacturer(), getMemory_amount(), getProcessor(), getPrice(), getQuantity());
    }
}
