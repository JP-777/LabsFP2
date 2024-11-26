
package com.mycompany.laboratorio11;
import java.util.*;
public class Videojuego {
    private Tablero tablero;
    private Scanner scanner;

    public Videojuego() {
        this.scanner = new Scanner(System.in);
    }

    public void moverSoldado(int fila, int columna, String direccion, ArrayList<Soldado> ejercito) {
        Soldado soldado = tablero.getSoldado(fila, columna);

        if (soldado == null || !ejercito.contains(soldado)) {
            System.out.println("No hay un soldado en esa posición o no es de tu ejército. Intenta de nuevo.");
            return;
        }

        int nuevaFila = fila;
        int nuevaColumna = columna;

        switch (direccion.toLowerCase()) {
            case "arriba":
                nuevaFila--;
                break;
            case "abajo":
                nuevaFila++;
                break;
            case "izquierda":
                nuevaColumna--;
                break;
            case "derecha":
                nuevaColumna++;
                break;
            default:
                System.out.println("Dirección inválida. Usa: arriba, abajo, izquierda, derecha.");
                return;
        }

        if (nuevaFila < 0 || nuevaFila >= 10 || nuevaColumna < 0 || nuevaColumna >= 10) {
            System.out.println("Movimiento fuera de los límites del tablero. Intenta de nuevo.");
            return;
        }

        Soldado soldadoEnDestino = tablero.getSoldado(nuevaFila, nuevaColumna);

        if (soldadoEnDestino != null) {
            if (ejercito.contains(soldadoEnDestino)) {
                System.out.println("No puedes mover a un lugar ocupado por otro soldado de tu ejército.");
            } else {
                manejarBatalla(soldado, soldadoEnDestino, nuevaFila, nuevaColumna);
            }
        } else {
            tablero.moverSoldado(fila, columna, nuevaFila, nuevaColumna);
            soldado.avanzar();
        }
    }

    private void manejarBatalla(Soldado soldado1, Soldado soldado2, int nuevaFila, int nuevaColumna) {
        System.out.println("¡Batalla entre " + soldado1.getNombre() + " y " + soldado2.getNombre() + "!");

        double vidaTotal = soldado1.getVidaActual() + soldado2.getVidaActual();
        double probabilidadSoldado1 = (soldado1.getVidaActual() / vidaTotal) * 100;
        double probabilidadSoldado2 = (soldado2.getVidaActual() / vidaTotal) * 100;

        Random random = new Random();
        double resultado = random.nextDouble() * 100;
        System.out.println("El resultado es: " + resultado);
        System.out.println("El atacante es: " + probabilidadSoldado1);
        System.out.println("El atacado es: " + probabilidadSoldado2);
        if (resultado < probabilidadSoldado1) {
            System.out.println(soldado1.getNombre() + " ha ganado la batalla.");
            tablero.eliminarSoldado(soldado2.getFila(), soldado2.getColumna());
            tablero.tomarLugar(soldado1, nuevaFila, nuevaColumna);
            soldado1.incrementarVida();
        } else {
            System.out.println(soldado2.getNombre() + " ha ganado la batalla.");
            tablero.tomarLugar(soldado2, nuevaFila, nuevaColumna);
            soldado2.incrementarVida();
            tablero.eliminarSoldado(soldado1.getFila(), soldado1.getColumna());
        }
    }

    private void juegoRapido() {
        boolean juegoTerminado = false;
        while (!juegoTerminado) {
            mostrarCantidadSoldadosPorEjercito();
            tablero.mostrarTablero();
            System.out.println("Turno del Jugador 1 (Ejército 1):");
            turnoJugador(tablero.getEjercito1());

            if (tablero.getEjercito2().isEmpty()) {
                System.out.println("¡El Jugador 1 ha ganado!");
                juegoTerminado = true;
                break;
            }

            mostrarCantidadSoldadosPorEjercito();
            tablero.mostrarTablero();
            System.out.println("Turno del Jugador 2 (Ejército 2):");
            turnoJugador(tablero.getEjercito2());

            if (tablero.getEjercito1().isEmpty()) {
                System.out.println("¡El Jugador 2 ha ganado!");
                juegoTerminado = true;
            }
        }
    }

    public void iniciarJuego() {
        this.tablero = new Tablero();
        menuPrincipal();
    }

    private void turnoJugador(ArrayList<Soldado> ejercito) {
        salir();
        System.out.println("Elige la posición del soldado a mover: ");
        System.out.print("Fila: ");
        int fila = scanner.nextInt();
        System.out.print("Columna: ");
        int columna = scanner.nextInt();

        System.out.println("Elige la dirección (arriba, abajo, izquierda, derecha):");
        String direccion = scanner.next();

        moverSoldado(fila, columna, direccion, ejercito);
    }

