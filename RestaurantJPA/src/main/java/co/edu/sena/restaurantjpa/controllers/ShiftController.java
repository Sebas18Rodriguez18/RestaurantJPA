/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Shift;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import co.edu.sena.restaurantjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 09/05/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Shift.
 */
public class ShiftController implements IShiftController{

    @Override
    public void insert(Shift shift) throws Exception {
        if (shift == null) {
            throw new Exception("El turno es nulo");
        }
        if ("".equals(shift.getDate())) {
            throw new Exception("La fecha del turno es obligatoria");
        }
        if ("".equals(shift.getStartTime())) {
            throw new Exception("La fecha inicio del turno es obligatoria");
        }
        if ("".equals(shift.getEndTime())) {
            throw new Exception("La hora fin del turno es obligatoria");
        }
        if ("".equals(shift.getStatus())) {
            throw new Exception("El estado del turno es obligatorio");
        }
        
        //FK
        if (shift.getUserId() == null) {
            throw new Exception("El id del usuario es obligatorio");
        }
        
        //Agregar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getShiftDAO().insert(shift);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Shift shift) throws Exception {
        if (shift == null) {
            throw new Exception("El turno es nulo");
        }
        if (shift.getId() == 0) {
            throw new Exception("El id es obligatorio");
        }
        if ("".equals(shift.getDate())) {
            throw new Exception("La fecha del turno es obligatoria");
        }
        if ("".equals(shift.getStartTime())) {
            throw new Exception("La fecha inicio del turno es obligatoria");
        }
        if ("".equals(shift.getEndTime())) {
            throw new Exception("La hora fin del turno es obligatoria");
        }
        if ("".equals(shift.getStatus())) {
            throw new Exception("El estado del turno es obligatorio");
        }
        
        //FK
        if (shift.getUserId() == null) {
            throw new Exception("El id del usuario es obligatorio");
        }
        
        //Consultar si la carrera existe en la bd.
        Shift shiftExist = DAOFactory.getShiftDAO().findById(shift.getId());
        if(shiftExist == null)
        {
            throw new Exception("el usuario no existe");
        }
        
        //Merge:
        shiftExist.setId(shift.getId());
        shiftExist.setUserId(shift.getUserId());
        shiftExist.setDate(shift.getDate());
        shiftExist.setStartTime(shift.getStartTime());
        shiftExist.setEndTime(shift.getEndTime());
        shiftExist.setStatus(shift.getStatus());
        
        //Actualizar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getShiftDAO().update(shift);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Shift shift) throws Exception {
        if (shift == null || shift.getId() == null || shift.getId() <= 0) {
            throw new Exception("El ID del usuario es obligatorio y debe ser mayor a 0.");
        }
        
        // Verificar si el usuario existe
        Shift shiftExist = DAOFactory.getShiftDAO().findById(shift.getId());
        if (shiftExist == null) {
            throw new Exception("El usuario con ID " + shift.getId() + " no existe.");
        }

        // Eliminar el usuario
        EntityManagerHelper.beginTransaction();
        DAOFactory.getShiftDAO().delete(shiftExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Shift findById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID del turno es obligatorio y debe ser mayor a 0.");
        }

        Shift shiftExist = DAOFactory.getShiftDAO().findById(id);
        if (shiftExist == null) {
            throw new Exception("El turno con ID " + id + " no existe.");
        }

        return shiftExist;
    }

    @Override
    public List<Shift> findAll() throws Exception {
        return DAOFactory.getShiftDAO().findAll();
    }
    
}
