/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Kitchen;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para DAO de Kitchen
 */
public interface IKitchenDAO {
    public void insert(Kitchen kitchen) throws Exception;
    public void update(Kitchen kitchen) throws Exception;
    public void delete(Kitchen kitchen) throws Exception;
    public Kitchen findById(Long id) throws Exception;
    public List<Kitchen> findAll() throws Exception;
}
