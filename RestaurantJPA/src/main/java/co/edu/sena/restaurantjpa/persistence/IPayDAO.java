/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

import co.edu.sena.restaurantjpa.model.Pay;
import java.util.List;

/**
 * Fecha: 07/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para DAO de Pay
 */
public interface IPayDAO {
    public void insert(Pay pay) throws Exception;
    public void update(Pay pay) throws Exception;
    public void delete(Pay pay) throws Exception;
    public Pay findById(Long id) throws Exception;
    public List<Pay> findAll() throws Exception;
}
