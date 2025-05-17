/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Order1;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para DAO de Order
 */
public interface IOrderDAO {
    public void insert(Order1 order) throws Exception;
    public void update(Order1 order) throws Exception;
    public void delete(Order1 order) throws Exception;
    public Order1 findById(Long id) throws Exception;
    public List<Order1> findAll() throws Exception;
}
