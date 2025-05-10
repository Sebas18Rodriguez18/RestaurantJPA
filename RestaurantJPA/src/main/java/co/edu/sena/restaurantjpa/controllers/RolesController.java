/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Roles;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import co.edu.sena.restaurantjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 09/05/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Roles.
 */
public class RolesController implements IRolesController{

    @Override
    public void insert(Roles roles) throws Exception {
        if (roles == null) {
            throw new Exception("El rol es nulo");
        }
        if ("".equals(roles.getName())) {
            throw new Exception("El nombre del rol es obligatorio");
        }
        
        //Agregar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRolesDAO().insert(roles);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Roles roles) throws Exception {
        if (roles == null) {
            throw new Exception("El rol es nulo");
        }
        if (roles.getId() == 0) {
            throw new Exception("El id del rol es obligatorio");
        }
        if ("".equals(roles.getName())) {
            throw new Exception("El nombre del rol es obligatorio");
        }
        
        //Consultar si la carrera existe en la bd.
        Roles rolesExist = DAOFactory.getRolesDAO().findById(roles.getId());
        if(rolesExist == null)
        {
            throw new Exception("el rol no existe");
        }
        
        //Merge
        rolesExist.setId(roles.getId());
        rolesExist.setName(roles.getName());
        
        //Actualizar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRolesDAO().insert(roles);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Roles roles) throws Exception {
         if (roles == null || roles.getId() == null || roles.getId() <= 0) {
            throw new Exception("El ID del rol es obligatorio y debe ser mayor a 0.");
        }
        
        // Verificar si el usuario existe
        Roles rolesExist = DAOFactory.getRolesDAO().findById(roles.getId());
        if (rolesExist == null) {
            throw new Exception("El rol con ID " + roles.getId() + " no existe.");
        }
        
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRolesDAO().delete(rolesExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Roles findById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID del rol es obligatorio y debe ser mayor a 0.");
        }

        Roles rolesExist = DAOFactory.getRolesDAO().findById(id);
        if (rolesExist == null) {
            throw new Exception("El rol con ID " + id + " no existe.");
        }

        return rolesExist;
    }

    @Override
    public List<Roles> findAll() throws Exception {
        return DAOFactory.getRolesDAO().findAll();
    }
    
}
