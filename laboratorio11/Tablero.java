
package com.mycompany.laboratorio11;
import java.util.*;
public class Tablero {
    private Soldado[][] tablero;
    private ArrayList<Soldado> ejercito1;
    private ArrayList<Soldado> ejercito2;
    private final int n = 10;  

    public Tablero() {
        this.tablero = new Soldado[n][n];
        this.ejercito1 = new ArrayList<>();
        this.ejercito2 = new ArrayList<>();
        inicializarEjercitos();
    }


    private void inicializarEjercitos() {
        Random random = new Random();

        int numSoldados = random.nextInt(10) + 1;  

        for (int i = 0; i < numSoldados; i++) {
            Soldado soldado1 = new Soldado("A" + i,'A');  
            Soldado soldado2 = new Soldado("B" + i,'B');  

            int fila1, col1, fila2, col2;
            do {
                fila1 = random.nextInt(n);
                col1 = random.nextInt(n);
            } while (tablero[fila1][col1] != null);

            do {
                fila2 = random.nextInt(n);
                col2 = random.nextInt(n);
            } while (tablero[fila2][col2] != null);

            soldado1.setPosicion(fila1, col1);
            soldado2.setPosicion(fila2, col2);

            tablero[fila1][col1] = soldado1;
            tablero[fila2][col2] = soldado2;

            ejercito1.add(soldado1);
            ejercito2.add(soldado2);
        }
    }


    public void mostrarTablero() {
    System.out.print("    "); 
    for (int j = 0; j < n; j++) {
        System.out.printf("   "+j+"  "); 
    }
    System.out.println();  
    System.out.print("    "); 
    System.out.println("+" + "-----+".repeat(n)); 

    
    for (int i = 0; i < n; i++) {
        System.out.print(" "+i+"  "); 
        for (int j = 0; j < n; j++) {
            if (tablero[i][j] != null) {
                Soldado soldado = tablero[i][j];
                if (ejercito1.contains(soldado)) {
                    System.out.printf("| A%02d ", soldado.getVidaActual());  
                } else if (ejercito2.contains(soldado)) {
                    System.out.printf("| B%02d ", soldado.getVidaActual());  
                }
            } else {
                System.out.print("|     ");  
            }
        }
        System.out.println("|");  
        System.out.print("    "); 
        System.out.println("+" + "-----+".repeat(n));  
    }
   }
    
    public Soldado getSoldado(int fila, int columna) {
        if (fila >= 0 && fila < n && columna >= 0 && columna < n) {
            return tablero[fila][columna];
        }
        return null; 
    }
    
    public void moverSoldado(int filaActual, int columnaActual, int nuevaFila, int nuevaColumna) {
        if (nuevaFila >= 0 && nuevaFila < n && nuevaColumna >= 0 && nuevaColumna < n) {
            Soldado soldado = tablero[filaActual][columnaActual];
            tablero[filaActual][columnaActual] = null; 
            tablero[nuevaFila][nuevaColumna] = soldado;  
            soldado.setPosicion(nuevaFila, nuevaColumna); 
        }
    }

    public void eliminarSoldado(int fila, int columna) {
        Soldado soldado = tablero[fila][columna];
        if (soldado != null) {
            tablero[fila][columna] = null; 

            if (ejercito1.contains(soldado)) {
                ejercito1.remove(soldado);
                Soldado.cantidadEjercito1-=1; 
            } else if (ejercito2.contains(soldado)) {
                ejercito2.remove(soldado);
                Soldado.cantidadEjercito2-=1; 
            }
        }
    }
    public void tomarLugar(Soldado soldado, int nuevaFila, int nuevaColumna) {
    if (nuevaFila >= 0 && nuevaFila < n && nuevaColumna >= 0 && nuevaColumna < n) {
        int filaActual = soldado.getFila();
        int columnaActual = soldado.getColumna();
        tablero[filaActual][columnaActual] = null;
        tablero[nuevaFila][nuevaColumna] = soldado;
        soldado.setPosicion(nuevaFila, nuevaColumna);
    }
}

    public ArrayList<Soldado> getEjercito1() {
        return ejercito1;
    }

    public ArrayList<Soldado> getEjercito2() {
        return ejercito2;
    }

    public Soldado[][] getTablero() {
        return tablero;
    }

    public void setTablero(Soldado[][] tablero) {
        this.tablero = tablero;
    }

    public void setEjercito1(ArrayList<Soldado> ejercito1) {
        this.ejercito1 = ejercito1;
    }

    public void setEjercito2(ArrayList<Soldado> ejercito2) {
        this.ejercito2 = ejercito2;
    }
    
}

