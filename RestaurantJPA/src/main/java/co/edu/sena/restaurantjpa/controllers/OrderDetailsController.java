/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.OrderDetails;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import co.edu.sena.restaurantjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 10/05/2025
 * Autor: Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo OrderDetails.
 */
public class OrderDetailsController implements IOrderDetailsController {

    @Override
    public void insert(OrderDetails orderDetails) throws Exception {
        if (orderDetails == null) {
            throw new Exception("El detalle del pedido es nulo");
        }
        if (orderDetails.getQuantity() == 0) {
            throw new Exception("La cantidad debe ser mayor a 0");
        }
        if (orderDetails.getUnitPrice() == null || orderDetails.getUnitPrice().doubleValue() <= 0) {
            throw new Exception("El precio unitario debe ser mayor a 0");
        }
        if (orderDetails.getSubtotal() == null || orderDetails.getSubtotal().doubleValue() <= 0) {
            throw new Exception("El subtotal debe ser mayor a 0");
        }

        // Validar llaves foráneas
        if (orderDetails.getOrderId() == null) {
            throw new Exception("El ID del pedido es obligatorio");
        }
        if (orderDetails.getDishId() == null) {
            throw new Exception("El ID del plato es obligatorio");
        }

        EntityManagerHelper.beginTransaction();
        DAOFactory.getDetailsDAO().insert(orderDetails);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(OrderDetails orderDetails) throws Exception {
        if (orderDetails == null) {
            throw new Exception("El detalle del pedido es nulo");
        }
        if (orderDetails.getId() == null || orderDetails.getId() <= 0) {
            throw new Exception("El ID del detalle del pedido es obligatorio y debe ser mayor a 0");
        }
        if (orderDetails.getQuantity() == 0) {
            throw new Exception("La cantidad debe ser mayor a 0");
        }
        if (orderDetails.getUnitPrice() == null || orderDetails.getUnitPrice().doubleValue() <= 0) {
            throw new Exception("El precio unitario debe ser mayor a 0");
        }
        if (orderDetails.getSubtotal() == null || orderDetails.getSubtotal().doubleValue() <= 0) {
            throw new Exception("El subtotal debe ser mayor a 0");
        }

        // Validar llaves foráneas
        if (orderDetails.getOrderId() == null) {
            throw new Exception("El ID del pedido es obligatorio");
        }
        if (orderDetails.getDishId() == null) {
            throw new Exception("El ID del plato es obligatorio");
        }

        // Verificar si el detalle del pedido existe en la base de datos
        OrderDetails orderDetailsExist = DAOFactory.getDetailsDAO().findById(orderDetails.getId());
        if (orderDetailsExist == null) {
            throw new Exception("El detalle del pedido con ID " + orderDetails.getId() + " no existe.");
        }

        // Actualizar campos
        orderDetailsExist.setQuantity(orderDetails.getQuantity());
        orderDetailsExist.setUnitPrice(orderDetails.getUnitPrice());
        orderDetailsExist.setSubtotal(orderDetails.getSubtotal());
        orderDetailsExist.setOrderId(orderDetails.getOrderId());
        orderDetailsExist.setDishId(orderDetails.getDishId());
        orderDetailsExist.setObservations(orderDetails.getObservations());

        EntityManagerHelper.beginTransaction();
        DAOFactory.getDetailsDAO().update(orderDetailsExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(OrderDetails orderDetails) throws Exception {
        if (orderDetails == null || orderDetails.getId() == null || orderDetails.getId() <= 0) {
            throw new Exception("El ID del detalle del pedido es obligatorio y debe ser mayor a 0.");
        }

        // Verificar si el detalle del pedido existe
        OrderDetails orderDetailsExist = DAOFactory.getDetailsDAO().findById(orderDetails.getId());
        if (orderDetailsExist == null) {
            throw new Exception("El detalle del pedido con ID " + orderDetails.getId() + " no existe.");
        }

        // Eliminar el detalle del pedido
        EntityManagerHelper.beginTransaction();
        DAOFactory.getDetailsDAO().delete(orderDetailsExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public OrderDetails findById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID del detalle del pedido es obligatorio y debe ser mayor a 0.");
        }

        OrderDetails orderDetailsExist = DAOFactory.getDetailsDAO().findById(id);
        if (orderDetailsExist == null) {
            throw new Exception("El detalle del pedido con ID " + id + " no existe.");
        }

        return orderDetailsExist;
    }

    @Override
    public List<OrderDetails> findAll() throws Exception {
        return DAOFactory.getDetailsDAO().findAll();
    }
}
