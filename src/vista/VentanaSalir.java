/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Jugador;



/**
 *
 * @author mende
 */
public class VentanaSalir extends JFrame{
    private JLabel jlJugador;
    private JLabel jlNombreJugador;
    private JLabel jlNumeroRonda;
    private JLabel jlRonda;
    private JLabel jlIntento;
    private JLabel jlNumeroIntento;
    private JPanel jpContenido;
  
    private JuegoTamaño juegoTamaño;
    
    public VentanaSalir(Jugador jugador){
        juegoTamaño = new JuegoTamaño(jugador);
        juegoTamaño.iniciarRonda();
        iniciarComponentes();
        setSize(519,530);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Jugando a Adivinar");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    private void iniciarComponentes(boolean acierto){
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        //Configuración del Encabezado
        jpContenido = new JPanel();
        
        jlJugador = new JLabel("Jugador : ");
        jlJugador.setBounds(5,110, 519,35);
        jlJugador.setForeground(new Color(0,87,193));
        jlJugador.setFont(new Font("arial", Font.BOLD, 20));
               
        String nombre = juegoTamaño.getJugador();
        nombre =    nombre.substring(0,1).toUpperCase() + 
                    nombre.substring(1).toLowerCase();
        jlNombreJugador = new JLabel(nombre);
        jlNombreJugador.setBounds(100,110, 519,35);
        jlNombreJugador.setForeground(Color.GRAY);
        jlNombreJugador.setFont(new Font("arial", Font.BOLD, 20));
        
        jlRonda = new JLabel("Ronda # : ");
        jlRonda.setBounds(230,110, 519,35);
        jlRonda.setForeground(new Color(0,87,193));
        jlRonda.setFont(new Font("arial", Font.BOLD, 20));
                
        jlNumeroRonda = new JLabel(
                String.valueOf(juegoTamaño.getNumeroRonda()));
        jlNumeroRonda.setBounds(330,110, 519,35);
        jlNumeroRonda.setForeground(Color.GRAY);
        jlNumeroRonda.setFont(new Font("arial", Font.BOLD, 20));
        
        jlIntento = new JLabel("Intento # : ");
        jlIntento.setBounds(375,110, 519,35);
        jlIntento.setForeground(new Color(0,87,193));
        jlIntento.setFont(new Font("arial", Font.BOLD, 20));
        
        jlNumeroIntento = new JLabel(
                String.valueOf(juegoTamaño.getIntentosRonda()));
        jlNumeroIntento.setBounds(475,110, 519,35);
        jlNumeroIntento.setForeground(Color.GRAY);
        jlNumeroIntento.setFont(new Font("arial", Font.BOLD, 20));
        
        jpContenido.add(jlJugador);
        jpContenido.add(jlNombreJugador);
        jpContenido.add(jlRonda);
        jpContenido.add(jlNumeroRonda);
        jpContenido.add(jlIntento);
        jpContenido.add(jlNumeroIntento);
        
        
        jpContenido.setSize(519,500);        
        jpContenido.setBounds(0,110, 519, 500);
        jpContenido.setLayout(null);
        
        add(jpContenido);
        
        jlNumeroIntento.setText(
                String.valueOf(juegoTamaño.getIntentosRonda()));

        if(acierto){
            JOptionPane.showMessageDialog(null,
            "¡IMPRESIONANTE!, \n\nHaz adivinado"
            + " el número en " +
            juegoTamaño.getIntentosRonda() +
            "  intentos. \n\nFELICITACIONES!!!\n", "Haz ganado",
            JOptionPane.INFORMATION_MESSAGE);

            juegoTamaño.compararRondas();

            jugarOtraVez();

        } else {
             JOptionPane.showMessageDialog(null,
            "Lo siento, haz fallado!!. \n\nPero no importa, " +
            "en el siguiente intento lo lograras! " +
            "\n\nEl número a adivinar es [ " + mensaje + 
            " ] al número ingresado [ " + numero + " ]", 
            "Haz fallado - Llevas " +
            juegoTamaño.getIntentosRonda() + " intentos" ,
            JOptionPane.ERROR_MESSAGE);
            txtNumero.setSelectionStart(0);
            txtNumero.setSelectionEnd(txtNumero.getText().trim().length());
        }                
        txtNumero.requestFocusInWindow();
    }
    
    public void jugarOtraVez(){
        int respuesta;
        
        respuesta = JOptionPane.showConfirmDialog(
                null,"¿Desea jugar otra vez?", "Información",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(respuesta == JOptionPane.YES_OPTION){
            juegoTamaño.iniciarRonda();
            jlNumeroRonda.setText(
                    String.valueOf(juegoTamaño.getNumeroRonda()));
            
            jlNumeroIntento.setText(
                        String.valueOf(juegoTamaño.getIntentosRonda()));
            txtNumero.setText("");
        } else {
            dispose();
            JOptionPane.showMessageDialog(null,
            "ESTADÍSTICAS DEL JUEGO\n\n" + 
            "Total Rondas : " + juegoTamaño.getNumeroRonda() +
            "\nLa mejor Ronda fue la # " + 
            juegoTamaño.getMejorRonda().getNumeroRonda() + " con " +
                    juegoTamaño.getMejorRonda().getIntentosRonda() +
                    " Intentos", 
            "Hasta la vista Baby!!!",
            JOptionPane.INFORMATION_MESSAGE);            
        }
    }
}
