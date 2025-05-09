/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Users;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para el modelo de Users
 */
public interface IUsersController {
    public void insert(Users users) throws Exception;
    public void update(Users users) throws Exception;
    public void delete(Users users) throws Exception;
    public Users findById(Long id) throws Exception;
    public List<Users> findAll() throws Exception;
}
