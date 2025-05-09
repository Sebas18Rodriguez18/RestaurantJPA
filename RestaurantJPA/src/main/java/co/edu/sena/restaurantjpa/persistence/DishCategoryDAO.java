/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.DishCategory;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * descripcion: Implementar DAO para modelo de DishCategory
 */
public class DishCategoryDAO implements IDishCategoryDAO{

    @Override
    public void insert(DishCategory dishCategory) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(dishCategory);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(DishCategory dishCategory) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(dishCategory);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(DishCategory dishCategory) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(dishCategory);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public DishCategory findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(DishCategory.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<DishCategory> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("DishCategory.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
