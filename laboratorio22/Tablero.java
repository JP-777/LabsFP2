
package com.mycompany.laboratorio22;
import java.util.*;
public class Tablero {
    private Soldado[][] tablero;
    private Ejercitos ejercito1=new Ejercitos(1);
    private Ejercitos ejercito2=new Ejercitos(2);
    private ArrayList<Soldado> ejercitoX;
    private ArrayList<Soldado> ejercitoY;
    private final int n = 10;
    private String tipoTerritorio;

    public Tablero() {
        int tipo = (int) (Math.random() * 5 + 1);
        switch (tipo) {
            case 1:
            this.tipoTerritorio="Bosque";
              break;
            case 2:
            this.tipoTerritorio="Campo";  
              break;
            case 3:
            this.tipoTerritorio="Montania";  
              break;
            case 4:
            this.tipoTerritorio="Desierto"; 
              break;
            case 5:
            this.tipoTerritorio="Playa";  
              break;  
          }
        this.tablero = new Soldado[n][n];
        this.ejercitoX = ejercito1.getEjercito1();
        this.ejercitoY= ejercito2.getEjercito1();
        bonificacionVidaTerritorio(ejercito1,tipoTerritorio);
        bonificacionVidaTerritorio(ejercito2,tipoTerritorio);
        posicionarEjercitos(ejercitoX);
        posicionarEjercitos(ejercitoY);
    }

    private void bonificacionVidaTerritorio(Ejercitos ejercito,String territorio){
    if(ejercito.getReino().equals("Inglaterra")&&territorio.equals("Bosque")){   
    for(Soldado objeto:ejercito.getEjercito1()){
    objeto.nivelVida++;
    } } else if(ejercito.getReino().equals("Francia")&&territorio.equals("Campo")){
     for(Soldado objeto:ejercito.getEjercito1()){
    objeto.nivelVida++;              
    } }
     else if(ejercito.getReino().equals("Castilla-Aragon")&&territorio.equals("Montania")){ 
     for(Soldado objeto:ejercito.getEjercito1()){
    objeto.nivelVida++;    
     } }
     else if(ejercito.getReino().equals("Imperio Romano")&&(territorio.equals("Bosque")||territorio.equals("Playa")||territorio.equals("Campo"))){
     for(Soldado objeto:ejercito.getEjercito1()){
    objeto.nivelVida++;                 
     }  }  
    }
    
    
    private void posicionarEjercitos(ArrayList<Soldado> ejercito) {
        Random random = new Random();

        for(Soldado objeto:ejercito){
     
            int fila1, col1;
            do {
                fila1 = random.nextInt(n);
                col1 = random.nextInt(n);
            } while (tablero[fila1][col1] != null);


            objeto.setPosicion(fila1, col1);

            tablero[fila1][col1] = objeto;
        }
       }
    

    public void mostrarTablero() {
    System.out.println("                         TERRITORIO:  "+tipoTerritorio);
        
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
                if (ejercitoX.contains(soldado)) {
                    System.out.printf("|X%02d%c ", soldado.getVidaActual(), soldado.tipoPieza); 
                } else if (ejercitoY.contains(soldado)) {
                    System.out.printf("|Y%02d%c ", soldado.getVidaActual(), soldado.tipoPieza);
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

            if (ejercitoX.contains(soldado)) {
                ejercitoY.remove(soldado);
                ejercito1.cantidadSoldado-=1; 
            } else if (ejercitoX.contains(soldado)) {
                ejercitoY.remove(soldado);
                ejercito2.cantidadSoldado-=1;
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

    public ArrayList<Soldado> getEjercitoX() {
        return ejercitoX;
    }

    public ArrayList<Soldado> getEjercitoY() {
        return ejercitoY;
    }

    public Soldado[][] getTablero() {
        return tablero;
    }

    public void setTablero(Soldado[][] tablero) {
        this.tablero = tablero;
    }

    public void setEjercitoX(ArrayList<Soldado> ejercito1) {
        this.ejercitoX = ejercito1;
    }

    public void setEjercitoY(ArrayList<Soldado> ejercito2) {
        this.ejercitoY = ejercito2;
    }

    public Ejercitos getEjercito1() {
        return ejercito1;
    }

    public Ejercitos getEjercito2() {
        return ejercito2;
    }
    
}

