/*

 Yeimer Armando Mendez Sanchez
 FPOE Grp. #81
 LAB #1
 11 de octubre de 2023

 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logica.JuegoFiguras;
import modelo.Jugador;


public class VentanaJuego extends JFrame {
    private JPanel jpContenido;
    private JButton jbSalir;
    private JLabel jlJugador;
    private JLabel ctdFiguras;
    private JLabel ctdIntentos;
    private JLabel ctdFallos;
    private JLabel iconBarra;
    private ImageIcon imgBarra;
    private JuegoFiguras jFiguras;
    private JLabel figuraRef;
    private double widthFiguraRef;
    private JLabel figura;
    private List<JLabel> figuras;
    private Jugador jugador;
    private int figMostradas;
    private int numIntentos;
    private int numFallos;
    private int numAciertos;
    private double porFallos;
    private double porAciertos;
    
    
    public VentanaJuego (Jugador jugador){
        jFiguras = new JuegoFiguras();
        this.jugador = jugador;
        figMostradas = 3;
        numIntentos = 1;
        porFallos = (numFallos / numIntentos)*100;
        iniciarComponentes();
        reproducirSonido("/sonidos/intro.wav");
    }
    
    private void iniciarComponentes() {
        //Configuración de la ventana
        setTitle("JUEGO FIGURAS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/FigurasIcon.png")));
        setSize(1366,768);
        setLocationRelativeTo(null); 
        setVisible(true);
        setResizable(true);
        
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
        
        ManejadorEventos manejadorEventos = new ManejadorEventos();
        
        // Mostrar figuras en sus respectivos espacios(3 Filas, 5 Columnas)
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; // Columna 1
        constraints.gridy = 0; // Fila 1
        constraints.insets = new Insets(0, 0, 0, 200);
        
        jlJugador = new JLabel(jugador.getNombre());
        jpContenido.add(jlJugador,constraints);
        
        constraints.insets = new Insets(0, 25, 0, 25);
        constraints.gridy = 1; // Fila 2
        
        figuraRef = jFiguras.getFiguraReferencia();
        Dimension tamañoFiguraRef = figuraRef.getPreferredSize();
        widthFiguraRef = tamañoFiguraRef.getWidth();
            // Mostrar figura de referencia en columna 1
        jpContenido.add(figuraRef,constraints);
        
            // Mostrar imágen separador
        constraints.gridx = 1; // Columna 2
        imgBarra = new ImageIcon(getClass().getResource("/imagenes/Barra.png"));
        iconBarra = new JLabel(imgBarra);
        jpContenido.add(iconBarra,constraints);
        
           // Mostrar Figuras para elegir en columnas 3, 4 y 5
        figuras = jFiguras.getFiguras();
        for (int i = 0; i < 3; i++) {
            constraints.gridx = i + 2;
            figura = figuras.get(i);
            figura.addMouseListener(manejadorEventos);
            jpContenido.add(figura, constraints);
        }
        
        // Mostrar Estadistica en primera fla del panel
        
        constraints.gridwidth = 3;
        constraints.gridy = 0; // Fila 1
        constraints.insets = new Insets(0, 10, 0, 10);
        ctdFiguras = new JLabel("FIG: 3");
        jpContenido.add(ctdFiguras,constraints);
        
        constraints.insets = new Insets(0, 90, 0, 10);
        ctdIntentos = new JLabel("TRY: 0");
        jpContenido.add(ctdIntentos,constraints);
        
        constraints.insets = new Insets(0, 167, 0, 0);  
        ctdFallos = new JLabel("FAIL: 0");
        jpContenido.add(ctdFallos,constraints);
        
        constraints.gridy = 2; // Fila 3
        constraints.insets = new Insets(0, 290, 0, 0);
        jbSalir = new JButton("SALIR");
        jpContenido.add(jbSalir,constraints);
        jbSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String mensaje = "Cantidad de figuras mostradas: "  + figMostradas + "\n" +
                        "Cantidad de fallos: " + porFallos + "%\n" +
                        "Cantidad de aciertos: " + porAciertos + "%";
                JOptionPane.showMessageDialog(null, mensaje, "Estadísticas", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
        
        add(jpContenido);
    }

    private class ManejadorEventos extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Figura que se le dio clic
            JLabel figuraClicada = (JLabel) e.getSource();
            
            Dimension tamañoFigclic = figuraClicada.getPreferredSize();
            double widthFigClic = tamañoFigclic.getWidth();
            
            // Comparar figRef y figClic
            if(widthFiguraRef == widthFigClic ) {
                numAciertos++;
                
                jpContenido.removeAll();
                jpContenido.revalidate();
                jpContenido.repaint();
                
                
                actFiguras();
                
                jpContenido.revalidate();
                jpContenido.repaint();
                reproducirSonido("/sonidos/correct.wav");

                
            } else {
                numFallos++;
                reproducirSonido("/sonidos/wrong.wav");
            }
            numIntentos++;
            
        }   
        
        @Override
        public void mousePressed(MouseEvent e) {
            JLabel figura = (JLabel) e.getSource();
            figura.setSize(figura.getWidth() - 10, figura.getHeight() - 10); // Aumentar tamaño al presionar
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            JLabel figura = (JLabel) e.getSource();
            figura.setSize(figura.getWidth() + 10, figura.getHeight() + 10); // Volver al tamaño normal al soltar
        }
    }
    
    private void reproducirSonido(String archivoSonido) {
        try {
                InputStream inputStream = getClass().getResourceAsStream(archivoSonido);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
                Clip clip = AudioSystem.getClip();

                clip.open(audioInputStream);

                clip.addLineListener(new LineListener() {
                    @Override
                    public void update(LineEvent event) {
                        if (event.getType() == LineEvent.Type.STOP) {
                            clip.close();
                        }
                    }
                });

                clip.start();
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
    }
    
    private void actFiguras(){
        figMostradas = figMostradas + 3;
        jFiguras = new JuegoFiguras();
        ManejadorEventos manejadorEventos = new ManejadorEventos();
        
        // Mostrar figuras en sus respectivos espacios(3 Filas, 5 Columnas)
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; // Columna 1
        constraints.gridy = 0; // Fila 1
        constraints.insets = new Insets(0, 0, 0, 200);
        
        jlJugador = new JLabel(jugador.getNombre());
        jpContenido.add(jlJugador,constraints);
        
        constraints.insets = new Insets(0, 25, 0, 25);
        constraints.gridy = 1; // Fila 2
        
        figuraRef = jFiguras.getFiguraReferencia();
        Dimension tamañoFiguraRef = figuraRef.getPreferredSize();
        widthFiguraRef = tamañoFiguraRef.getWidth();
            // Mostrar figura de referencia en columna 1
        jpContenido.add(figuraRef,constraints);
        
            // Mostrar imágen separador
        constraints.gridx = 1; // Columna 2
        imgBarra = new ImageIcon(getClass().getResource("/imagenes/Barra.png"));
        iconBarra = new JLabel(imgBarra);
        jpContenido.add(iconBarra,constraints);
        
           // Mostrar Figuras para elegir en columnas 3, 4 y 5
        figuras = jFiguras.getFiguras();
        for (int i = 0; i < 3; i++) {
            constraints.gridx = i + 2;
            figura = figuras.get(i);
            figura.addMouseListener(manejadorEventos);
            jpContenido.add(figura, constraints);
        }
        
        // Mostrar Estadistica en primera fla del panel
        constraints.gridx = 4;
        constraints.gridy = 0; // Fila 1
        constraints.gridwidth = 3;
        constraints.insets = new Insets(0, 0, 0, 0);
        String txtFiguras = Integer.toString(figMostradas);
        ctdFiguras = new JLabel("FIG: " + txtFiguras);
        jpContenido.add(ctdFiguras,constraints);
        
        constraints.insets = new Insets(0, 120, 0, 0);
        ctdIntentos = new JLabel("TRY: " + numIntentos);
        jpContenido.add(ctdIntentos,constraints);
        
        constraints.insets = new Insets(0, 250, 0, 20);  
        ctdFallos = new JLabel("FAIL: " + numFallos);
        jpContenido.add(ctdFallos,constraints);
        
        constraints.gridy = 2; // Fila 3
        constraints.insets = new Insets(0, 290, 0, 0);
        jbSalir = new JButton("SALIR");
        jpContenido.add(jbSalir,constraints);
        
        
        jbSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                porFallos = ((double) numFallos / numIntentos) * 100;
                porAciertos = 100 - porFallos;
                
                String mensaje = String.format("Cantidad de figuras mostradas: %d%n" +
                    "Cantidad de fallos: %.2f%%%n" +
                    "Cantidad de aciertos: %.2f%%", figMostradas, porFallos, porAciertos);

            JOptionPane.showMessageDialog(null, mensaje, "Estadísticas", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
        });
    }
}