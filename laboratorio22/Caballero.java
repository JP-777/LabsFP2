
package com.mycompany.laboratorio22;
import java.util.*;
public class Caballero extends Soldado{
    private boolean estaMontado;
    private String armaActual;
    private int dañoAtaqueEnvestida;
    private String especialdad;

    public Caballero(boolean estaMontado, String armaActual, int dañoAtaqueEnvestida, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida) {
        super(nombre, nivelAtaque, nivelDefensa, nivelVida);
        this.estaMontado = estaMontado;
        this.armaActual = armaActual;
        this.dañoAtaqueEnvestida = dañoAtaqueEnvestida;
    }

    public Caballero() {
    }

    public Caballero(String nombre, char letra) {
        super(nombre, letra);
        switch(generarAleatorio(1,2)){
            case 1:
        this.estaMontado = true;
          break;
            case 2:
         this.estaMontado=false;
          break;       
        }       
        switch(generarAleatorio(1,2)){
            case 1:
        this.armaActual = "Espada";
          break;
            case 2:
         this.armaActual = "Lanza";
          break;       
        }  
        this.nivelAtaque=13;
        this.nivelDefensa=7;
        this.nivelVida = generarAleatorio(10,12);
        this.dañoAtaqueEnvestida = generarAleatorio(1,5);
        this.tipoPieza='C';

    }
    
     public Caballero(String nombre, char letra, String especialidad) {
        super(nombre, letra);
        switch(generarAleatorio(1,2)){
            case 1:
        this.estaMontado = true;
          break;
            case 2:
         this.estaMontado=false;
          break;       
        }       
        switch(generarAleatorio(1,2)){
            case 1:
        this.armaActual = "Espada";
          break;
            case 2:
         this.armaActual = "Lanza";
          break;       
        }  
        this.nivelAtaque=13;
        this.nivelDefensa=7;
        this.nivelVida = generarAleatorio(10,12);
        this.dañoAtaqueEnvestida = generarAleatorio(1,5);
        this.tipoPieza='C';
        this.especialdad=especialidad;
    }
    
     public void desmontar() {
        this.armaActual = "Espada";
        this.dañoAtaqueEnvestida = 10; // Ejemplo.
    }

    public void montar() {
        this.armaActual = "Lanza";
        this.dañoAtaqueEnvestida = 30; // Ejemplo.
    }
}
