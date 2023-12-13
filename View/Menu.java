package View;
import Controller.MainController;
import Model.Game;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.Showmenu();
    }

    private Scanner input;
    private int choice;
    private int numPlayers;
    private String[] playerNames;
    public boolean isAI;

    public Menu() {
        this.input = new Scanner(System.in);
        this.numPlayers = 0;
        this.playerNames = null;
        this.isAI = false;
    }

    public void Showmenu() {
        do {
            System.out.println("\u001B[34m*********************************************");
            System.out.println("*  🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲  *");
            System.out.println("*  ♠️♥️♣️♦️ **CASINO DE MONTEPINAR V1.0** ♦️♣️♥️♠️ *");
            System.out.println("*  🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲  *");
            System.out.println("*********************************************");
            System.out.println("💰💰💰 1: Empezar el juego 💰💰💰");
            System.out.println("🚪🚪🚪 2: Salir del casino 🚪🚪🚪");
            System.out.println("*********************************************\u001B[0m");
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
                            if (numPlayers == 1) {
                                isAI = true;
                                System.out.println("¡Comenzando el juego con " + numPlayers + " jugador y una IA!");
                            } else {
                                System.out.println("¡Comenzando el juego con " + numPlayers + " jugadores!");
                            }
                            // Iniciar el juego
                            Game game = new Game(numPlayers, playerNames, isAI);
                            game.startGame();
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
        } while (choice != 2);
    }


    public int getChoice() {
        return choice;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public String[] getPlayerNames() {
        return playerNames;
    }

    public boolean getIsAI() {
        return isAI;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public void setAI(boolean AI) {
        isAI = AI;
    }

    public Scanner getInput() {
        return input;
    }

    public boolean isAI() {
        return isAI;
    }
}