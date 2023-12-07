package Model;
import Model.Card;

import java.util.Arrays;
import java.util.Collections;

public class Deck {

    public  Card [] cards = new Card[52];
    private  String[] suits = new String[] {"Corazones", "Diamantes", "Tréboles", "Picas"};
    private  int[] values = new int[] {1, 2, 3, 4 ,5, 6, 7, 8, 9, 10, 11, 12, 13};

    private int cardIndex = 0;

    /**
     * Quiero rellenar mi mazo
     * Una carta esta formada por un string y un entero
     */
    public void  rellenarmazo(){
        int index = 0;
        //devolver arreglo
        for (String Suit : suits) {
            for (int Values : values) {
                cards[index] = new Card(Values, Suit);
                index++;
            }
        }

    }

    public void ShuffleDeck() {
        Collections.shuffle(Arrays.asList(cards));
    }

    /**
     * Esta función devuelve una carta del mazo.
     * @return una carta del mazo
     */
    public Card DrawCard() {
        if (cardIndex < cards.length) {
            return cards[cardIndex++];
        } else {
            System.out.println("El mazo está vacío.");
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
}
