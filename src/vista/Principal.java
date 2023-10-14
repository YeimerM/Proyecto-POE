/*

 Yeimer Armando Mendez Sanchez
 FPOE Grp. #81
 LAB #1
 11 de octubre de 2023

 */
package vista;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Principal {
    public static void main(String[] args) {
     SwingUtilities.invokeLater(() -> {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     });   
    }}