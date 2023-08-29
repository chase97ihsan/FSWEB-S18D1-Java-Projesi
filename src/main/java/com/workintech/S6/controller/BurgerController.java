package com.workintech.S6.controller;

import com.workintech.S6.dao.BurgerDao;
import com.workintech.S6.entity.BreadType;
import com.workintech.S6.entity.Burger;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burgers")
@Validated
public class BurgerController {


    private BurgerDao burgerDao;


    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping("/")
    public List<Burger> get() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger get(@PathVariable @Positive int id) {
        return burgerDao.findById(id);
    }

    @PostMapping("/")
    public Burger post(@Validated @RequestBody Burger burger) {
        return burgerDao.save(burger);
    }

    @PutMapping("/")
    public Burger put(@Validated @RequestBody Burger burger) {
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable int id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/findByPrice/{price}")
    public List<Burger> findByPrice(@PathVariable double price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/findByBreadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/findByContent/{content}")
    public List<Burger> findByContent(@PathVariable String content) {
        return burgerDao.findByContent(content);

    }


}
