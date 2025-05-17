/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.DiningTable;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para el modelo de Table
 */
public interface ITableController {
    public void insert(DiningTable table) throws Exception;
    public void update(DiningTable table) throws Exception;
    public void delete(DiningTable tablee) throws Exception;
    public DiningTable findById(Long id) throws Exception;
    public List<DiningTable> findAll() throws Exception;
}
