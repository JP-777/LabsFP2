class Soldado {
    private String nombre;
    private int posicionFila;
    private int posicionColumna;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad = 0;
    private String actitud = "Deffensive";
    private boolean vive = true;

    public Soldado(String nombre, int nivelVida, int posicionFila, int posicionColumna, int nivelAtaque, int nivelDefensa) {
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.vidaActual = nivelVida;  // Inicializamos vida actual con el valor de nivelVida
    }

    public void atacar() {
        avanzar();
        this.actitud = "Offensive";
    }

    public void defender() {
        this.actitud = "Deffensive";
        this.velocidad = 0;
    }

    public void avanzar() {
        this.velocidad += 1;
    }

    public void retroceder() {
        this.actitud = "Deffensive";
        if (velocidad > 0) {
            this.velocidad = 0;
        } else {
            this.velocidad--;
        }
    }

    public void serAtacado() {
        this.nivelVida--;
    }

    public void huir() {
        this.actitud = "Escape";
        this.velocidad += 2;
    }

    public void morir() {
        this.actitud = "Dead";
        this.posicionColumna = -1;
        this.posicionFila = -1;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }
    
    public int getVelocidad(){
        return this.velocidad;
    }

    public int getVidaActual() {
        return this.vidaActual;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPosicionFila() {
        return this.posicionFila;
    }

    public int getPosicionColumna() {
        return this.posicionColumna;
    }

    public void setPosicionFila(int nuevaPosicion) {
        this.posicionFila = nuevaPosicion;
    }

    public void setPosicionColumna(int nuevaPosicion) {
        this.posicionColumna = nuevaPosicion;
    }

    public String getActitud(){
        return this.actitud;
    }
}
