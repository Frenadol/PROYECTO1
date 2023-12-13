package Model;
import java.util.Scanner;
public class Game {
    private Deck deck;
    private Player[] players;
    private Player aiPlayer;

    public Game(int numPlayers, String[] playerNames, boolean isAI) {
        deck = new Deck();
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player(playerNames[i], false);
        }
        if (isAI) {
            aiPlayer = new Player("IA", true);
        }
    }


    public void startGame() {
        for (Player player : players) {
            dealInitialCards(player);
        }
        if (aiPlayer != null) {
            dealInitialCards(aiPlayer);
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
            if (currentPlayer.getScore() > 21) {
                System.out.println(currentPlayer.getIsAI() ? "La IA se ha pasado de 21." : "Te has pasado de 21. ¡Vaya pringao!");
            }
            currentPlayerIndex++;
            if (currentPlayerIndex >= players.length) {
                currentPlayerIndex = 0;
            }
            gameEnded = checkAllPlayersBust() || currentPlayerIndex == 0;
        }
        if (aiPlayer != null) {
            aiPlayer.showHand();
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
            player.showHand();
            System.out.println("¿Deseas otra carta? (s/n)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("s")) {
                Card newCard = deck.DrawCard();
                player.addCardToHand(newCard);
                System.out.println("Has obtenido la carta: " + newCard); // Imprime la nueva carta
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
        int maxScore=0;
        for (Player player : players){
            if(player.getScore()<=21 && player.getScore()>maxScore)
                maxScore =player.getScore();
        }

        System.out.println("Turno de " + aiPlayer.getName());
        while (aiPlayer.getScore() <  maxScore ) {
            Card drawnCard = deck.DrawCard();
            aiPlayer.addCardToHand(drawnCard);
            System.out.println(aiPlayer.getName() + " ha obtenido la carta: " + drawnCard);
            if (aiPlayer.getScore() > 21) {
                System.out.println("La IA se ha pasado de 21.");
                break;
            }
        }
    }
    /**
     * Se encarga de determinar el jugador ganador de la partida, ya sea contra la IA o contra otros jugadores
     *
     * @return result (el nombre del jugador ganador)
     */
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
        if (aiPlayer != null && aiPlayer.getScore() > maxScore && aiPlayer.getScore() <= 21) {
            maxScore = aiPlayer.getScore();
            winner = aiPlayer.getName();
        }
        String result = winner.isEmpty() ? "Dealer" : winner;
        if (result.equals("IA")) {
            System.out.println("¡La IA ha ganado el juego!");
        }
        return result;
    }


}