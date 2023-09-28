/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mende
 */
public final class VentanaPrincipal extends JFrame {
    
    private JButton btnJugar;
    private JButton btnInstru;
    private JButton btnVolver;
    private JPanel jpContenido;
    private JPanel jpInstrucciones;
    private ImageIcon imgMenu;
    private ImageIcon iconoJugar;
    private ImageIcon iconoInstru;
    private ImageIcon iconoVolver;
    private ImageIcon imgInstru;
    private JLabel jlInstru;
    
    public VentanaPrincipal(){
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        //Configuración de la ventana
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366,768);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        
        //Configuración del encabezado
        jpContenido = new JPanel(){
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
            
        // Botones
        iconoJugar = new ImageIcon(getClass().getResource("/imagenes/icons/Jugar1.png"));
        Image imgJ = iconoJugar.getImage();
        imgJ = imgJ.getScaledInstance(275,88,Image.SCALE_SMOOTH); // Escalar el icono
        iconoJugar = new ImageIcon(imgJ);
        btnJugar = new JButton( iconoJugar);
        btnJugar.setBounds(540,240, 275,88);
        
        iconoInstru = new ImageIcon(getClass().getResource("/imagenes/icons/Instrucciones1.png"));
        Image imgI = iconoInstru.getImage();
        imgI = imgI.getScaledInstance(465,88,Image.SCALE_SMOOTH); // Escalar el icono
        iconoInstru = new ImageIcon(imgI);
        btnInstru = new JButton(iconoInstru);
        btnInstru.setBounds(450,345, 465,88);
        
        jpContenido.add(btnJugar);
        jpContenido.add(btnInstru);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        btnJugar.addActionListener(manejadorEventos);
        btnInstru.addActionListener(manejadorEventos);
        
        // Configuración panel de instrucciones
        jpInstrucciones = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Establece el color de fondo del JPanel
                g.setColor(Color.ORANGE); // Cambia el color aquí
                g.fillRect(0, 0, getWidth(), getHeight());
                // Se pinta la imagen del menú
                imgMenu.paintIcon(this, g, (getWidth()-imgMenu.getIconWidth())/2,(getHeight() - imgMenu.getIconHeight()) / 2);
            };
        };
        
        jpInstrucciones.setSize(getWidth(),getHeight());        
        jpInstrucciones.setBounds(0,0, getWidth(), getHeight());
        jpInstrucciones.setLayout(null);
        
        
        iconoVolver = new ImageIcon(getClass().getResource("/imagenes/icons/Volver1.png"));
        Image ImgV = iconoVolver.getImage();
        ImgV = ImgV.getScaledInstance(275,88,Image.SCALE_SMOOTH); // Escalar la imágen para aumentar tamaño
        iconoVolver = new ImageIcon(ImgV);
        btnVolver = new JButton(iconoVolver);
        btnVolver.setBounds(560,500, 275,88);
        
        jpInstrucciones.add(btnVolver);
        btnVolver.addActionListener(manejadorEventos);
        
    }
    
    
    private void iniciarJuego(){
        dispose();
        VentanaJuego ventanaJuego = new VentanaJuego(); // VentanaJugador debe pasar para luego desde ahi con el next a VentanaJuego
    }
    
    private void verInstru () {
        getContentPane().remove(jpContenido);
        getContentPane().add(jpInstrucciones);
        revalidate();
        repaint();
        
        // Acomodar botón Jugar
        btnJugar.setBounds(560,400, 275,88);
        jpInstrucciones.add(btnJugar);
        
        // Dibujar letrero Instrucciones
        imgInstru = new ImageIcon(getClass().getResource("/imagenes/letreroInstru.png"));
        Image imgIns = imgInstru.getImage();
        imgIns = imgIns.getScaledInstance(700,200,Image.SCALE_SMOOTH); // Escalar el letrero
        imgInstru = new ImageIcon(imgIns);
        jlInstru = new JLabel(imgInstru);
        jlInstru.setBounds(330,150,700,200);
        jpInstrucciones.add(jlInstru);
    }
    
    private void verMenu() {
        getContentPane().remove(jpInstrucciones);
        getContentPane().add(jpContenido);
        revalidate();
        repaint();
        
        // Reorganizar botón Jugar
        btnJugar.setBounds(540,240, 275,88);
        jpContenido.add(btnJugar);
    }
    
    private class ManejadorDeEventos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnJugar){                
                iniciarJuego();
            }
            if(evento.getSource() == btnInstru) {
                verInstru();
            }
            if(evento.getSource() == btnVolver){
                verMenu();
            }
        }
    }
}
