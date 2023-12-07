import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner input;
    private int choice;
    private int numPlayers;
    private String[] playerNames;

    public Menu() {
        this.input = new Scanner(System.in);
        this.choice = 0;
        this.numPlayers = 0;
        this.playerNames = null;
    }

    public void menu() {
        while (choice != 2) {
            System.out.println("\033[1;36m*********************************************");
            System.out.println("*  🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲  *");
            System.out.println("*  ♠️♥️♣️♦️ **CASINO DE MONTEPINAR** ♦️♣️♥️♠️ *");
            System.out.println("*  🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲  *");
            System.out.println("*********************************************");
            System.out.println("💰💰💰 1: Empezar el juego 💰💰💰");
            System.out.println("🚪🚪🚪 2: Salir del casino 🚪🚪🚪");
            System.out.println("*********************************************\033");
            System.out.print("Ingrese su elección: ");
            try {
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("¡Comencemos con la caprichosa!");
                        System.out.print("Ingrese el número de jugadores (1-4): ");
                        numPlayers = input.nextInt();
                        if (numPlayers < 1 || numPlayers > 4) {
                            System.out.println("Error: Por favor, ingrese un número entre 1 y 4.");
                        } else {
                            playerNames = new String[numPlayers];
                            for (int i = 0; i < numPlayers; i++) {
                                System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
                                playerNames[i] = input.next();
                            }
                            System.out.println("¡Comenzando el juego con " + numPlayers + " jugadores!");
                        }
                        break;
                    case 2:
                        System.out.println("¡Gracias por visitar el casino!");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione un valor correcto.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un valor correcto.");
                input.next(); // descarta la entrada incorrecta para volver a pedir un valor correcto
            }
        }
    }
}
