package Model;

public class Game {
    private Deck deck;
    private Player[] players;
    private boolean isAI;

    public Game(int numPlayers, String[] playerNames, boolean isAI) {
        deck = new Deck();
        players = new Player[numPlayers];
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
            if (!player.getIsAI()) {
                playerPlay(player);
            } else {
                aiPlay(player);
            }
        }
        System.out.println("El ganador es: " + checkWinner());
    }

    private void dealInitialCards(Player player) {
        for (int i = 0; i < 2; i++) {
            player.addCardToHand(deck.DrawCard());
        }
    }

    private void playerPlay(Player player) {
        player.addCardToHand(deck.DrawCard());
    }

    private void aiPlay(Player aiPlayer) {
        while (aiPlayer.getScore() < 17) {
            aiPlayer.addCardToHand(deck.DrawCard());
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
