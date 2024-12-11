
package com.mycompany.laboratorio11;

import java.util.ArrayList;
import java.util.Random;

public class Ejercitos {
 private String reino;
 public int cantidadSoldado;
 private ArrayList<Soldado> ejercito1=new ArrayList<>();

    public Ejercitos() {
    int tipo = (int) (Math.random() * 5 + 1);
        switch (tipo) {
            case 1:
            this.reino="Inglaterra";
              break;
            case 2:
            this.reino="Francia";  
              break;
            case 3:
            this.reino="Castilla-Aragon";  
              break;
            case 4:
            this.reino="Imperio Romano"; 
              break;
     }    
    inicializarEjercito();    
    }
 
 private void inicializarEjercito() {
        Random random = new Random();

        int numSoldados = random.nextInt(10) + 1;  

        for (int i = 0; i < numSoldados; i++) {
            int tipo1 = (int) (Math.random() * 3 + 1);
            
            Soldado soldado1 = new Soldado();  
            
             switch (tipo1) {
            case 1:
            soldado1 = new Espadachin("EspadachinX" + i,'A');  
              break;
            case 2:
            soldado1 = new Arquero("ArqueroX" + i,'A');  
              break;
            case 3:
            soldado1 = new Caballero("CaballeroX" + i,'A');  
              break;
          }
          ejercito1.add(soldado1);
          cantidadSoldado++;
    }
   }

    public ArrayList<Soldado> getEjercito1() {
        return ejercito1;
    }

    public String getReino() {
        return reino;
    }
    
    
 
}
