/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Kitchen;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * descripcion: Implementar DAO para modelo de Kitchen
 */
public class KitchenDAO implements IKitchenDAO {

    @Override
    public void insert(Kitchen kitchen) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(kitchen);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Kitchen kitchen) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(kitchen);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Kitchen kitchen) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(kitchen);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Kitchen findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Kitchen.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Kitchen> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Kitchen.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
