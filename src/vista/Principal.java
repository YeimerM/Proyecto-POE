/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author mende
 */
public class Principal {
    public static void main(String[] args) {
     SwingUtilities.invokeLater(() -> {
         
        VentanaJuego ventana = new VentanaJuego();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //VentanaPrincipal ventana = new VentanaPrincipal();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     });   
    }}