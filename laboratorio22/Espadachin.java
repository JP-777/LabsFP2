
package com.mycompany.laboratorio22;
import java.util.*;
public class Espadachin extends Soldado {
private int longitudEspada;
private String especialidad;
private int cuchillos=0;

    public Espadachin(int longitudEspada, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida) {
        super(nombre, nivelAtaque, nivelDefensa, nivelVida);
        this.longitudEspada = longitudEspada;
    }

    public Espadachin() {
    }

    public Espadachin(String nombre, char letra) {
        super(nombre, letra);
        this.nivelAtaque=10;
        this.nivelDefensa=8;
        this.nivelVida = generarAleatorio(8, 10);
        this.longitudEspada = generarAleatorio(0,5);
        this.tipoPieza='E';
    }
    
    public Espadachin(String nombre, char letra, String especialidad) {
        super(nombre, letra);
        this.nivelAtaque=10;
        this.nivelDefensa=8;
        this.nivelVida = generarAleatorio(8, 10);
        this.longitudEspada = generarAleatorio(0,5);
        this.tipoPieza='E';
        this.especialidad=especialidad;
    }


 public void crearMuroEscudos() {
        System.out.println("Creando muro de escudos...");
    }
}
