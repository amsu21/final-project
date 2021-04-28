package com.company.AmsuWarnerCapstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Games {
    // PROPS AND VARS
    private int gameId;
    private String title;
    private String esrb_rating;
    private String description;
    private BigDecimal price;
    private String studio;
    private int quantity;

    // GETTERS AND SETTERS

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrb_rating() {
        return esrb_rating;
    }

    public void setEsrb_rating(String esrb_rating) {
        this.esrb_rating = esrb_rating;
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

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        if (!(o instanceof Games)) return false;
        Games games = (Games) o;
        return getGameId() == games.getGameId() && getQuantity() == games.getQuantity() && Objects.equals(getTitle(), games.getTitle()) && Objects.equals(getEsrb_rating(), games.getEsrb_rating()) && Objects.equals(getDescription(), games.getDescription()) && Objects.equals(getPrice(), games.getPrice()) && Objects.equals(getStudio(), games.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameId(), getTitle(), getEsrb_rating(), getDescription(), getPrice(), getStudio(), getQuantity());
    }
}

