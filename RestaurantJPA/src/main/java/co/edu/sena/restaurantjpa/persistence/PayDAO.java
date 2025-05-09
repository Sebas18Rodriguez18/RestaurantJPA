/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Pay;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * descripcion: Implementar DAO para modelo de Pay
 */
public class PayDAO implements IPayDAO {

    @Override
    public void insert(Pay pay) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(pay);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Pay pay) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(pay);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Pay pay) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(pay);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Pay findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Pay.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Pay> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Pay.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
