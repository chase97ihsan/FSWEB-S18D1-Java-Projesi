package com.workintech.S6.dao;

import com.workintech.S6.entity.BreadType;
import com.workintech.S6.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Repository
public class BurgerDaolmpl implements BurgerDao {


    private EntityManager entityManager;

    @Autowired
    public BurgerDaolmpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findById(int id) {
        return entityManager.find(Burger.class, id);
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT e FROM Burger e", Burger.class);
        return query.getResultList();
    }

    //JPQL
    @Override
    public List<Burger> findByPrice(double price) {
        TypedQuery<Burger> query = entityManager.
                createQuery("SELECT e FROM Burger e WHERE e.price>= :price ORDER BY e.price desc", Burger.class);
        query.setParameter("price", price);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT e FROM Burger e WHERE e.contents ilike '%:content%'", Burger.class);
        query.setParameter("content", content);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Burger update(@Validated Burger burger) {
        return entityManager.merge(burger);
    }

    @Transactional
    @Override
    public Burger remove(int id) {
        Burger burger = findById(id);
        entityManager.remove(burger);
        return burger;
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query = entityManager.
                createQuery("SELECT e FROM Burger e WHERE e.breadType=:type ORDER BY e.name ", Burger.class);
        query.setParameter("type", breadType);
        return query.getResultList();
    }
}
