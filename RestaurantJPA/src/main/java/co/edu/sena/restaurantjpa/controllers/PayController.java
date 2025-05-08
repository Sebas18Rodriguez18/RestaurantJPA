/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.controllers.IPayController;
import co.edu.sena.restaurantjpa.model.Pay;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Pay.
 */
public class PayController implements IPayController{

    @Override
    public void insert(Pay pay) throws Exception {
    }

    @Override
    public void update(Pay pay) throws Exception {
    }

    @Override
    public void delete(Pay pay) throws Exception {
    }

    @Override
    public Pay findById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Pay> findAll() throws Exception {
        return null;
    }
    
}
