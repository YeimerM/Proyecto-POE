/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.time.Clock.system;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
*/
/**
 *
 * @author jhenn
 */
public final class VentanaJugador extends JFrame{
    JLabel jlNombre;
    TextField txtNombre;
    JButton btnNext;
    
    public VentanaJugador (){
        this.setTitle("");
        this.setSize(400,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(450,500);
        
        Botones();
        Repaint();
    }

    private void Botones() {
        this.setLayout(null);
        
        add(jlNombre = new JLabel("Nombre:"));
        jlNombre.setBounds(10,10,70,20);
        
        add(txtNombre = new TextField());
        txtNombre.setBounds(150,10,200,20);
        
        add(btnNext = new JButton("NEXT"));
        btnNext.setBounds(150,150,100,30);
        
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Nombre: "+txtNombre.getText().toString());
                JOptinePane.showMessageDialog(null,"nombre: "+txtNombre.getText.toString());
            }
        });
    }

    private void Repaint() {
        
    }
}
    
       
/*public final class VentanaJugador extends JFrame {
    private JPanel jpContenido;
    private JButton btnNext;
    private ImageIcon iconoNext;
    private ImageIcon imgMenu;
    private JButton1 btnNombre;
    
    public VentanaJugador(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        //Configuración de la ventana
        setTitle("Jugador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366,768);
        setLocationRelativeTo(null); 
        setVisible(true);
        setResizable(false);
        setLayout(null);
        
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
        
        //Botón
        iconoNext = new ImageIcon(getClass().getResource("/imagenes/icons/Next1.png"));
        Image imgN = iconoNext.getImage();
        imgN = imgN.getScaledInstance(300,100,Image.SCALE_SMOOTH); // Escalar el icono
        iconoNext = new ImageIcon(imgN);
        btnNext = new JButton( iconoNext);
        btnNext.setBounds(500,400, 300,100);
        jpContenido.add(btnNext);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        btnNext.addActionListener((ActionListener) manejadorEventos);  
        
    };

    private class ManejadorDeEventos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnNext){                
                //VentanaPrincipal;
            }
        }
    }  
}
*/