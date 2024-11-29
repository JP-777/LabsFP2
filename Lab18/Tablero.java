import java.util.*;

class Tablero {
  private List<Soldado> ejercito1;
  private List<Soldado> ejercito2;
  private List<int[]> posicionesOcupadas;

  public Tablero(){
    this.ejercito1 = new ArrayList<>();
    this.ejercito2 = new ArrayList<>();
    this.posicionesOcupadas = new ArrayList<>();
  }

    public void generarEjercitos() {

      for(int i = 0; i < 2; i++){
        List<Soldado> ejercito;
        if(i == 0){
          ejercito = this.ejercito1;
        } else {
          ejercito = this.ejercito2;
        }
        int numeroSoldados = (int) (Math.random() * 10 + 1);
        int e = 1, c = 1, a  = 1;
        for (int j = 0; j < numeroSoldados; j++) {
          int tipo = (int) (Math.random() * 3 + 1);
          int nivelAtaque = (int) (Math.random() * 5 + 1);
          int nivelDefensa = (int) (Math.random() * 5 + 1);
          int nivelVida = (int) (Math.random() * 5 + 1);
          int posicionFila = (int) (Math.random() * 10 + 1);
          int posicionColumna = (int) (Math.random() * 10 + 1);
          
          while (posicionEstaOcupada(posicionFila, posicionColumna)) {
            posicionFila = (int) (Math.random() * 10 + 1);
            posicionColumna = (int) (Math.random() * 10 + 1);
          }

          posicionesOcupadas.add(new int[]{posicionFila, posicionColumna});

          switch (tipo) {
            case 1:
              ejercito.add(new Espadachin((i+1) + "Espadachin " + e, nivelVida, posicionFila, posicionColumna, nivelAtaque, nivelDefensa, Math.random() * 5 + 1)); e++;
              break;
            case 2:
              ejercito.add(new Caballero((i+1) + "Caballero " + c, nivelVida, posicionFila, posicionColumna, nivelAtaque, nivelDefensa, Math.random() > 0.5)); c++;
              break;
            case 3:
              ejercito.add(new Arquero((i+1) + "Arquero " + a, nivelVida, posicionFila, posicionColumna, nivelAtaque, nivelDefensa, (int) (Math.random() * 10 + 1))); a++;
              break;
          }
        }
      }
    }

  public void mostrarInterfaz() {

    System.out.print(  "██                                                                                                             ██\n"+
                       "██   +--------------------------+                                               +--------------------------+   ██\n"+
                       "██   |           ARMY1          |     A   B   C   D   E   F   G   H   I   J     |           ARMY2          |   ██\n"+
                       "██   +-------------+------------+   +---+---+---+---+---+---+---+---+---+---+   +-------------+------------+   ██\n"+
                       "██   |   Soldier   |   Status   | 1 "); dibujarTablero(0); System.out.println(" 1 |   Soldier   |   Status   |   ██");
    System.out.println("██   +-------------+------------+   +---+---+---+---+---+---+---+---+---+---+   +-------------+------------+   ██");

    for (int i = 0; i < 10; i++) {
      System.out.print("██   |");

      if(i >= ejercito1.size()){
        System.out.print("             ");
      } else {
        if(this.ejercito1.get(i).getNombre().substring(1,2).equals("E")){
          System.out.print(this.ejercito1.get(i).getNombre().substring(1)+" ");
        } else if(this.ejercito1.get(i).getNombre().substring(1,2).equals("C")){
          System.out.print(" "+this.ejercito1.get(i).getNombre().substring(1)+" ");
        } else {
          System.out.print("  "+this.ejercito1.get(i).getNombre().substring(1)+"  ");
        }
      }

      System.out.print("|");

      if(i >= ejercito1.size()){
        System.out.print("            ");
      } else {
        if(this.ejercito1.get(i).getActitud().substring(0,1).equals("O")){
          System.out.print(" "+this.ejercito1.get(i).getActitud()+"  ");
        } else if(this.ejercito1.get(i).getActitud().equals("Dead")){
          System.out.print("     "+this.ejercito1.get(i).getActitud()+"      ");
        } else if(this.ejercito1.get(i).getActitud().substring(0,1).equals("D")){
          System.out.print(" "+this.ejercito1.get(i).getActitud()+" ");
        } else {
          System.out.print("   "+this.ejercito1.get(i).getActitud()+"   ");
        }
      }
      
      if(i + 2 < 10){
        System.out.print("| "+(i+2)+" ");
      } else if (i + 2 == 10) {
        System.out.print("| "+(i+2));
      } else {
        System.out.print("|   ");
      }

      if(i < 9){
        dibujarTablero(i + 1);

        if(i + 2 < 10){
          System.out.print(" "+(i+2)+" |");
        } else if (i + 2 == 10) {
          System.out.print((i+2)+" |");
        } else {
          System.out.print("   |");
        }
        if(i >= ejercito2.size()){
          System.out.print("             ");
        } else {
          if(this.ejercito2.get(i).getNombre().substring(1,2).equals("E")){
            System.out.print(this.ejercito2.get(i).getNombre().substring(1)+" ");
          } else if(this.ejercito2.get(i).getNombre().substring(1,2).equals("C")){
            System.out.print(" "+this.ejercito2.get(i).getNombre().substring(1)+" ");
          } else {
            System.out.print("  "+this.ejercito2.get(i).getNombre().substring(1)+"  ");
          }
        }

        System.out.print("|");

        if(i >= ejercito2.size()){
          System.out.print("            ");
        } else {
          if(this.ejercito2.get(i).getActitud().substring(0,1).equals("O")){
            System.out.print(" "+this.ejercito2.get(i).getActitud()+"  ");
          } else if(this.ejercito2.get(i).getActitud().equals("Dead")){
            System.out.print("    "+this.ejercito2.get(i).getActitud()+"    ");
          } else if(this.ejercito2.get(i).getActitud().substring(0,1).equals("D")){
            System.out.print(" "+this.ejercito2.get(i).getActitud()+" ");
          } else {
            System.out.print("   "+this.ejercito2.get(i).getActitud()+"   ");
          }
        }
        
        System.out.print("|   ██");
        System.out.println("\n██   +-------------+------------+   +---+---+---+---+---+---+---+---+---+---+   +-------------+------------+   ██");

      } else {

        System.out.print("  A   B   C   D   E   F   G   H   I   J     |");

        if(i >= ejercito2.size()){
          System.out.print("             ");
        } else {
          if(this.ejercito2.get(i).getNombre().substring(1,2).equals("E")){
            System.out.print(this.ejercito2.get(i).getNombre().substring(1)+" ");
          } else if(this.ejercito2.get(i).getNombre().substring(1,2).equals("C")){
            System.out.print(" "+this.ejercito2.get(i).getNombre().substring(1)+" ");
          } else {
            System.out.print("  "+this.ejercito2.get(i).getNombre().substring(1)+"  ");
          }
        }

        System.out.print("|");

        if(i >= ejercito2.size()){
          System.out.print("            ");
        } else {
          if(this.ejercito2.get(i).getActitud().substring(0,1).equals("O")){
            System.out.print(" "+this.ejercito2.get(i).getActitud()+"  ");
          } else if(this.ejercito2.get(i).getActitud().substring(0,1).equals("D")){
            System.out.print(" "+this.ejercito2.get(i).getActitud()+" ");
          } else {
            System.out.print("   "+this.ejercito2.get(i).getActitud()+"   ");
          }
        }
        
        System.out.print("|   ██");
        System.out.println("\n██   +-------------+------------+                                               +-------------+------------+   ██");
      }
    }
    System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████████████████████████\n");
  }
  
