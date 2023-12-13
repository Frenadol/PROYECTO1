package Model;

import java.util.Arrays;
import java.util.Collections;

public class Deck {
    private Card[] cards = new Card[52];
    private String[] suits = new String[] {"Corazones", "Diamantes", "Tréboles", "Picas"};
    private String[] ranks = new String[] {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public Deck() {
        rellenarMazo();
    }

    public void rellenarMazo() {
        int index = 0;
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards[index++] = new Card(i + 1, suit);
            }
        }
        shuffleDeck();
    }

    public void shuffleDeck() {
        Collections.shuffle(Arrays.asList(cards));
    }

    public Card drawCard() {
        if (cards.length > 0) {
            Card card = cards[cards.length - 1];
            cards = Arrays.copyOf(cards, cards.length - 1);
            return card;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Deck{" +
                "Card=" + Arrays.toString(cards) +
                '}';
    }

    public Card[] getCards() {
        return this.cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public String[] getSuits() {
        return suits;
    }

    public void setSuits(String[] suits) {
        this.suits = suits;
    }

    public String[] getRanks() {
        return ranks;
    }

    public void setRanks(String[] ranks) {
        this.ranks = ranks;
    }
}