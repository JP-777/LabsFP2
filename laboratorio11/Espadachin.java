
package com.mycompany.laboratorio11;
import java.util.*;
public class Espadachin extends Soldado {
private int longitudEspada;

    public Espadachin(int longitudEspada, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida) {
        super(nombre, nivelAtaque, nivelDefensa, nivelVida);
        this.longitudEspada = longitudEspada;
    }

    public Espadachin() {
    }

    public Espadachin(String nombre, char letra) {
        super(nombre, letra);
        this.nivelVida = generarAleatorio(3, 4);
        this.longitudEspada = generarAleatorio(0,5);
        this.tipoPieza='E';
    }


 public void crearMuroEscudos() {
        System.out.println("Creando muro de escudos...");
    }
}
