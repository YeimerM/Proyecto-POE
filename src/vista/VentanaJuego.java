/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mende
 */
public final class VentanaJuego extends JFrame {
    private JPanel jpContenido;
    private BufferedImage imagenFondo;
    
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
        
        try {
            // Carga la imagen de fondo desde el directorio de clases del proyecto
            imagenFondo = ImageIO.read(getClass().getResource("/imagenes/fondo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Configuración del encabezado
        jpContenido = new JPanel();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
