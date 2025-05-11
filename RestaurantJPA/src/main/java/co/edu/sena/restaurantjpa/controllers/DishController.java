/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Dish;
import co.edu.sena.restaurantjpa.model.DishCategory;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import co.edu.sena.restaurantjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 11/05/2025
 * Autor: Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Dish.
 */
public class DishController implements IDishController {

    @Override
    public void insert(Dish dish) throws Exception {
        if (dish == null) {
            throw new Exception("El plato es nulo");
        }
        if (dish.getName() == null || dish.getName().isEmpty()) {
            throw new Exception("El nombre del plato es obligatorio");
        }
        if (dish.getPrice() == null || dish.getPrice().doubleValue() <= 0) {
            throw new Exception("El precio del plato debe ser mayor a 0");
        }
        if (dish.getCategoryId() == null) {
            throw new Exception("El ID de la categoría es obligatorio");
        }

        // Validar llave foránea (categoría)
        DishCategory category = DAOFactory.getCategoryDAO().findById(dish.getCategoryId().getId());
        if (category == null) {
        throw new Exception("La categoría con ID " + dish.getCategoryId().getId() + " no existe.");
    }

        EntityManagerHelper.beginTransaction();
        DAOFactory.getDishDAO().insert(dish);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Dish dish) throws Exception {
        if (dish == null) {
            throw new Exception("El plato es nulo");
        }
        if (dish.getId() == null || dish.getId() <= 0) {
            throw new Exception("El ID del plato es obligatorio y debe ser mayor a 0");
        }
        if (dish.getName() == null || dish.getName().isEmpty()) {
            throw new Exception("El nombre del plato es obligatorio");
        }
        if (dish.getPrice() == null || dish.getPrice().doubleValue() <= 0) {
            throw new Exception("El precio del plato debe ser mayor a 0");
        }
        if (dish.getCategoryId() == null) {
            throw new Exception("El ID de la categoría es obligatorio");
        }

        // Validar existencia del plato
        Dish dishExist = DAOFactory.getDishDAO().findById(dish.getId());
        if (dishExist == null) {
            throw new Exception("El plato con ID " + dish.getId() + " no existe.");
        }

        // Validar llave foránea (categoría)
        DishCategory category = DAOFactory.getCategoryDAO().findById(dish.getCategoryId().getId());
        if (category == null) {
            throw new Exception("La categoría con ID " + dish.getCategoryId() + " no existe.");
        }

        // Actualizar campos
        dishExist.setName(dish.getName());
        dishExist.setDescription(dish.getDescription());
        dishExist.setPrice(dish.getPrice());
        dishExist.setAvailable(dish.getAvailable());
        dishExist.setCategoryId(dish.getCategoryId());

        EntityManagerHelper.beginTransaction();
        DAOFactory.getDishDAO().update(dishExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Dish dish) throws Exception {
        if (dish == null || dish.getId() == null || dish.getId() <= 0) {
            throw new Exception("El ID del plato es obligatorio y debe ser mayor a 0.");
        }

        // Validar existencia del plato
        Dish dishExist = DAOFactory.getDishDAO().findById(dish.getId());
        if (dishExist == null) {
            throw new Exception("El plato con ID " + dish.getId() + " no existe.");
        }

        EntityManagerHelper.beginTransaction();
        DAOFactory.getDishDAO().delete(dishExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Dish> findAll() throws Exception {
        return DAOFactory.getDishDAO().findAll();
    }

    @Override
    public Dish findById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID del plato es obligatorio y debe ser mayor a 0.");
        }

        Dish dishExist = DAOFactory.getDishDAO().findById(id);
        if (dishExist == null) {
            throw new Exception("El plato con ID " + id + " no existe.");
        }

        return dishExist;
    }
}
