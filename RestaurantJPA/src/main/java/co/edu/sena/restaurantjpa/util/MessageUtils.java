/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.util;

import javax.swing.JOptionPane;

/**
 * Fecha: 09/05/2025
 * @author Sebastian Rodriguez
 * Objetivo: Clase para utileria de mensajes en pantalla
 */
public class MessageUtils {
    
    public static void ShowInfoMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void ShowWarningMessage(String message)
    {
        JOptionPane.showConfirmDialog(null, message, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    public static void ShowErrorMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
