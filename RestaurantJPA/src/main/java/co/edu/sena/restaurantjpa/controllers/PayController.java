/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.controllers;

import co.edu.sena.restaurantjpa.model.Pay;
import co.edu.sena.restaurantjpa.model.Order1;
import co.edu.sena.restaurantjpa.model.Box;
import co.edu.sena.restaurantjpa.persistence.DAOFactory;
import co.edu.sena.restaurantjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 10/05/2025
 * Autor: Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Pay.
 */
public class PayController implements IPayController {

    @Override
    public void insert(Pay pay) throws Exception {
        if (pay == null) {
            throw new Exception("El objeto Pay no puede ser nulo.");
        }
        if (pay.getAmount() == null || pay.getAmount().doubleValue() <= 0) {
            throw new Exception("El monto del pago debe ser mayor a 0.");
        }
        if (pay.getPaymentDate() == null) {
            throw new Exception("La fecha del pago es obligatoria.");
        }
        if (pay.getPaymentMethod() == null || pay.getPaymentMethod().isEmpty()) {
            throw new Exception("El método de pago es obligatorio.");
        }
        if (pay.getOrderId() == null) {
            throw new Exception("El pedido asociado (order_id) es obligatorio.");
        }
        if (pay.getBoxId() == null ) {
            throw new Exception("La caja asociada (box_id) es obligatoria.");
        }

        // Verificar que las claves foráneas existan
        Order1 order = DAOFactory.getOrderDAO().findById(pay.getBoxId().getId());
        if (order == null) {
            throw new Exception("El pedido con ID " + pay.getOrderId().getId() + " no existe.");
        }

        Box box = DAOFactory.getBoxDAO().findById(pay.getBoxId().getId());
        if (box == null) {
            throw new Exception("La caja con ID " + pay.getBoxId().getId() + " no existe.");
        }

        // Insertar el pago
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPayDAO().insert(pay);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Pay pay) throws Exception {
        if (pay == null || pay.getId() == null || pay.getId() <= 0) {
            throw new Exception("El ID del pago es obligatorio y debe ser mayor a 0.");
        }

        // Verificar si el pago existe
        Pay existingPay = DAOFactory.getPayDAO().findById(pay.getId());
        if (existingPay == null) {
            throw new Exception("El pago con ID " + pay.getId() + " no existe.");
        }

        // Actualizar los campos
        if (pay.getAmount() != null && pay.getAmount().doubleValue() > 0) {
            existingPay.setAmount(pay.getAmount());
        }
        if (pay.getPaymentDate() != null) {
            existingPay.setPaymentDate(pay.getPaymentDate());
        }
        if (pay.getPaymentMethod() != null && !pay.getPaymentMethod().isEmpty()) {
            existingPay.setPaymentMethod(pay.getPaymentMethod());
        }
        if (pay.getOrderId()!= null && pay.getOrderId().getId() != null) {
            Order1 order = DAOFactory.getOrderDAO().findById(pay.getOrderId().getId());
            if (order == null) {
                throw new Exception("El pedido con ID " + pay.getOrderId().getId() + " no existe.");
            }
            existingPay.setOrderId(order);
        }
        if (pay.getBoxId()!= null && pay.getBoxId().getId() != null) {
            Box box = DAOFactory.getBoxDAO().findById(pay.getBoxId().getId());
            if (box == null) {
                throw new Exception("La caja con ID " + pay.getBoxId().getId() + " no existe.");
            }
            existingPay.setBoxId(box);
        }

        // Guardar los cambios
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPayDAO().update(existingPay);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Pay pay) throws Exception {
        if (pay == null || pay.getId() == null || pay.getId() <= 0) {
            throw new Exception("El ID del pago es obligatorio y debe ser mayor a 0.");
        }

        // Verificar si el pago existe
        Pay existingPay = DAOFactory.getPayDAO().findById(pay.getId());
        if (existingPay == null) {
            throw new Exception("El pago con ID " + pay.getId() + " no existe.");
        }

        // Eliminar el pago
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPayDAO().delete(existingPay);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Pay findById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID del pago es obligatorio y debe ser mayor a 0.");
        }

        Pay pay = DAOFactory.getPayDAO().findById(id);
        if (pay == null) {
            throw new Exception("El pago con ID " + id + " no existe.");
        }

        return pay;
    }

    @Override
    public List<Pay> findAll() throws Exception {
        return DAOFactory.getPayDAO().findAll();
    }
}