    private void mostrarCantidadSoldadosPorEjercito() {
        System.out.println("Cantidad de soldados por ejército:");
        System.out.println("Ejército 1: " + Soldado.getCantidadEjercito1());
        System.out.println("Ejército 2: " + Soldado.getCantidadEjercito2());
    }

    private void menuPrincipal() {
        int opcion;
        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Juego Rápido");
            System.out.println("2. Juego Personalizado");
            System.out.println("3. Terminar");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
        } while (opcion > 3 || opcion <= 0);

        switch (opcion) {
            case 1:
                juegoRapido();
                finalJuego();
                break;
            case 2:
                juegoPersonalizado();
                break;
            case 3:
                break;
        }
    }

    private void finalJuego() {
        int opcion;
        do {
            System.out.println("MENU FINAL");
            System.out.println("1. Volver a jugar");
            System.out.println("2. Volver al menú Principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
        } while (opcion > 2 || opcion <= 0);

        switch (opcion) {
            case 1:
                this.tablero = new Tablero();
                juegoRapido();
                finalJuego();
                break;
            case 2:
                this.tablero = new Tablero();
                menuPrincipal();
                break;
        }
    }

    private void juegoPersonalizado(){
        ArrayList<Soldado> ejercitoSeleccionado = seleccionarEjercito();
        int opcion;
        do {
            System.out.println("Juego Personalizado");
            System.out.println("1. Crear Soldado");
            System.out.println("2. Eliminar Soldado");
            System.out.println("3. Clonar Soldado");
            System.out.println("4. Modificar Soldado");
            System.out.println("5. Comparar Soldados");
            System.out.println("6. Intercambiar Soldados");
            System.out.println("7. Ver Soldado");
            System.out.println("8. Ver Ejército");
            System.out.println("9. Sumar Niveles");
            System.out.println("10. Jugar");
            System.out.println("11. Volver al menu principal(No se guardan los cambios)");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearSoldado(ejercitoSeleccionado);
                            
                    break;
                case 2:
                    eliminarSoldado(ejercitoSeleccionado);
                    break;
                case 3:
                    clonarSoldado(ejercitoSeleccionado);
                    break;
                case 4:
                    modificarSoldado(ejercitoSeleccionado);
                    break;
                case 5:
                    compararSoldados(ejercitoSeleccionado);
                    break;
                case 6:
                    intercambiarSoldados(ejercitoSeleccionado);
                    break;
                case 7:
                    verSoldado(ejercitoSeleccionado);
                    break;
                case 8:
                    verEjercito(ejercitoSeleccionado);
                    break;
                case 9:
                    sumarNiveles(ejercitoSeleccionado);
                    break;
                case 10:
                    juegoRapido();
                    break;
                case 11:
                    menuPrincipal();
                    return;
            }
            ejercitoSeleccionado = seleccionarEjercito(); // Volver a seleccionar el ejército
        } while (opcion != 11);
    }

    // Métodos para cada opción del menú personalizado

    private ArrayList<Soldado> seleccionarEjercito() {
        System.out.println("Selecciona un ejército:");
        System.out.println("1. Ejército 1");
        System.out.println("2. Ejército 2");
        int eleccion = scanner.nextInt();
        return eleccion == 1 ? tablero.getEjercito1() : tablero.getEjercito2();
    }

    private void crearSoldado(ArrayList<Soldado> ejercito) {
        Random random=new Random();
        int fila,col;
        if (ejercito.size() >= 10) {
            System.out.println("El ejército ya tiene 10 soldados. No se pueden añadir más.");
            return;
        }
        String nombre = ejercito == tablero.getEjercito1() ? "A" + ejercito.size() : "B" + ejercito.size();
        do {
                fila = random.nextInt(10);
                col = random.nextInt(10);
            } while (tablero.getTablero()[fila][col] != null);

        Soldado nuevoSoldado = new Soldado(nombre, ejercito == tablero.getEjercito1() ? 'A' : 'B');
        ejercito.add(nuevoSoldado);
        nuevoSoldado.setPosicion(fila, col);
        tablero.getTablero()[fila][col] = nuevoSoldado;
        System.out.println("Soldado creado: " + nombre);
    }

    private void eliminarSoldado(ArrayList<Soldado> ejercito) {
        if (ejercito.size() <= 1) {
            System.out.println("No puedes dejar el ejército vacío.");
            return;
        }
        int indice = ejercito.size()-1;
        int fila=ejercito.get(indice).getFila();
        int col=ejercito.get(indice).getColumna();
        tablero.eliminarSoldado(fila, col);
        System.out.println("Se elimino el ultimo soldado del ejercito");
    }

    private void clonarSoldado(ArrayList<Soldado> ejercito) {
        Random random=new Random();
        int fila,col;
        if (ejercito.size() >= 10) {
            System.out.println("El ejército ya tiene 10 soldados. No se pueden añadir más.");
            return;
        }
        System.out.println("Elige el índice del soldado a clonar:");
        for (int i = 0; i < ejercito.size(); i++) {
            System.out.println(i + ": " + ejercito.get(i).getNombre());
        }
        int indice = scanner.nextInt();
        do {
                fila = random.nextInt(10);
                col = random.nextInt(10);
            } while (tablero.getTablero()[fila][col] != null);
        Soldado soldadoClonado = ejercito.get(indice).clonar();
        ejercito.add(soldadoClonado);
        String nombre = ejercito == tablero.getEjercito1() ? "A" + (ejercito.size()-1) : "B" + (ejercito.size()-1);
        soldadoClonado.setNombre(nombre);
        soldadoClonado.setPosicion(fila, col);
        tablero.getTablero()[fila][col] = soldadoClonado;
        System.out.println("Soldado clonado: " + soldadoClonado.getNombre());
    }

    private void modificarSoldado(ArrayList<Soldado> ejercito) {
        System.out.println("Elige el índice del soldado a modificar:");
        for (int i = 0; i < ejercito.size(); i++) {
            System.out.println(i + ": " + ejercito.get(i).getNombre());
        }
        int indice = scanner.nextInt();
        Soldado soldado = ejercito.get(indice);

        System.out.println("1. Nivel de Ataque");
        System.out.println("2. Nivel de Defensa");
        System.out.println("3. Vida Actual");
        int atributo = scanner.nextInt();

        System.out.print("Ingresa el nuevo valor: ");
        int nuevoValor = scanner.nextInt();

        switch (atributo) {
            case 1 -> soldado.setNivelAtaque(nuevoValor);
            case 2 -> soldado.setNivelDefensa(nuevoValor);
            case 3 -> soldado.setVidaActual(nuevoValor);
        }
        System.out.println("Atributo modificado.");
    }

    private void compararSoldados(ArrayList<Soldado> ejercito) {
        System.out.println("Elige los índices de los soldados a comparar:");
        for (int i = 0; i < ejercito.size(); i++) {
            System.out.println(i + ": " + ejercito.get(i).getNombre());
        }
        int indice1 = scanner.nextInt();
        int indice2 = scanner.nextInt();

        Soldado s1 = ejercito.get(indice1);
        Soldado s2 = ejercito.get(indice2);

        if (s1.equals(s2)) {
            System.out.println("Los soldados son iguales.");
        } else {
            System.out.println("Los soldados son diferentes.");
        }
    }

    private void intercambiarSoldados(ArrayList<Soldado> ejercito) {
        System.out.println("Elige los índices de los soldados a intercambiar:");
        for (int i = 0; i < ejercito.size(); i++) {
            System.out.println(i + ": " + ejercito.get(i).getNombre());
        }
        int indice1 = scanner.nextInt();
        int indice2 = scanner.nextInt();

        Collections.swap(ejercito, indice1, indice2);
        System.out.println("Soldados intercambiados.");
    }

    private void verSoldado(ArrayList<Soldado> ejercito) {
        System.out.print("Ingresa el nombre del soldado: ");
        String nombre = scanner.next();

        for (Soldado soldado : ejercito) {
            if (soldado.getNombre().equals(nombre)) {
                System.out.println(soldado);
                return;
            }
        }
        System.out.println("Soldado no encontrado.");
    }

    private void verEjercito(ArrayList<Soldado> ejercito) {
        System.out.println("Soldados del ejército:");
        for (Soldado soldado : ejercito) {
            System.out.println(soldado);
        }
    }

    private void sumarNiveles(ArrayList<Soldado> ejercito) {
        Soldado suma = new Soldado();
        for (Soldado soldado : ejercito) {
            suma = suma.sumar(soldado);
        }
        System.out.println("Sumatoria de niveles: " + suma.mostrarSumaNiveles());
    }
    
    private void salir(){
     Scanner sc=new Scanner(System.in);
    System.out.print("¿Desea terminar el juego y salir al menu principal?(S/N): ");
    char opcion=sc.next().toUpperCase().charAt(0);
    switch(opcion){
        case 'S':
        menuPrincipal();
        break;
        case 'N':
        break;
        default:
        break;                  
    }
    }
}
