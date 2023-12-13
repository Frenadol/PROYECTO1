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
        dealInitialHands();
        boolean gameEnded = false;
        int currentPlayerIndex = 0;

        while (!gameEnded) {
            Player currentPlayer = players[currentPlayerIndex];
            if (currentPlayer.getIsAI()) {
                aiPlay(currentPlayer);
            } else {
                playerPlay(currentPlayer);
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
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

    private void dealInitialHands() {
        for (Player player : players) {
            dealInitialCards(player);
        }
        if (aiPlayer != null) {
            dealInitialCards(aiPlayer);
        }
    }

    private void dealInitialCards(Player player) {
        for (int i = 0; i < 2; i++) {
            player.addCardToHand(deck.drawCard());
        }
    }

    private void playerPlay(Player player) {
        System.out.println("Turno de " + player.getName());
        boolean continueDrawing = true;

        while (continueDrawing && player.getScore() <= 21) {
            player.showHand();
            System.out.println("¿Deseas otra carta? (s/n)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("s")) {
                Card newCard = deck.drawCard();
                player.addCardToHand(newCard);
                System.out.println("Has obtenido la carta: \n" + newCard);

                if (player.getScore() > 21) {
                    System.out.println("Te has pasado de 21. ¡Vaya pringao!");
                    continueDrawing = false;
                }
            } else if (choice.equalsIgnoreCase("n")) {
                continueDrawing = false;
            } else {
                System.out.println("Opción inválida. Por favor, selecciona 's' o 'n'.");
            }
        }

        if (player.getScore() > 21) {
            System.out.println("Turno del siguiente jugador...");
        }
    }

    private void aiPlay(Player aiPlayer) {
        int maxScore = getMaxPlayerScore();
        System.out.println("Turno de " + aiPlayer.getName());

        while (aiPlayer.getScore() < maxScore) {
            Card drawnCard = deck.drawCard();
            aiPlayer.addCardToHand(drawnCard);
            System.out.println(aiPlayer.getName() + " ha obtenido la carta: " + drawnCard);

            if (aiPlayer.getScore() > 21) {
                System.out.println("La IA se ha pasado de 21.");
            }
        }
    }

    private int getMaxPlayerScore() {
        int maxScore = 0;
        for (Player player : players) {
            if (player.getScore() <= 21 && player.getScore() > maxScore) {
                maxScore = player.getScore();
            }
        }
        return maxScore;
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

    public Game() {
    }

    public Game(Deck deck, Player[] players, Player aiPlayer) {
        this.deck = deck;
        this.players = players;
        this.aiPlayer = aiPlayer;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player getAiPlayer() {
        return aiPlayer;
    }

    public void setAiPlayer(Player aiPlayer) {
        this.aiPlayer = aiPlayer;
    }
}
