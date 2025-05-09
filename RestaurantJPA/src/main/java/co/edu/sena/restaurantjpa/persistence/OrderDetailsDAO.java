/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.OrderDetails;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * descripcion: Implementar DAO para modelo de OrderDetails
 */
public class OrderDetailsDAO implements IOrderDetailsDAO {

    @Override
    public void insert(OrderDetails orderDetails) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(orderDetails);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(OrderDetails orderDetails) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(orderDetails);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(OrderDetails orderDetails) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(orderDetails);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public OrderDetails findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(OrderDetails.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<OrderDetails> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("OrderDetails.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
