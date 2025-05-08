/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Box;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para el modelo de Box
 */

public interface IBoxController {
    public void insert(Box box) throws Exception;
    public void update(Box box) throws Exception;
    public void delete(Box box) throws Exception;
    public Box findById(Long id) throws Exception;
    public List<Box> findAll() throws Exception;
}
