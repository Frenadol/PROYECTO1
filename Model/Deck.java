package Model;
import Model.Card;

import java.util.Arrays;
import java.util.Collections;

public class Deck {

    private Card[] cards = new Card[52];
    private String[] suits = new String[] {"Corazones", "Diamantes", "Tréboles", "Picas"};
    private String[] ranks = new String[] {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public Deck() {
        rellenarmazo();
    }

    /**
     * Este metodo se encarga de crear un mazo de cartas de poker
     * de 52 cartas una para cada combinacion de valor y palo.
     * Se usa un for para recorrer los valores.En cada iteración del bucle interno, se crea una nueva carta y se añade al mazo.
     * Despues con el ShuffleDeck se barajan esas cartas cuyo metodo esta compuesto de una coleccion
     * cuya funcion es barajar esas cartas para que despues su entraga sea aleatoria
     */
    public void rellenarmazo(){
        int index = 0;
        for (String Suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards[index++] = new Card(i+1, Suit);
            }
        }
        ShuffleDeck();
    }

    public void ShuffleDeck() {
        Collections.shuffle(Arrays.asList(cards));
    }

    /**
     * El método DrawCard() de la clase Deck .
     * @return devuelve la última carta del mazo. Si el mazo está vacío, devuelve null
     */
    public Card DrawCard() {
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
}
