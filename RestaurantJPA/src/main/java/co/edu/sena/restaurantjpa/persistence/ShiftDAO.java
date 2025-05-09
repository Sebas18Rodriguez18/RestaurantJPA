/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Shift;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * descripcion: Implementar DAO para modelo de Shift
 */
public class ShiftDAO implements IShiftDAO {

    @Override
    public void insert(Shift shift) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(shift);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Shift shift) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(shift);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Shift shift) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(shift);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Shift findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Shift.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Shift> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Shift.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
