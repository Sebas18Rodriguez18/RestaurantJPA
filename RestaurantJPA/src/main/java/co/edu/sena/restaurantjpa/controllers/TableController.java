/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.controllers.ITableController;
import java.util.List;
import co.edu.sena.restaurantjpa.model.Table;

/**
 * Fecha: 07/05/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Table.
 */
public class TableController implements ITableController{

    @Override
    public void insert(Table table) throws Exception {
    }

    @Override
    public void update(Table table) throws Exception {
    }

    @Override
    public void delete(Table table) throws Exception {
    }

    @Override
    public Table findById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Table> findAll() throws Exception {
        return null;
    }
    
}
