/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logica.JuegoFiguras;

/**
 *
 * @author mende
 */
public class VentanaJuego extends JFrame {
    private JPanel jpContenido;
    private JLabel iconBarra;
    private ImageIcon imgBarra;
    private JuegoFiguras jFiguras;
    
    public VentanaJuego (){
        jFiguras = new JuegoFiguras();
        iniciarComponentes();
    }
    
    private void iniciarComponentes() {
        //Configuración de la ventana
        setTitle("JUEGO FIGURAS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/FigurasIcon.png")));
        setSize(1366,768);
        setLocationRelativeTo(null); 
        setVisible(true);
        setResizable(false);
        
        //Configuración del encabezado
        jpContenido = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Establece el color de fondo del JPanel
                Color colorJuego = new Color(188,113,200);
                g.setColor(colorJuego); // Cambia el color aquí
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        
        // Mostrar figuras en sus respectivos espacios
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; // Columna 0
        constraints.gridy = 0; // Fila 0 En esta fila irán los JLabel adicionales del proyecto(nombre, estadisticas)
        constraints.insets = new Insets(10, 30, 10, 30);// Espacio entre componentes
        
            // Mostrar figura de referencia en columna 0
        jpContenido.add(jFiguras.obtenerFiguraReferencia(),constraints);
        
            // Mostrar imágen separador en columna 1
        constraints.gridx = 1; // Columna 1
        imgBarra = new ImageIcon(getClass().getResource("/imagenes/Barra.png"));
        iconBarra = new JLabel(imgBarra);
        jpContenido.add(iconBarra,constraints);
        
           // Mostrar Figuras para elegir en columnas 2, 3 y 4
        List<JLabel> figuras = jFiguras.figurasMostrar();
        for (int i = 0; i < 3; i++) {
            constraints.gridx = i + 2;
            jpContenido.add(figuras.get(i), constraints);
        }
        
        add(jpContenido);
    }
}