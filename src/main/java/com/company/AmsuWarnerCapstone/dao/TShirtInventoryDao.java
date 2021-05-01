package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.TShirt;

import java.util.List;

public interface TShirtInventoryDao {
    TShirt getTShirt(int id);

    List<TShirt> getAllTShirts();

    List<TShirt> getTShirtsByColor(String color);

    TShirt addTShirt(TShirt tShirt);

    void updateTShirt(TShirt tShirt);

    void deleteTShirt(int id);
}
