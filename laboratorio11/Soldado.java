
package com.mycompany.laboratorio11;
import java.util.*;
public class Soldado {
    protected char tipoPieza;
    private String nombre;
    protected int nivelAtaque;
    protected int nivelDefensa;
    protected int nivelVida;
    private int vidaActual;
    private int velocidad;
    private String actitud;  
    private int fila;
    private int columna;
    private boolean vive;
    public static int cantidadTotalSoldados = 0;

    public Soldado(String nombre, int nivelAtaque, int nivelDefensa, int nivelVida) {
        this.nombre = nombre;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nivelVida = nivelVida;
    }
    
    
    public Soldado() {
    }
    
    public Soldado(String nombre,char letra) {
        this.nombre = nombre;
        this.nivelAtaque = generarAleatorio(1, 5);
        this.nivelDefensa = generarAleatorio(1, 5);
        this.nivelVida = generarAleatorio(1, 5);
        this.vidaActual = this.nivelVida;
        this.velocidad = 1;
        this.actitud = "Defensiva";
        this.vive = true;
        this.fila = -1;  
        this.columna = -1; 
        cantidadTotalSoldados++;       
    }

    protected int generarAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void atacar(Soldado enemigo) {
        this.avanzar();
        this.actitud = "Ofensiva";
        System.out.println(nombre + " está atacando a " + enemigo.getNombre());
    }

    public void defender() {
        this.actitud = "Defensiva";
        System.out.println(nombre + " está defendiendo.");
    }

    public void avanzar() {
        this.velocidad++;
        System.out.println(nombre + " ha avanzado y su velocidad es ahora " + velocidad);
    }

    public void retroceder() {
        if (velocidad > 0) {
            this.defender();
            this.velocidad = 0;
            System.out.println(nombre + " ha retrocedido y ahora su velocidad es 0.");
        } else {
            this.velocidad--;
            System.out.println(nombre + " ha retrocedido a velocidad negativa: " + velocidad);
        }
    }

    public void huir() {
        this.velocidad += 2;
        this.actitud = "Fuga";
        System.out.println(nombre + " está huyendo. Velocidad aumentada a " + velocidad);
    }

    public void serAtacado(int daño) {
        this.vidaActual -= daño;
        if (this.vidaActual <= 0) {
            this.morir();
        } else {
            System.out.println(nombre + " ha sido atacado y su vida actual es " + vidaActual);
        }
    }

    private void morir() {
        this.vive = false;
        System.out.println(nombre + " ha muerto.");
    }

    public boolean puedeAtacar(Soldado enemigo) {
        return this.vive && enemigo.isVive();  
    }

    public boolean mismoEjercito(Soldado otro) {
        return this.nombre.charAt(0) == otro.getNombre().charAt(0);  
    }

    public double calcularProbabilidadVencer(Soldado enemigo) {
        int totalVida = this.vidaActual + enemigo.getVidaActual();
        return (double) this.vidaActual / totalVida;  
    }
    
    public void incrementarVida() {
        this.vidaActual++;  
        System.out.println(nombre + " ha incrementado su vida en 1"+". Vida actual: " + vidaActual);
    }  
    
    public Soldado clonar() {
    // Suponemos que el primer carácter del nombre indica el equipo
    char equipo = this.nombre.charAt(0); 

    Soldado clon = new Soldado(this.nombre, equipo);
    clon.nivelAtaque = this.nivelAtaque;
    clon.nivelDefensa = this.nivelDefensa;
    clon.nivelVida = this.nivelVida;
    clon.vidaActual = this.vidaActual;
    clon.velocidad = this.velocidad;
    clon.actitud = this.actitud;
    clon.vive = this.vive;
    clon.fila = this.fila;
    clon.columna = this.columna;

    return clon;
}
    
    public Soldado sumar(Soldado otro) {
    return new Soldado(
        this.nombre + "+" + otro.nombre,
        this.nivelAtaque + otro.nivelAtaque,
        this.nivelDefensa + otro.nivelDefensa,
        this.nivelVida + otro.nivelVida
    );
    } 
    
    public String getNombre() {
        return nombre;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String getActitud() {
        return actitud;
    }

    public boolean isVive() {
        return vive;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setPosicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public static int getCantidadTotalSoldados() {
        return cantidadTotalSoldados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setActitud(String actitud) {
        this.actitud = actitud;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public static void setCantidadTotalSoldados(int cantidadTotalSoldados) {
        Soldado.cantidadTotalSoldados = cantidadTotalSoldados;
    }

    @Override
    public String toString() {
        return "Soldado{" + "nombre=" + nombre + ", nivelAtaque=" + nivelAtaque + ", nivelDefensa=" + nivelDefensa + ", nivelVida=" + nivelVida + ", vidaActual=" + vidaActual + ", velocidad=" + velocidad + ", actitud=" + actitud + ", fila=" + fila + ", columna=" + columna + '}';
    }

    public String mostrarSumaNiveles(){
       return "La suma de atributos del ejercito es: \n Nivel de ataque total: "+ nivelAtaque+"\n"+
                          "Nivel de defensa total: "+ nivelDefensa+"\n"+
                          "Nivel de vida total: "+ nivelVida;
    }
        
    
}
   

