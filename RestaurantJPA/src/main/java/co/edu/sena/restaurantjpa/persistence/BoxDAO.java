/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Box;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * descripcion: Implementar DAO para modelo de Box
 */
public class BoxDAO implements IBoxDAO{

    @Override
    public void insert(Box box) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(box);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Box box) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(box);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Box box) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(box);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Box findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Box.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Box> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Box.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
