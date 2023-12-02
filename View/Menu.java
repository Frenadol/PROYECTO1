import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 2) {
            System.out.println("***************************************");
            System.out.println("*                                     *");
            System.out.println("*             **CASINO**              *");
            System.out.println("*                                     *");
            System.out.println("***************************************");
            System.out.println("1: Empezar el juego");
            System.out.println("2: Salir del casino");
            System.out.println("***************************************");
            System.out.print("Ingrese su elección: ");
            try {
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("¡Comencemos con la caprichosa!");
                        System.out.print("Ingrese el número de jugadores (1-4): ");
                        int numPlayers = input.nextInt();
                        if (numPlayers < 1 || numPlayers > 4) {
                            System.out.println("Error: Por favor, ingrese un número entre 1 y 4.");
                        } else {
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
                input.next(); // descarta la entrada incorrecta
            }
        }
        input.close();
    }
}
