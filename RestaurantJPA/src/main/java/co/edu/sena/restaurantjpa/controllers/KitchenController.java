/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Kitchen;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import co.edu.sena.restaurantjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 10/05/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Kitchen.
 */
public class KitchenController implements IKitchenController{

    @Override
    public void insert(Kitchen kitchen) throws Exception {
        if (kitchen == null) {
            throw new Exception("La cocina es nula");
        }
        if ("".equals(kitchen.getName())) {
            throw new Exception("El nombre es obligatorio");
        }
        
        //FK's
        if (kitchen.getManagerId() == null) {
            throw new Exception("El id del manager es obligatorio");
        }
        
        //Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKitchenDAO().insert(kitchen);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Kitchen kitchen) throws Exception {
        if (kitchen == null) {
            throw new Exception("La cocina es nula");
        }
        if (kitchen.getId() == 0) {
            throw new Exception("El id es obligatorio");
        }
        if ("".equals(kitchen.getName())) {
            throw new Exception("El nombre es obligatorio");
        }
        if ("".equals(kitchen.getDescription())) {
            throw new Exception("La descripción es obligatoria");
        }
        
        //FK's
        if (kitchen.getManagerId() == null) {
            throw new Exception("El id del manager es obligatorio");
        }
        
        //Verificar si está en la BD
        Kitchen kitchenExist = DAOFactory.getKitchenDAO().findById(kitchen.getId());
        if (kitchenExist == null) {
            throw new Exception("La cocina no existe en la BD");
        }
        
        //Merge
        kitchenExist.setId(kitchen.getId());
        kitchenExist.setName(kitchen.getName());
        kitchenExist.setDescription(kitchen.getDescription());
        kitchenExist.setManagerId(kitchen.getManagerId());
        
        //Actualizar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKitchenDAO().update(kitchen);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

    @Override
    public void delete(Kitchen kitchen) throws Exception {
        if (kitchen == null || kitchen.getId() == null || kitchen.getId() <= 0) {
            throw new Exception("El ID de la cocina es obligatorio y debe ser mayor a 0.");
        }
        
        //Verificar si está en la BD
        Kitchen kitchenExist = DAOFactory.getKitchenDAO().findById(kitchen.getId());
        if (kitchenExist == null) {
            throw new Exception("La cocina no existe en la BD");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKitchenDAO().delete(kitchen);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Kitchen findById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID de la cocina es obligatorio y debe ser mayor a 0.");
        }
        
        Kitchen kitchenExist = DAOFactory.getKitchenDAO().findById(id);
        if (kitchenExist == null) {
            throw new Exception("La cocina con ID " + id + " no existe.");
        }
        
        return kitchenExist;
    }

    @Override
    public List<Kitchen> findAll() throws Exception {
        return DAOFactory.getKitchenDAO().findAll();
    }
    
}
