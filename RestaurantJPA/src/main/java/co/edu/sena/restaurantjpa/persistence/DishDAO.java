/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Dish;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * descripcion: Implementar DAO para modelo de Dish
 */
public class DishDAO implements IDishDAO{

    @Override
    public void insert(Dish dish) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(dish);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Dish dish) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(dish);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Dish dish) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(dish);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Dish findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Dish.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Dish> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Dish.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
