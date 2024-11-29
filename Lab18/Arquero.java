class Arquero extends Soldado {
    private int numeroFlechas;

    public Arquero(String nombre, int nivelVida, int posicionFila, int posicionColumna, int nivelAtaque, int nivelDefensa, int numeroFlechas) {
        super(nombre, nivelVida, posicionFila, posicionColumna, nivelAtaque, nivelDefensa);
        this.numeroFlechas = numeroFlechas;
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