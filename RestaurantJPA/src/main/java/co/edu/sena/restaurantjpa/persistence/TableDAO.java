/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.DiningTable;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * descripcion: Implementar DAO para modelo de Table
 */
public class TableDAO implements ITableDAO {

    @Override
    public void insert(DiningTable table) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(table);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(DiningTable table) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(table);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(DiningTable table) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(table);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public DiningTable findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(DiningTable.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<DiningTable> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery(""
                    + "DiningTable.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
