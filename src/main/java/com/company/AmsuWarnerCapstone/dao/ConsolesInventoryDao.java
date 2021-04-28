package com.company.AmsuWarnerCapstone.dao;

import com.company.AmsuWarnerCapstone.dto.Consoles;

import java.util.List;

public interface ConsolesInventoryDao {
    Consoles getConsoles(int id);

    List<Consoles> getAllConsoles();

    Consoles addConsoles(Consoles consoles);

    void updateConsoles(Consoles consoles);

    void deleteConsoles(int id);
}
