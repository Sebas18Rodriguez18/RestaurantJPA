/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Order;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para DAO de Order
 */
public interface IOrderDAO {
    public void insert(Order order) throws Exception;
    public void update(Order order) throws Exception;
    public void delete(Order order) throws Exception;
    public Order findById(Long id) throws Exception;
    public List<Order> findAll() throws Exception;
}
