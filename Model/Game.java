package Model;

import java.util.ArrayList;

public class Game {
    private int numPlayers;
    private String[] playerNames;
    private Model.Deck deck;
    private ArrayList<Card> communityCards;
    private ArrayList<Player> players;

    public Game(int numPlayers, String[] playerNames) {
        this.numPlayers = numPlayers;
        this.playerNames = playerNames;
        this.deck = new Model.Deck();
        this.communityCards = new ArrayList<>();
        this.players = new ArrayList<>();
        for (String name : playerNames) {
            this.players.add(new Player(name));
        }
    }




    public void startGame() {
        // Baraja el mazo
        deck.ShuffleDeck();

        // Reparte dos cartas a cada jugador
        for (Player player : players) {
            player.addCardToHand(deck.DrawCard());
            player.addCardToHand(deck.DrawCard());
        }

        // Descubre las tres primeras cartas comunitarias
        for (int i = 0; i < 3; i++) {
            communityCards.add(deck.DrawCard());
        }

        // Muestra las cartas de cada jugador y las cartas comunitarias
        for (Player player : players) {
            System.out.println(player.getName() + " tiene las cartas: " + deck.getCards());
        }
        System.out.println("Las cartas comunitarias son: " + communityCards);
    }
}
