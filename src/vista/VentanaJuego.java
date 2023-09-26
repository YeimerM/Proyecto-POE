/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mende
 */
public final class VentanaJuego extends JFrame {
    private JPanel jpContenido;
    
    public VentanaJuego (){
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        //Configuración de la ventana
        setTitle("Juego Figuras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080,720);
        setLocationRelativeTo(null); 
        setVisible(true);
        setResizable(false);
        setLayout(null);
        
        //Configuración del encabezado
        jpContenido = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Establece el color de fondo del JPanel
                Color colorJuego = new Color(210,60,234);
                g.setColor(colorJuego); // Cambia el color aquí
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        jpContenido.setSize(getWidth(),getHeight());        
        jpContenido.setBounds(0,0, getWidth(), getHeight());
        jpContenido.setLayout(null);
        
        add(jpContenido);
    }
}
