/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mende
 */
public final class VentanaPrincipal extends JFrame {
    
    private JButton btnJugar;
    private JButton btnInstru;
    private JPanel jpContenido;
    
    public VentanaPrincipal(){
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        //Configuración de la ventana
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080,720);
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
            }
        };
        
        jpContenido.setSize(getWidth(),getHeight());        
        jpContenido.setBounds(0,0, getWidth(), getHeight());
        jpContenido.setLayout(null);
        
        add(jpContenido);
        
        ImageIcon iconoJugar = new ImageIcon("/imagenes/Jugar1.png");
        
        btnJugar = new JButton(iconoJugar);
        btnJugar.setBounds(500,400, 200,42);
        
        btnInstru = new JButton("instrucciones");
        btnInstru.setBounds(500,180, 200,42);
        
        jpContenido.add(btnJugar);
        jpContenido.add(btnInstru);
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        btnJugar.addActionListener(manejadorEventos);
    }
    
    
    private void iniciarJuego(){
        dispose();
        VentanaJuego ventanaJuego = new VentanaJuego(); // VentanaJugador debe pasar para luego desde ahi con el next a VentanaJuego
    }
    
    private class ManejadorDeEventos implements ActionListener, KeyListener {
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnJugar){                
                iniciarJuego();
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
           /* System.out.println("Se liberó la tecla " + e.getKeyChar() +
                    " Con codigo " + e.getKeyCode());*/
            if(e.getKeyCode() == e.VK_ENTER){
                btnJugar.doClick();
            }
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            /*System.out.println("Se presionó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
            
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            /*System.out.println("Se digitó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
        }
    }
}
