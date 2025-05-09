/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Table;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * descripcion: Implementar DAO para modelo de Table
 */
public class TableDAO implements ITableDAO {

    @Override
    public void insert(Table table) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(table);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Table table) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(table);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Table table) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(table);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Table findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Table.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Table> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Table.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
