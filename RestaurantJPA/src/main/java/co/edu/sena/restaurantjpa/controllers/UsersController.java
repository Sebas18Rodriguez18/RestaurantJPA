/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Users;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import co.edu.sena.restaurantjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 09/05/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Users.
 */
public class UsersController implements IUsersController{

    @Override
    public void insert(Users users) throws Exception {
        if (users == null) {
            throw new Exception("El usuario es nulo");
        }
        if("".equals(users.getFullName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        if ("".equals(users.getEmail())) {
            throw new Exception("El email es obligatorio");
        }
        if ("".equals(users.getPassword())) {
            throw new Exception("La contraseña es obligatoria");
        }
        if ("".equals(users.getStatus())) {
            throw new Exception("El estado es obligatorio");
        }
        
        //FK's
        if(users.getRoleId() == null)
        {
            throw  new Exception("El id del rol es obligatorio");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUsersDAO().insert(users);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Users users) throws Exception {
        if (users == null) {
            throw new Exception("El usuario es nulo");
        }
        if (users.getId() == 0 ) {
            throw new Exception("La id es obligatorio");
        }
        if("".equals(users.getFullName()))
        {
        } else {
            throw new Exception("El nombre es obligatorio");
        }
        if ("".equals(users.getEmail())) {
            throw new Exception("El email es obligatorio");
        }
        if ("".equals(users.getPassword())) {
            throw new Exception("La contraseña es obligatoria");
        }
        if ("".equals(users.getStatus())) {
            throw new Exception("El estado es obligatorio");
        }
        
        //FK's
        if(users.getRoleId() == null)
        {
            throw  new Exception("El id del rol es obligatorio");
        }
        
        //Consultar si la carrera existe en la bd.
        Users usersExist = DAOFactory.getUsersDAO().findById(users.getId());
        if(usersExist == null)
        {
            throw new Exception("el usuario no existe");
        }
        
        //Merge:
        usersExist.setId(users.getId());
        usersExist.setFullName(users.getFullName());
        usersExist.setEmail(users.getEmail());
        usersExist.setPassword(users.getPassword());
        usersExist.setStatus(users.getStatus());
        usersExist.setRoleId(users.getRoleId());
        
        //Actualizar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUsersDAO().update(users);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Users users) throws Exception {
        if (users == null || users.getId() == null || users.getId() <= 0) {
            throw new Exception("El ID del usuario es obligatorio y debe ser mayor a 0.");
        }
        
        // Verificar si el usuario existe
        Users usersExist = DAOFactory.getUsersDAO().findById(users.getId());
        if (usersExist == null) {
            throw new Exception("El usuario con ID " + users.getId() + " no existe.");
        }

        // Eliminar el usuario
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUsersDAO().delete(usersExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Users findById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID del usuario es obligatorio y debe ser mayor a 0.");
        }

        Users usersExist = DAOFactory.getUsersDAO().findById(id);
        if (usersExist == null) {
            throw new Exception("El usuario con ID " + id + " no existe.");
        }

        return usersExist;
    }

    @Override
    public List<Users> findAll() throws Exception {
        return DAOFactory.getUsersDAO().findAll();
    }
    
}
