/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Users;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * descripcion: Implementar DAO para modelo de Users
 */
public class UsersDAO implements IUsersDAO {

    @Override
    public void insert(Users users) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(users);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Users users) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(users);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Users users) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(users);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Users findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Users.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Users> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Users.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
