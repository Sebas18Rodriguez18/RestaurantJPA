/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Shift;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para el modelo de Shift
 */
public interface IShiftController {
    public void insert(Shift  shift) throws Exception;
    public void update(Shift  shift) throws Exception;
    public void delete(Shift  shift) throws Exception;
    public Shift findById(Long id) throws Exception;
    public List<Shift> findAll() throws Exception;
}
