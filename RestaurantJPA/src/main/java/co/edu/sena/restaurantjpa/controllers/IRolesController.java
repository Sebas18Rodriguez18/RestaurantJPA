/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Roles;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para el modelo de Roles
 */
public interface IRolesController {
    public void insert(Roles roles) throws Exception;
    public void update(Roles roles) throws Exception;
    public void delete(Roles roles) throws Exception;
    public Roles findById(Long id) throws Exception;
    public List<Roles> findAll() throws Exception;
}
