package modelo;


import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mende
 */
public abstract class Figura {
    protected final String rutaImagen;
    String name;
    int ancho;
    int alto;
    protected JLabel lbFigura;
    protected ImageIcon imgFigura;
    
    public Figura(String rutaImagen, String name, int ancho, int alto) {
        this.rutaImagen = rutaImagen;
        this.ancho = ancho;
        this.alto = alto;
        this.name = name;
        
        // Establecer la imágen de la figura
        imgFigura = new ImageIcon(getClass().getResource(rutaImagen));
        Image imgR = imgFigura.getImage();
        imgR = imgR.getScaledInstance(ancho,alto,Image.SCALE_SMOOTH);
        imgFigura = new ImageIcon(imgR);
        lbFigura = new JLabel(imgFigura);
        lbFigura.setPreferredSize(new Dimension(ancho, alto));
    }
    
    public JLabel getFigura(){
        return lbFigura;
    }
    
    public String getRutaImg() {
        return rutaImagen;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAncho() {
        return ancho;
    }
    
    public int getAlto() {
        return alto;
    }
    public abstract void aumentarTamaño();
    public abstract void restaurarTamaño();
    
}