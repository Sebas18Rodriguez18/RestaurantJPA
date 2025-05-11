/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Order;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import co.edu.sena.restaurantjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 10/05/2025
 * Autor: Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Order.
 */
public class OrderController implements IOrderController {

    @Override
    public void insert(Order order) throws Exception {
        if (order == null) {
            throw new Exception("El pedido es nulo");
        }
        if (order.getDate() == null) {
            throw new Exception("La fecha del pedido es obligatoria");
        }
        if (order.getStatus() == null || order.getStatus().isEmpty()) {
            throw new Exception("El estado del pedido es obligatorio");
        }
        if (order.getTotal() == null || order.getTotal().doubleValue() <= 0) {
            throw new Exception("El total del pedido debe ser mayor a 0");
        }

        // Validar llaves foráneas
        if (order.getTableId() == null) {
            throw new Exception("El ID de la mesa es obligatorio");
        }
        if (order.getWaiterId() == null) {
            throw new Exception("El ID del mesero es obligatorio");
        }
        if (order.getKitchenId() == null) {
            throw new Exception("El ID de la cocina es obligatorio");
        }
        if (order.getBoxId() == null) {
            throw new Exception("El ID de la caja es obligatorio");
        }

        EntityManagerHelper.beginTransaction();
        DAOFactory.getOrderDAO().insert(order);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Order order) throws Exception {
        if (order == null) {
            throw new Exception("El pedido es nulo");
        }
        if (order.getId() == null || order.getId() <= 0) {
            throw new Exception("El ID del pedido es obligatorio y debe ser mayor a 0");
        }
        if (order.getDate() == null) {
            throw new Exception("La fecha del pedido es obligatoria");
        }
        if (order.getStatus() == null || order.getStatus().isEmpty()) {
            throw new Exception("El estado del pedido es obligatorio");
        }
        if (order.getTotal() == null || order.getTotal().doubleValue() <= 0) {
            throw new Exception("El total del pedido debe ser mayor a 0");
        }

        // Validar llaves foráneas
        if (order.getTableId() == null) {
            throw new Exception("El ID de la mesa es obligatorio");
        }
        if (order.getWaiterId() == null) {
            throw new Exception("El ID del mesero es obligatorio");
        }
        if (order.getKitchenId() == null) {
            throw new Exception("El ID de la cocina es obligatorio");
        }
        if (order.getBoxId() == null) {
            throw new Exception("El ID de la caja es obligatorio");
        }

        // Verificar si el pedido existe en la base de datos
        Order orderExist = DAOFactory.getOrderDAO().findById(order.getId());
        if (orderExist == null) {
            throw new Exception("El pedido con ID " + order.getId() + " no existe.");
        }

        // Actualizar campos
        orderExist.setDate(order.getDate());
        orderExist.setStatus(order.getStatus());
        orderExist.setTotal(order.getTotal());
        orderExist.setTableId(order.getTableId());
        orderExist.setWaiterId(order.getWaiterId());
        orderExist.setKitchenId(order.getKitchenId());
        orderExist.setBoxId(order.getBoxId());

        EntityManagerHelper.beginTransaction();
        DAOFactory.getOrderDAO().update(orderExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Order order) throws Exception {
        if (order == null || order.getId() == null || order.getId() <= 0) {
            throw new Exception("El ID del pedido es obligatorio y debe ser mayor a 0.");
        }

        // Verificar si el pedido existe
        Order orderExist = DAOFactory.getOrderDAO().findById(order.getId());
        if (orderExist == null) {
            throw new Exception("El pedido con ID " + order.getId() + " no existe.");
        }

        // Eliminar el pedido
        EntityManagerHelper.beginTransaction();
        DAOFactory.getOrderDAO().delete(orderExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Order findById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID del pedido es obligatorio y debe ser mayor a 0.");
        }

        Order orderExist = DAOFactory.getOrderDAO().findById(id);
        if (orderExist == null) {
            throw new Exception("El pedido con ID " + id + " no existe.");
        }

        return orderExist;
    }

    @Override
    public List<Order> findAll() throws Exception {
        return DAOFactory.getOrderDAO().findAll();
    }
}
