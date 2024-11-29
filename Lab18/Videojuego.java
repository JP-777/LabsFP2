import java.util.*;

class Videojuego{
  private static int levelCPU = 1;
  private static int gameVelocity = 1;
  private static boolean mapEffects = true;
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    while(true){

      System.out.println("|<>-<>| WORLD WAR X |<>-<>|");
      System.out.println("\n        OPTIONS            ");
      System.out.println("       1. Play \n"+
                         "       2. Setting\n"+
                         "       3. Salir");
      int option = sc.nextInt();
    
      switch(option){
        case 1: 
          play(); break;
        case 2:
          settings(); break;
        case 3:
          System.out.println("Exiting game...");
          return;
        default:
          System.out.println("Invalid option. Please try again.");
          break;
      } 
    }
  }

  public static void play() {
    System.out.println("          PLAYMODE         ");
    System.out.println("       1. Player vs Player \n"+
                       "       2. Player vs CPU \n"+
                       "       3. CPU vs CPU (Just Testing Mode) \n"+
                       "       4. Return");
    int option = sc.nextInt();

    switch(option){
      case 1: 
        startGame("P1", "P2", sc); break;
      case 2:
        startGame("P1", "CPU", sc); break;
      case 3:
        startGame("CPU", "CPU", sc); break;
      case 4:
        return;
      default:
        System.out.println("Invalid option. Please try again.");
        break;
    }
  }

  public static void settings() {
    
    while(true){
      System.out.println("          OPTIONS         ");
      System.out.println("       1. Change CPU Difficult \n"+
                         "       2. Change Game Velocity \n"+
                         "       3. Map Effects (Enable) \n"+
                         "       4. Return");
      int option = sc.nextInt();
  
      switch (option) {
        case 1: 
          System.out.print("CPU Difficulty Level (1 - 9): ");
          levelCPU = sc.nextInt();
          break;
        case 2:
          System.out.print("Game Velocity (1 - 3): ");
          gameVelocity = sc.nextInt();
          break;
        case 3:
          mapEffects = !mapEffects;
          System.out.println("Map Effects: " + (mapEffects ? "Enabled" : "Disabled"));
          break;
        case 4:
          return;
        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }
    }
  }

  public static void startGame(String player1, String player2, Scanner sc){
    Tablero board = new Tablero();
    board.generarEjercitos();

    for(int i = 0; i >= 0; i++){
      board.mostrarInterfaz();

      if(i % 2 == 0){
        System.out.println("     >---PLAYER 1 TURN---<");
        board.movimiento(1);
      } else {
        System.out.println("     >---PLAYER 2 TURN---<");
        board.movimiento(2);
      }
    }
  }
}
