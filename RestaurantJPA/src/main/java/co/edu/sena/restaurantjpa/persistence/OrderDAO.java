/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Order1;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * descripcion: Implementar DAO para modelo de Order
 */
public class OrderDAO implements IOrderDAO {

    @Override
    public void insert(Order1 order) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(order);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Order1 order) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(order);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Order1 order) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(order);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Order1 findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Order1.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Order1> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Order1.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
