/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.DishCategory;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import co.edu.sena.restaurantjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 11/05/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo DishCategory.
 */
public class DishCategoryController implements IDishCategoryController{

    @Override
    public void insert(DishCategory dishCategory) throws Exception {
        if (dishCategory == null) {
            throw new Exception("La categoría del plato es nula");
        }
        if ("".equals(dishCategory.getName())) {
            throw new Exception("El nombre de la categoría del plato es obligatoría");
        }
        
        //Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCategoryDAO().insert(dishCategory);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(DishCategory dishCategory) throws Exception {
        if (dishCategory == null) {
            throw new Exception("La categoría del plato es nula");
        }
        if ("".equals(dishCategory.getName())) {
            throw new Exception("El nombre de la categoría del plato es obligatoría");
        }
        if ("".equals(dishCategory.getDescription())) {
            throw new Exception("La descrpción de la categoría del plato es obligatoría");
        }
        
        //Verificar si existe en la BD.
        DishCategory dishCategoryExist = DAOFactory.getCategoryDAO().findById(dishCategory.getId());
        if (dishCategoryExist == null) {
            throw new Exception("La categoria del plato no existe");
        }
        
        //Merge
        dishCategory.setId(dishCategory.getId());
        dishCategory.setName(dishCategory.getName());
        dishCategory.setDescription(dishCategory.getDescription());
        
        //Actualizar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCategoryDAO().update(dishCategory);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(DishCategory dishCategory) throws Exception {
        if (dishCategory == null) {
            throw new Exception("El ID de la categoría es obligatorio y debe ser mayor a 0.");
        }
        
        //Verificar si existe en la BD.
        DishCategory dishCategoryExist = DAOFactory.getCategoryDAO().findById(dishCategory.getId());
        if (dishCategoryExist == null) {
            throw new Exception("La categoria del plato no existe");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCategoryDAO().delete(dishCategory);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public DishCategory findById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID del usuario es obligatorio y debe ser mayor a 0.");
        }

        DishCategory dishCategoryExist = DAOFactory.getCategoryDAO().findById(id);
        if (dishCategoryExist == null) {
            throw new Exception("El usuario con ID " + id + " no existe.");
        }

        return dishCategoryExist;
    }

    @Override
    public List<DishCategory> findAll() throws Exception {
        return DAOFactory.getCategoryDAO().findAll();
    }
    
}
