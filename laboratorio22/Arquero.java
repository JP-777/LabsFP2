
package com.mycompany.laboratorio22;
import java.util.*;
public class Arquero extends Soldado {
 private int numeroFlechas;

    public Arquero(int numeroFlechas, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida) {
        super(nombre, nivelAtaque, nivelDefensa, nivelVida);
        this.numeroFlechas = numeroFlechas;
    }

    public Arquero() {
    }

    public Arquero(String nombre, char letra) {
        super(nombre, letra);
        this.nivelAtaque=7;
        this.nivelDefensa=3;
        this.nivelVida = generarAleatorio(3, 5);
        this.numeroFlechas = generarAleatorio(1,10);
        this.tipoPieza='A';

    }

 
 public void dispararFlecha() {
        if (numeroFlechas > 0) {
            numeroFlechas--;
            System.out.println("Flecha disparada. Flechas restantes: " + numeroFlechas);
        } else {
            System.out.println("No hay flechas disponibles.");
        }
    }
}
