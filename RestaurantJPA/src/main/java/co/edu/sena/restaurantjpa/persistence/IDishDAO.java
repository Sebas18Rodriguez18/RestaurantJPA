/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Dish;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para DAO de Dish
 */

public interface IDishDAO {
    public void insert(Dish dish) throws Exception;
    public void update(Dish dish) throws Exception;
    public void delete(Dish dish) throws Exception;
    public Dish  findById(Long id) throws Exception;
    public List<Dish> findAll() throws Exception;
}