  public void dibujarTablero(int i) {
      for (int j = 0; j < 10; j++) {
        boolean ocupado = false;
        for (Soldado soldado : this.ejercito1) {
          if (soldado.getPosicionFila() == i + 1 && soldado.getPosicionColumna() == j + 1) {
            System.out.print("|" + soldado.getNombre().substring(0,2) + soldado.getNombre().substring(soldado.getNombre().length()-1));
            ocupado = true;
            break;
          }
        }
        for (Soldado soldado : this.ejercito2) {
          if (soldado.getPosicionFila() == i + 1 && soldado.getPosicionColumna() == j + 1) {
            System.out.print("|" + soldado.getNombre().substring(0,2) + soldado.getNombre().substring(soldado.getNombre().length()-1));
            ocupado = true;
            break;
          }
        }
        if (!ocupado) {
          System.out.print("|   ");
        }
      }
      System.out.print("|");
  }

  public void movimiento(int numeroEjercito) {
    Scanner sc = new Scanner(System.in);
    List<Soldado> ejercito;
    List<Soldado> ejercitoEnemigo;
    int columna;
    int fila;

    if (numeroEjercito == 1) {
        ejercito = this.ejercito1;
        ejercitoEnemigo = this.ejercito2;
    } else {
        ejercito = this.ejercito2;
        ejercitoEnemigo = this.ejercito1;
    }

    while (true) {
      while (true) {
        System.out.print("     Select a Position (ej. A1, B3): ");
        String posicion = sc.next();        
        if (posicion.length() == 2 && Character.isUpperCase(posicion.charAt(0)) && Character.isDigit(posicion.charAt(1))) {
            columna = posicion.charAt(0) - 'A' + 1;
            fila = Character.getNumericValue(posicion.charAt(1));

            System.out.println("You selected: " + posicion);
            break;

        } else {
            System.out.println("Invalid input. Please enter a position in the format: Letter (A-Z) followed by a number (1-9).");
        }
    }

        Soldado soldadoJugado = null;

        for (int i = 0; i < ejercito.size(); i++) {
          if (ejercito.get(i).getPosicionFila() == fila && ejercito.get(i).getPosicionColumna() == columna) {
              soldadoJugado = ejercito.get(i);
              break;
          }
        }

        if (soldadoJugado != null) {
          soldadoJugado.avanzar();
          int velocidad = soldadoJugado.getVelocidad();
          String option;

          while(true){
            System.out.println("Soldier Velocity: " + velocidad);
            System.out.println("From where wants to move?");

            if (fila - velocidad > 0) {
                System.out.println("Up     (U)");
            }
            if (fila + velocidad <= 10) {
                System.out.println("Down   (D)");
            }
            if (columna - velocidad > 0) {
                System.out.println("Left   (L)");
            }
            if (columna + velocidad <= 10) {
                System.out.println("Right  (R)");
            }

            option = sc.next();
            if (option.length() == 1 && (option.equals("U") || option.equals("D") || option.equals("L") || option.equals("R"))){
              System.out.println("You selected: " + option);
              break;
            } else {
              System.out.println("Invalid input. Please enter a valid option");
            }
          }
          
          int nuevaFila = fila;
          int nuevaColumna = columna;

          switch (option) {
            case "U":
                nuevaFila -= velocidad;
                break;
            case "D":
                nuevaFila += velocidad;
                break;
            case "L":
                nuevaColumna -= velocidad;
                break;
            case "R":
                nuevaColumna += velocidad;
                break;
          }

          boolean posicionOcupada = false;
          for (int[] posicionOcupa : posicionesOcupadas) {
            if (posicionOcupa[0] == nuevaFila && posicionOcupa[1] == nuevaColumna) {
                posicionOcupada = true;
                break;
            }
          }

          if (posicionOcupada) {
              for (Soldado soldado : ejercito) {
                  if (soldado.getPosicionFila() == nuevaFila && soldado.getPosicionColumna() == nuevaColumna) {
                      System.out.println("Warning: Soldier from your army is already at this position!");
                      return;
                  }
              }

              System.out.println("Battle! A soldier from the enemy army is at this position!");
              Soldado soldadoEnemigo =  null;
              librarBatalla(soldadoJugado, soldadoEnemigo, fila, columna, nuevaFila, nuevaColumna);

              for(int i = 0; i < ejercitoEnemigo.size(); i++){
                if(ejercitoEnemigo.get(i).getPosicionFila() == nuevaFila && ejercitoEnemigo.get(i).getPosicionColumna() == nuevaColumna){
                  soldadoEnemigo = ejercitoEnemigo.get(i);
                }
              }


          } else {
              soldadoJugado.setPosicionFila(nuevaFila);
              soldadoJugado.setPosicionColumna(nuevaColumna);
              posicionesOcupadas.add(new int[]{nuevaFila, nuevaColumna});
          }
          soldadoJugado.defender();
          return;
        }
        System.out.println("There are no soldiers in that position, or isn't yours.");
    }
  }

