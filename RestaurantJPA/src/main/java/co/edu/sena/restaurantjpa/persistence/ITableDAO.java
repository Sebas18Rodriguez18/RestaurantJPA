/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import java.util.List;
import co.edu.sena.restaurantjpa.model.Table;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para DAO de Table
 */
public interface ITableDAO {
    public void insert(Table table) throws Exception;
    public void update(Table table) throws Exception;
    public void delete(Table table) throws Exception;
    public Table findById(Long id) throws Exception;
    public List<Table> findAll() throws Exception;
}
