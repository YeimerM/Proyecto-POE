/*

 Yeimer Armando Mendez Sanchez
 FPOE Grp. #81
 LAB #1
 11 de octubre de 2023

 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import modelo.Jugador;


public final class VentanaJugador extends JFrame {
    private JPanel jpContenido;
    private ImageIcon imgMenu;
    private JTextField txtNombre;
    private JLabel jlNombre;
    private JButton btnJugar;

    
    public VentanaJugador(){
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        //Configuración de la ventana
        setTitle("Jugador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/FigurasIcon.png")));
        setSize(1366,768);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
        setLayout(null);    
        
        //Configuración del encabezado
        jpContenido = new JPanel(){
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
        
        jlNombre = new JLabel("Ingresa tu nombre",SwingConstants.CENTER );
        
        
        
        jlNombre.setBounds(418,280, 519,35);
        jlNombre.setForeground(new Color(0,87,193));
        jlNombre.setFont(new Font("arial", Font.BOLD, 20)); 
        jpContenido.add(jlNombre);
        
        txtNombre = new JTextField("");
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setForeground(Color.GRAY);
        txtNombre.setFont(new Font("arial", Font.BOLD, 20));
        
        jpContenido.add(txtNombre);
        txtNombre.setBounds(470,320,410, 40);
        
        ImageIcon iconoIniciar = new ImageIcon(getClass().getResource("/imagenes/icons/Iniciar.png"));
        Image imgJ = iconoIniciar.getImage();
        imgJ = imgJ.getScaledInstance(300,150,Image.SCALE_SMOOTH); // Escalar el icono
        iconoIniciar = new ImageIcon(imgJ);
        btnJugar = new JButton( iconoIniciar);
        btnJugar.setBounds(560,400, 225,75);
        
        jpContenido.add(btnJugar);
        ManejadorDeEventos manejador = new ManejadorDeEventos();
        btnJugar.addActionListener(manejador);
        txtNombre.addKeyListener(manejador);

    }
    
    private void iniciarJuego(){
        String nombre =txtNombre.getText();
        if(!nombre.trim().isEmpty() || nombre.trim().length() > 0){
            Jugador jugador = new Jugador(nombre);
            dispose();
            VentanaJuego ventanaJ;
            ventanaJ = new VentanaJuego(jugador);
        } else {
            JOptionPane.showMessageDialog(null,"Por favor ingrese su nombre", 
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocusInWindow();
        }
    }
    
    class ManejadorDeEventos implements ActionListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnJugar){                
                iniciarJuego();
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            if(e.getKeyCode() == e.VK_ENTER){
                btnJugar.doClick();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
    }
}
