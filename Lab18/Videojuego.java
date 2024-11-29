import java.util.*;

class Videojuego{
  private static int levelCPU = 1;
  private static int gameVelocity = 1;
  private static boolean mapEffects = true;
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████████████████████████\n"+
                       "██                           _      _         _    _     _      _              __  __                          ██\n"+
                       "██                          | |    | |___ _ _| |__| |   | |    | | _ _ _ __    \\ \\/ /                          ██\n"+
                       "██                          | | /\\ | / _ | '_| / _` |   | | /\\ | / _' | `__|    \\  /                           ██\n"+
                       "██                          |  V  V  |(_)| | || (_| |   |  V  V  |(_| | |       /  \\                           ██\n"+
                       "██                           \\__/\\__/\\___|_| |_\\__,_|    \\__/\\__/\\__,_|_|      /_/\\_\\                          ██\n"+
                       "██                                                                                                             ██\n"+
                       "█████████████████████████████████████████████████████████████████████████████████████████████████████████████████");

    while(true){

      System.out.print  ("██           _____     _   _                           ██                                                      ██\n" +
                         "██          /  _  \\ __| |_(_)___ _ __ ___     _        ██       1. PLAY       2. SETTINGS       3. SALIR       ██\n" +
                         "██          | | || '_ | __| / _ | '_ / __|   (_)       ██                                                      ██\n" +
                         "██          | |_|| |_)| |_| |(_)| | |\\__ \\    _        ██████████████████████████████████████████████████████████\n" +
                         "██          \\____| .__\\___|_\\___|_| |____/   (_)       ██                                                      ██\n" +
                         "██               |_|                                   ██       SELECT AN OPTION: ");int option = sc.nextInt();
      System.out.print  ("██                                                     ██                                                      ██\n"+
                         "█████████████████████████████████████████████████████████████████████████████████████████████████████████████████\n");

    
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

    System.out.print  ("██       ____  _            __  __        _                ██                                                  ██\n" + 
                       "██      |  _ \\| |__ _ _   _|  \\/  |___ __| |___     _      ██  1. PLAYER vs PLAYER         4. RETURN           ██\n" + 
                       "██      | |_) | / _` | | | | |\\/| / _ / _` / _ \\   (_)     ██                                                  ██\n" + 
                       "██      |  __/|| (_| | |_| | |  | |(_)|(_||  __/    _      ██  2. PLAYER vs CPU (beta)  █████████████████████████\n" + 
                       "██      |_|   |_\\__,_|\\__, |_|  |_\\___\\__,_\\___|   (_)     ██                           ██                     ██\n" + 
                       "██                    |___/                                ██  3. CPU vs CPU (beta)     ██  SELECT AN OPTION: ");int option = sc.nextInt();
    System.out.print  ("██                                                         ██                           ██                     ██\n"+
                       "█████████████████████████████████████████████████████████████████████████████████████████████████████████████████\n");

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

      if(board.todosLosSoldadosMuertos()){
        return;
      }

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
