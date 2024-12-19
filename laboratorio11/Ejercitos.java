
package com.mycompany.laboratorio11;

import java.util.ArrayList;
import java.util.Random;

public class Ejercitos {
 private String reino;
 private int numeroEjercitos;
 public int cantidadSoldado;
 private ArrayList<Soldado> ejercito1=new ArrayList<>();

    public Ejercitos(int numeroEjercitos) { 
        String reino1=seleccionarReino();
        String reino2;
        do{
         reino2=seleccionarReino();  
        } while (reino2.equals(reino1));
        
        switch (numeroEjercitos){
            case 1:
            inicializarEjercito1();
            this.reino=reino1;
            break;
            case 2:
            inicializarEjercito2();
            this.reino=reino2;
            break;
        }  
    }
 
   private String seleccionarReino(){
   int tipo = (int) (Math.random() * 4 + 1);
   String reino="";
        switch (tipo) {
            case 1:
            reino="Inglaterra";
              break;
            case 2:
            reino="Francia";  
              break;
            case 3:
             reino="Castilla-Aragon";  
              break;
            case 4:
             reino="Imperio Romano"; 
              break;
     }
    return reino;    
   }  
 private void inicializarEjercito1() {
        Random random = new Random();

        int numSoldados = random.nextInt(10) + 1;  

        for (int i = 0; i < numSoldados; i++) {
            int tipo1 = (int) (Math.random() * 4 + 1);
            
            Soldado soldado1 = new Soldado();  
            
             switch (tipo1) {
            case 1:
            soldado1 = new Espadachin("EspadachinX" + i,'X');  
              break;
            case 2:
            soldado1 = new Arquero("ArqueroX" + i,'X');  
              break;
            case 3:
            soldado1 = new Caballero("CaballeroX" + i,'X');  
              break;
             case 4:
            soldado1 = new Lancero("LanceroX" + i,'X');  
              break; 
          }
          ejercito1.add(soldado1);
          cantidadSoldado++;
    }
    }    
        
        private void inicializarEjercito2(){
        Random random = new Random();

        int numSoldados = random.nextInt(10) + 1;  

        for (int i = 0; i < numSoldados; i++) {
            int tipo2 = (int) (Math.random() * 4 + 1);
            
            Soldado soldado1 = new Soldado();  
            
             switch (tipo2) {
            case 1:
            soldado1 = new Espadachin("EspadachinY" + i,'Y');  
              break;
            case 2:
            soldado1 = new Arquero("ArqueroY" + i,'Y');  
              break;
            case 3:
            soldado1 = new Caballero("CaballeroY" + i,'Y');  
              break;
             case 4:
            soldado1 = new Lancero("LanceroY" + i,'Y');  
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

    public void setNumeroEjercitos(int numeroEjercitos) {
        this.numeroEjercitos = numeroEjercitos;
    }    
 
}
