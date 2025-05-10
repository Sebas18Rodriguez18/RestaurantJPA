/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import java.util.List;
import co.edu.sena.restaurantjpa.model.Table;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import co.edu.sena.restaurantjpa.persistence.EntityManagerHelper;

/**
 * Fecha: 09/05/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Table.
 */
public class TableController implements ITableController{

    @Override
    public void insert(Table table) throws Exception {
        if (table == null) {
            throw new Exception("La mesa es nula");
        }
        if (table.getNumber()== 0) {
            throw new Exception("El numero debe de ser obligatorio");
        }
        if (table.getCapacity()== 0) {
            throw new Exception("El numero de capacidad debe de ser obligatorio");
        }
        if("".equals(table.getStatus())){
            throw new Exception("El estado de la mesa es obligatorio");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getTableDAO().insert(table);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Table table) throws Exception {
        if (table == null) {
            throw new Exception("La mesa es nula");
        }
        if (table.getId()== 0) {
            throw new Exception("El id debe de ser obligatorio");
        }
        if (table.getNumber()== 0) {
            throw new Exception("El numero debe de ser obligatorio");
        }
        if (table.getCapacity()== 0) {
            throw new Exception("El numero de capacidad debe de ser obligatorio");
        }
        if("".equals(table.getStatus())){
            throw new Exception("El estado de la mesa es obligatorio");
        }
        
         //Consultar si la carrera existe en la bd.
         Table tableExist = DAOFactory.getTableDAO().findById(table.getId());
         if(tableExist == null)
        {
            throw new Exception("la mesa no existe");
        }
         
        //Merge
         tableExist.setId(table.getId());
         tableExist.setNumber(table.getNumber());
         tableExist.setCapacity(table.getCapacity());
         tableExist.setStatus(table.getStatus());
         
         //Actualizar
         EntityManagerHelper.beginTransaction();
        DAOFactory.getTableDAO().update(table);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Table table) throws Exception {
        if (table == null ||  table.getId() == null || table.getId() <= 0) {
            throw new Exception("El ID del usuario es obligatorio y debe ser mayor a 0.");
        }
        
        // Verificar si el usuario existe
        Table tableExist = DAOFactory.getTableDAO().findById(table.getId());
        if (tableExist == null) {
            throw new Exception("La mesa con ese ID " + table.getId() + " no existe.");
        }

        // Eliminar el usuario
        EntityManagerHelper.beginTransaction();
        DAOFactory.getTableDAO().delete(tableExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Table findById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID del usuario es obligatorio y debe ser mayor a 0.");
        }

        Table tableExist = DAOFactory.getTableDAO().findById(id);
        if (tableExist == null) {
            throw new Exception("El usuario con ID " + id + " no existe.");
        }

        return tableExist;
    }

    @Override
    public List<Table> findAll() throws Exception {
        return DAOFactory.getTableDAO().findAll();
    }
    
}
