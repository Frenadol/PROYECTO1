package Model;
import java.util.Scanner;
public class Game {
    private Deck deck;
    private Player[] players;
    private boolean isAI;
    private Scanner input;
    public Game(int numPlayers, String[] playerNames, boolean isAI) {
        deck = new Deck();
        players = new Player[numPlayers];
        input = new Scanner(System.in);
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player(playerNames[i], false);
        }
        if (isAI) {
            players[numPlayers - 1].setIsAI(true); // El último jugador es la IA
        }
        this.isAI = isAI;
    }
    public Player getPlayer(int index) {
        return this.players[index];
    }
    public void startGame() {
        for (Player player : players) {
            dealInitialCards(player);
        }
        boolean gameEnded = false;
        int currentPlayerIndex = 0;
        while (!gameEnded) {
            Player currentPlayer = players[currentPlayerIndex];
            if (currentPlayer.getIsAI()) {
                aiPlay(currentPlayer);
            } else {
                playerPlay(currentPlayer);
            }
            currentPlayerIndex++;
            if (currentPlayerIndex >= players.length) {
                currentPlayerIndex = 0;
            }
            gameEnded = checkAllPlayersBust() || currentPlayerIndex == 0;
        }
        System.out.println("El ganador es: " + checkWinner());
        System.exit(0);
    }
    private boolean checkAllPlayersBust() {
        for (Player player : players) {
            if (player.getScore() <= 21) {
                return false;
            }
        }
        return true;
    }
    private void dealInitialCards(Player player) {
        for (int i = 0; i < 2; i++) {
            player.addCardToHand(deck.DrawCard());
        }
    }
    private void playerPlay(Player player) {
        System.out.println("Turno de " + player.getName());
        while (true) {
            System.out.println("Cartas en mano:");
            player.showHand();
            System.out.println("¿Deseas otra carta? (s/n)");
            String choice = input.next();
            if (choice.equalsIgnoreCase("s")) {
                player.addCardToHand(deck.DrawCard());
                if (player.getScore() > 21) {
                    System.out.println("Te has pasado de 21. ¡Vaya pringao!");
                    break;
                }
            } else if (choice.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Opción inválida. Por favor, selecciona 's' o 'n'.");
            }
        }
    }
    private void aiPlay(Player aiPlayer) {
        System.out.println("Turno de " + aiPlayer.getName());
        while (aiPlayer.getScore() < 17) {
            aiPlayer.addCardToHand(deck.DrawCard());
        }
        System.out.println("Cartas en mano de " + aiPlayer.getName() + ":");
        aiPlayer.showHand();
        if (aiPlayer.getScore() > 21) {
            System.out.println("La IA se ha pasado de 21.");
        }
    }
    public String checkWinner() {
        int maxScore = 0;
        String winner = "";
        for (Player player : players) {
            int score = player.getScore();
            if (score > maxScore && score <= 21) {
                maxScore = score;
                winner = player.getName();
            }
        }
        return winner.isEmpty() ? "Dealer" : winner;
    }
}