/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author mende
 * 
 *      JTextField campoTexto = new JTextField();
        campoTexto.setText("Escriba su nombre");
        jpContenido.add(campoTexto);
        campoTexto.setBounds(100, 100,300,300);
 */
public final class VentanaJugador extends JFrame {
    private JPanel jpContenido;
    private JTextField nombre;
    private JButton next;
    private JLabel jlNombre;
    
    public VentanaJugador(){
        iniciarComponentes();
    }
    private void iniciarComponentes() {
        //Configuración de la ventana
        setTitle("Jugador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080,720);
        setLocationRelativeTo(null); 
        setVisible(true);
        setResizable(false);
        setLayout(null);
    jpContenido=new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
    nombre=new JTextField(4);
    add(jpContenido); 
    nombre.setBounds(0,0,300,300);
    jpContenido.add(nombre);
    
    }
}