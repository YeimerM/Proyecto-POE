/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import modelo.Figura;
import modelo.FiguraCirculo;
import modelo.FiguraCuadrado;
import modelo.FiguraRectangulo;
import modelo.FiguraTriangulo;

/**
 *
 * @author mende
 */
public class JuegoFiguras {
    private List<List<Figura>> figurasAnidadas;
    private Random random;
    private int numClase;
    private List<Figura> claseElegida;
    
    
    public JuegoFiguras(){
        figurasAnidadas = new ArrayList<>();
        
        // Lista con las Figuras
        figurasAnidadas.add(new ArrayList<>()); // FiguraCuadrado   = 0
        figurasAnidadas.add(new ArrayList<>()); // FiguraRectangulo = 1
        figurasAnidadas.add(new ArrayList<>()); // FiguraTriangulo  = 2
        figurasAnidadas.add(new ArrayList<>()); // FiguraCirculo    = 3
        
        // Lista con los objetos para cada Figura
            // Se agregan Cuadrados
        FiguraCuadrado cuadradoL = new FiguraCuadrado("/imagenes/figuras/Cuadrado.png","Large",250,250);
        FiguraCuadrado cuadradoM = new FiguraCuadrado("/imagenes/figuras/Cuadrado.png", "Medium", 220,220);
        FiguraCuadrado cuadradoS = new FiguraCuadrado("/imagenes/figuras/Cuadrado.png", "Small", 200,200);
        figurasAnidadas.get(0).add(cuadradoS);
        figurasAnidadas.get(0).add(cuadradoM);
        figurasAnidadas.get(0).add(cuadradoL);
        
            // Se agregan Rectangulos
        FiguraRectangulo rectanguloL = new FiguraRectangulo("/imagenes/figuras/Rectangulo.png", "Large", 250,180);
        FiguraRectangulo rectanguloM = new FiguraRectangulo("/imagenes/figuras/Rectangulo.png", "Medium", 220,165);
        FiguraRectangulo rectanguloS = new FiguraRectangulo("/imagenes/figuras/Rectangulo.png", "Small", 205,150);
        figurasAnidadas.get(1).add(rectanguloL);
        figurasAnidadas.get(1).add(rectanguloM);
        figurasAnidadas.get(1).add(rectanguloS);
        
            // Se agregan Triangulos
        FiguraTriangulo TrianguloL = new FiguraTriangulo("/imagenes/figuras/Triangulo.png", "Large", 260,250);
        FiguraTriangulo TrianguloM = new FiguraTriangulo("/imagenes/figuras/Triangulo.png", "Medium", 230,220);
        FiguraTriangulo TrianguloS = new FiguraTriangulo("/imagenes/figuras/Triangulo.png", "Small", 215,205);
        figurasAnidadas.get(2).add(TrianguloL);
        figurasAnidadas.get(2).add(TrianguloM);
        figurasAnidadas.get(2).add(TrianguloS);
            // Se agregan Circulos
        FiguraCirculo CirculoL = new FiguraCirculo("/imagenes/figuras/Circulo.png", "Large", 250,250);
        FiguraCirculo CirculoM = new FiguraCirculo("/imagenes/figuras/Circulo.png", "Medium", 235,235);
        FiguraCirculo CirculoS = new FiguraCirculo("/imagenes/figuras/Circulo.png", "Small", 220,220);
        figurasAnidadas.get(3).add(CirculoL);
        figurasAnidadas.get(3).add(CirculoM);
        figurasAnidadas.get(3).add(CirculoS);
        
        // Elije que tipo de figura mostrar
        random = new Random();
        numClase = random.nextInt(4);
        claseElegida = figurasAnidadas.get(numClase);
    }
    
    public  JLabel obtenerFiguraReferencia(){

        // Elejir la figura de referencia
        int numFigRef = random.nextInt(claseElegida.size());
        Figura figRef;
        figRef = claseElegida.get(numFigRef);
        String figRefRuta = figRef.getRutaImg();
        String figRefName = figRef.getName();
        
        JLabel lbFigRef;
        
        // Se crea la figura de referencia
        switch (numClase) {
            case 0 ->                 {
                    // Cuadrado
                    FiguraCuadrado figuraReferencia = new FiguraCuadrado(figRefRuta,figRefName,figRef.getAncho(),figRef.getAlto());
                    lbFigRef = figuraReferencia.getFigura();
                }
            case 1 ->                 {
                    // Rectangulo
                    FiguraRectangulo figuraReferencia = new FiguraRectangulo(figRefRuta,figRefName,figRef.getAncho(),figRef.getAlto());
                    lbFigRef = figuraReferencia.getFigura();
                }
            case 2 ->                 {
                    // Triangulo
                    FiguraTriangulo figuraReferencia = new FiguraTriangulo(figRefRuta,figRefName,figRef.getAncho(),figRef.getAlto());
                    lbFigRef = figuraReferencia.getFigura();
                }
            case 3 ->                 {
                    // Circulo
                    FiguraCirculo figuraReferencia = new FiguraCirculo(figRefRuta,figRefName,figRef.getAncho(),figRef.getAlto());
                    lbFigRef = figuraReferencia.getFigura();
                }
            default -> throw new IllegalArgumentException("Tipo de figura no válido");
        }
        
        return lbFigRef;
    }
    
    public List<JLabel> figurasMostrar(){
        List<JLabel> mostrarFiguras = new ArrayList<>();
        List<Integer> indxElegidos = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            int numObjeto;
            do {
                numObjeto = random.nextInt(claseElegida.size());
            } while (indxElegidos.contains(numObjeto)); // Asegura que no se repita

            Figura figuraElegida;
            figuraElegida = claseElegida.get(numObjeto);
            mostrarFiguras.add(figuraElegida.getFigura());
            
            indxElegidos.add(numObjeto);
            
            System.out.println("Clase: " + claseElegida.get(0).getClass().getSimpleName() +
                    ", Objeto " + (i + 1) + ": " + figuraElegida.getName());
            
        }
        
        return mostrarFiguras;
    }
}