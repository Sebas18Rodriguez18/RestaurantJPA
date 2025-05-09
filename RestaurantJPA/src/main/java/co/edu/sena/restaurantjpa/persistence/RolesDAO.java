/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Roles;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * descripcion: Implementar DAO para modelo de Roles
 */
public class RolesDAO implements IRolesDAO {

    @Override
    public void insert(Roles roles) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(roles);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Roles roles) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(roles);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Roles roles) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(roles);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Roles findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Roles.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Roles> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Roles.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
