package Model;
import Model.Card;

import java.util.Arrays;
import java.util.Collections;

public class Deck {

    private Card [] cards = new Card[52];
    private String[] suits = new String[] {"Corazones", "Diamantes", "Tréboles", "Picas"};
    private String[] ranks = new String[] {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private int cardIndex = 0;

    public Deck() {
        rellenarmazo();
    }

    public void rellenarmazo(){
        int index = 0;
        for (String Suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards[index] = new Card(i+1, Suit, ranks[i]);
                index++;
            }
        }
    }

    public void ShuffleDeck() {
        Collections.shuffle(Arrays.asList(cards));
    }

    public Card DrawCard() {
        if (cardIndex < cards.length) {
            return cards[cardIndex++];
        } else {
            throw new IllegalStateException("El mazo está vacío.");
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
}
