/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Box;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import co.edu.sena.restaurantjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 11/05/2025
 * Autor: Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Box.
 */
public class BoxController implements IBoxController {

    @Override
    public void insert(Box box) throws Exception {
        if (box == null) {
            throw new Exception("La caja es nula");
        }
        if (box.getName() == null || box.getName().isEmpty()) {
            throw new Exception("El nombre de la caja es obligatorio");
        }
        if (box.getStatus() == null || box.getStatus().isEmpty()) {
            throw new Exception("El estado de la caja es obligatorio");
        }
        if (box.getInitialBalance() == null || box.getInitialBalance().doubleValue() < 0) {
            throw new Exception("El saldo inicial debe ser mayor o igual a 0");
        }
        if (box.getCurrentBalance() == null || box.getCurrentBalance().doubleValue() < 0) {
            throw new Exception("El saldo actual debe ser mayor o igual a 0");
        }

        // Validar llave foránea
        if (box.getCashierId() == null) {
            throw new Exception("El ID del cajero es obligatorio");
        }

        EntityManagerHelper.beginTransaction();
        DAOFactory.getBoxDAO().insert(box);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Box box) throws Exception {
        if (box == null) {
            throw new Exception("La caja es nula");
        }
        if (box.getId() == null || box.getId() <= 0) {
            throw new Exception("El ID de la caja es obligatorio y debe ser mayor a 0");
        }
        if (box.getName() == null || box.getName().isEmpty()) {
            throw new Exception("El nombre de la caja es obligatorio");
        }
        if (box.getStatus() == null || box.getStatus().isEmpty()) {
            throw new Exception("El estado de la caja es obligatorio");
        }
        if (box.getInitialBalance() == null || box.getInitialBalance().doubleValue() < 0) {
            throw new Exception("El saldo inicial debe ser mayor o igual a 0");
        }
        if (box.getCurrentBalance() == null || box.getCurrentBalance().doubleValue() < 0) {
            throw new Exception("El saldo actual debe ser mayor o igual a 0");
        }

        // Validar llave foránea
        if (box.getCashierId() == null) {
            throw new Exception("El ID del cajero es obligatorio");
        }

        // Verificar si la caja existe en la base de datos
        Box boxExist = DAOFactory.getBoxDAO().findById(box.getId());
        if (boxExist == null) {
            throw new Exception("La caja con ID " + box.getId() + " no existe.");
        }

        // Actualizar campos
        boxExist.setName(box.getName());
        boxExist.setStatus(box.getStatus());
        boxExist.setInitialBalance(box.getInitialBalance());
        boxExist.setCurrentBalance(box.getCurrentBalance());
        boxExist.setCashierId(box.getCashierId());

        EntityManagerHelper.beginTransaction();
        DAOFactory.getBoxDAO().update(boxExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Box box) throws Exception {
        if (box == null || box.getId() == null || box.getId() <= 0) {
            throw new Exception("El ID de la caja es obligatorio y debe ser mayor a 0.");
        }

        // Verificar si la caja existe
        Box boxExist = DAOFactory.getBoxDAO().findById(box.getId());
        if (boxExist == null) {
            throw new Exception("La caja con ID " + box.getId() + " no existe.");
        }

        // Eliminar la caja
        EntityManagerHelper.beginTransaction();
        DAOFactory.getBoxDAO().delete(boxExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Box findById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID de la caja es obligatorio y debe ser mayor a 0.");
        }

        Box boxExist = DAOFactory.getBoxDAO().findById(id);
        if (boxExist == null) {
            throw new Exception("La caja con ID " + id + " no existe.");
        }

        return boxExist;
    }

    @Override
    public List<Box> findAll() throws Exception {
        return DAOFactory.getBoxDAO().findAll();
    }
}