  private void librarBatalla(Soldado soldadoJugado, Soldado soldadoEnemigo, int fila, int columna, int nuevaFila, int nuevaColumna) {
    Random rand = new Random();
    boolean soldadoGano = rand.nextBoolean();

    if (soldadoGano) {
        System.out.println("You won the battle! The enemy soldier is defeated.");
        soldadoJugado.setPosicionFila(nuevaFila);
        soldadoJugado.setPosicionColumna(nuevaColumna);
        soldadoEnemigo.morir();
        
        for (int i = 0; i < posicionesOcupadas.size(); i++) {
          int[] pos = posicionesOcupadas.get(i);
          if (pos[0] == nuevaFila && pos[1] == nuevaColumna) {
              posicionesOcupadas.remove(i);
              break;
          }
        }
        posicionesOcupadas.add(new int[]{nuevaFila, nuevaColumna});
    } else {
        System.out.println("You lost the battle! Your soldier is defeated.");
        soldadoJugado.morir();
        for (int i = 0; i < posicionesOcupadas.size(); i++) {
          int[] pos = posicionesOcupadas.get(i);
          if (pos[0] == fila && pos[1] == columna) {
              posicionesOcupadas.remove(i);
              break;
          }
        }
    }
  }

  public boolean todosLosSoldadosMuertos() {
    
    for(int i = 0; i < ejercito1.size(); i++){
      int deaths = 0;
      if(ejercito1.get(i).getActitud() == "Dead"){
        deaths++;
      }
      if(deaths == ejercito1.size()){
        System.out.println("El ganador es el Ejercito 2");
        return true;
      }
    }

    for(int i = 0; i < ejercito2.size(); i++){
      int deaths = 0;
      if(ejercito2.get(i).getActitud() == "Dead"){
        deaths++;
      }
      if(deaths == ejercito2.size()){
        System.out.println("El ganador es el Ejercito 1");
        return true;
      }
    }

    return false;
  }

  private boolean posicionEstaOcupada(int fila, int columna) {
    for (int[] posicion : posicionesOcupadas) {
        if (posicion[0] == fila && posicion[1] == columna) {
            return true;
        }
    }
    return false;
  }

  public List<Soldado> getEjercito1 (){
    return this.ejercito1;
  }

  public List<Soldado> getEjercito2 (){
    return this.ejercito2;
  }
}
