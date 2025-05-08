/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.OrderDetails;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para el modelo de OrderDetails
 */
public interface IOrderDetailsController {
    public void insert(OrderDetails orderDetails) throws Exception;
    public void update(OrderDetails orderDetails) throws Exception;
    public void delete(OrderDetails orderDetails) throws Exception;
    public OrderDetails findById(Long id) throws Exception;
    public List<OrderDetails> findAll() throws Exception;
}
