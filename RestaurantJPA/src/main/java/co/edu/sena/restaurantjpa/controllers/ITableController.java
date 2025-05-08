/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Table;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para el modelo de Table
 */
public interface ITableController {
    public void insert(Table table) throws Exception;
    public void update(Table table) throws Exception;
    public void delete(Table table) throws Exception;
    public Table findById(Long id) throws Exception;
    public List<Table> findAll() throws Exception;
}
