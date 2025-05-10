/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.OrderDetails;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import java.util.List;

/**
 * Fecha: 10/05/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo OrderDetails.
 */
public class OrderDetailsController implements IOrderDetailsController{

    @Override
    public void insert(OrderDetails orderDetails) throws Exception {
    }

    @Override
    public void update(OrderDetails orderDetails) throws Exception {
    }

    @Override
    public void delete(OrderDetails orderDetails) throws Exception {
    }

    @Override
    public OrderDetails findById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<OrderDetails> findAll() throws Exception {
        return DAOFactory.getDetailsDAO().findAll();
    }
    
}
