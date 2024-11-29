import java.util.*;

class Tablero {
  private List<Soldado> ejercito1;
  private List<Soldado> ejercito2;

  public Tablero(){
    this.ejercito1 = new ArrayList<>();
    this.ejercito2 = new ArrayList<>();
  }

    public void generarEjercitos() {

      List<int[]> posicionesOcupadas = new ArrayList<>();

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
          
          boolean posicionOcupada = false;
          for (int[] posicion : posicionesOcupadas) {
              if (posicion[0] == posicionFila && posicion[1] == posicionColumna) {
                  posicionOcupada = true;
                  break;
              }
          }

          while (posicionOcupada) {
              posicionFila = (int) (Math.random() * 10 + 1);
              posicionColumna = (int) (Math.random() * 10 + 1);
            
              posicionOcupada = false;
              for (int[] posicion : posicionesOcupadas) {
                  if (posicion[0] == posicionFila && posicion[1] == posicionColumna) {
                      posicionOcupada = true;
                      break;
                  }
              }
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
    System.out.print(  "     +--------------------------+                                               +--------------------------+\n"+
                       "     |           ARMY1          |     A   B   C   D   E   F   G   H   I   J     |           ARMY2          |\n"+
                       "     +-------------+------------+   +---+---+---+---+---+---+---+---+---+---+   +-------------+------------+\n"+
                       "     |   Soldier   |   Status   | 1 "); dibujarTablero(0); System.out.println(" 1 |   Soldier   |   Status   |");
    System.out.println("     +-------------+------------+   +---+---+---+---+---+---+---+---+---+---+   +-------------+------------+");

    for (int i = 0; i < 10; i++) {
      System.out.print("     |");

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
          } else if(this.ejercito2.get(i).getActitud().substring(0,1).equals("D")){
            System.out.print(" "+this.ejercito2.get(i).getActitud()+" ");
          } else {
            System.out.print("   "+this.ejercito2.get(i).getActitud()+"   ");
          }
        }
        
        System.out.print("|");
        System.out.println("\n     +-------------+------------+   +---+---+---+---+---+---+---+---+---+---+   +-------------+------------+");

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
        
        System.out.print("|");
        System.out.println("\n     +-------------+------------+                                               +-------------+------------+");
      }
    }
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

  public void movimiento(int numeroEjercito){
    Scanner sc = new Scanner(System.in);
    List<Soldado> ejercito;

    if(numeroEjercito == 1){
      ejercito = this.ejercito1;
    } else {
      ejercito = this.ejercito2;
    }
    
    while(true){
      System.out.print("     Select a Position: ");
      String posicion = sc.next();

      int columna = ((int) posicion.charAt(0)) - 64;
      int fila = ((int) posicion.charAt(1)) - 48;
      Soldado soldadoJugado;

      for(int i = 0; i < ejercito.size(); i++){
      
        if(ejercito.get(i).getPosicionFila() == fila && ejercito.get(i).getPosicionColumna() == columna){
          soldadoJugado = ejercito.get(i);
          soldadoJugado.avanzar();
          int velocidad = soldadoJugado.getVelocidad();
        
          System.out.println("Soldier Velocity: " + velocidad);
          System.out.println("From where wants to move?");

          if (fila - velocidad > 0){
            System.out.println("Up     (U)");
          } 
          if (fila + velocidad <= 10){
            System.out.println("Down   (D)");
          }
          if (columna - velocidad > 0){
            System.out.println("Left   (L)");
          }
          if (columna + velocidad <= 10){
            System.out.println("Right  (R)");
          }

          char option = sc.next().charAt(0);
          switch(option){
            case 'U':
              soldadoJugado.setPosicionFila(soldadoJugado.getPosicionFila() - velocidad); break;
            case 'D':
              soldadoJugado.setPosicionFila(soldadoJugado.getPosicionFila() + velocidad); break;
            case 'L':
              soldadoJugado.setPosicionColumna(soldadoJugado.getPosicionColumna() - velocidad); break;
            case 'R':
              soldadoJugado.setPosicionColumna(soldadoJugado.getPosicionColumna() + velocidad); break;
          }
          
          soldadoJugado.defender();
          return;
        }
      }
      System.out.println("There are no soldiers in that position, or isnt yours");
    }
  }

  public List<Soldado> getEjercito1 (){
    return this.ejercito1;
  }

  public List<Soldado> getEjercito2 (){
    return this.ejercito2;
  }
}
