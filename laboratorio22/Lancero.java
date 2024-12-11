
package com.mycompany.laboratorio22;

public class Lancero extends Soldado{
 private int longitudLanza;

    public Lancero(int longitudLanza, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida) {
        super(nombre, nivelAtaque, nivelDefensa, nivelVida);
        this.longitudLanza = longitudLanza;
    }

    public Lancero() {
    }

    public Lancero(String nombre, char letra) {
        super(nombre, letra);
        this.nivelAtaque=5;
        this.nivelDefensa=10;
        this.longitudLanza = generarAleatorio(5,8);
        this.tipoPieza='L';
    }
 
 
 public void schiltrom(){
  System.out.println("Se ha aumentado la defensa en 1");
  this.nivelDefensa++;   
 }
}
