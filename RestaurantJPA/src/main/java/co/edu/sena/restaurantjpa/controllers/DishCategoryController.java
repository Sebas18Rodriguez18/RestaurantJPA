/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.DishCategory;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import java.util.List;

/**
 * Fecha: 11/05/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo DishCategory.
 */
public class DishCategoryController implements IDishCategoryController{

    @Override
    public void insert(DishCategory dishCategory) throws Exception {
    }

    @Override
    public void update(DishCategory dishCategory) throws Exception {
    }

    @Override
    public void delete(DishCategory dishCategory) throws Exception {
    }

    @Override
    public DishCategory findById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<DishCategory> findAll() throws Exception {
        return DAOFactory.getCategoryDAO().findAll();
    }
    
}
