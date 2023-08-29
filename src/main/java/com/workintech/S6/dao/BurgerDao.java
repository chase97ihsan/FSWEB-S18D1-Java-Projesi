package com.workintech.S6.dao;

import com.workintech.S6.entity.BreadType;
import com.workintech.S6.entity.Burger;

import java.util.List;

public interface BurgerDao {

    Burger save(Burger burger);
    Burger findById(int id);
    List<Burger> findAll();
    List<Burger> findByPrice(double price);
    List<Burger> findByContent(String content);
    Burger update(Burger burger);
    Burger remove(int id);
    List<Burger>  findByBreadType(BreadType breadType);
}
