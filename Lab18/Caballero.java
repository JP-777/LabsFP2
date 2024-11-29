class Caballero extends Soldado {
    private boolean estaMontado;
    private String armaActual;
    private int dañoAtaqueEnvestida;

    public Caballero(String nombre, int nivelVida, int posicionFila, int posicionColumna, int nivelAtaque, int nivelDefensa, boolean estaMontado) {
        super(nombre, nivelVida, posicionFila, posicionColumna, nivelAtaque, nivelDefensa);
        this.estaMontado = estaMontado;
        montar(); // Configura estado inicial.
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