/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Box;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import java.util.List;

/**
 * Fecha: 11/05/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Box.
 */
public class BoxController implements IBoxController{

    @Override
    public void insert(Box box) throws Exception {
    }

    @Override
    public void update(Box box) throws Exception {
    }

    @Override
    public void delete(Box box) throws Exception {
    }

    @Override
    public Box findById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Box> findAll() throws Exception {
        return DAOFactory.getBoxDAO().findAll();
    }

    
}
