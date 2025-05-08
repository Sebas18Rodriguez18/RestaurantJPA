/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.DishCategory;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para DAO de DishCategory
 */
public interface IDishCategoryDAO {
    public void insert(DishCategory dishCategory) throws Exception;
    public void update(DishCategory dishCategory) throws Exception;
    public void delete(DishCategory dishCategory) throws Exception;
    public DishCategory findById(Long id) throws Exception;
    public List<DishCategory> findAll() throws Exception;
}
