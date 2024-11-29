class Espadachin extends Soldado {
    private double longitudEspada;

    public Espadachin(String nombre, int nivelVida, int posicionFila, int posicionColumna, int nivelAtaque, int nivelDefensa, double longitudEspada) {
        super(nombre, nivelVida, posicionFila, posicionColumna, nivelAtaque, nivelDefensa);
        this.longitudEspada = longitudEspada;
    }

    public void crearMuroEscudos() {
        System.out.println("Creando muro de escudos...");
    }
}