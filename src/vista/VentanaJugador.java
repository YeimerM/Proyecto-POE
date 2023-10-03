/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jhenn
 */
public final class VentanaJugador extends JFrame{
    private JPanel jpContenido;
    private JLabel jlNombre;
    private TextField txtNombre;
    private JButton btnNext;
    private ImageIcon imgMenu;
    
    public VentanaJugador(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        setTitle("Jugador");
        setSize(1366,768);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(450,500);
        
        jpContenido = new JPanel(){
        //colocar fondo 
            // Establecer fondo del panel y pintar la imágen del menú
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Establece el color de fondo del JPanel
                g.setColor(Color.ORANGE); // Cambia el color aquí
                g.fillRect(0, 0, getWidth(), getHeight());
                 // Se pinta la imagen del menú
                imgMenu.paintIcon(this, g, (getWidth()-imgMenu.getIconWidth())/2,(getHeight() - imgMenu.getIconHeight()) / 2);
            }
        };
        // Imágen del menú
        imgMenu = new ImageIcon(getClass().getResource("/imagenes/tableroMenu.png"));
        Image imgM = imgMenu.getImage();
        imgM = imgM.getScaledInstance(1180,600,Image.SCALE_SMOOTH); // Escalar la imágen para aumentar tamaño
        imgMenu = new ImageIcon(imgM);
        
        jpContenido.setSize(getWidth(),getHeight());        
        jpContenido.setBounds(0,0, getWidth(), getHeight());
        jpContenido.setLayout(null);
        
        add(jpContenido);
        
        Botones();
    }

    private void Botones() {
        
        this.setLayout(null);
        
        add(jlNombre = new JLabel("NOMBRE:"));
        jlNombre.setBounds(500,200,300,40);
        
        add(txtNombre = new TextField());
        txtNombre.setBounds(550,250,250,30);
        
        add(btnNext = new JButton("CONTINÚA"));
        btnNext.setBounds(580,500,200,100);
        
        add(jpContenido);
        
    }
        
    private void ventanaPrincipal(){
        dispose();
        VentanaPrincipal ventanaPrincipal =new VentanaPrincipal();
    }
        
    class ManejadorDeEventos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNext){
            ventanaPrincipal();
            }
        }   
    }
}