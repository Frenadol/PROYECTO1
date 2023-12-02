package Model;
import Model.Card;

public class Deck {
    private Card [] NewDeck = new Card[52];
    private String[] Suits = new String[] {"Corazones", "Diamantes", "Tréboles", "Picas"};

    private Card [] rellenarmazo(int [] Cards){
        int index = 0;
        for (String suit : Suits) {
            for (int i = 0; i < 13; i++) {
                NewDeck[index] = new Card(suit, Cards[i]);
                index++;
            }
        }
        return NewDeck;
    }

    public void ShowDeck() {
        for (Card card : NewDeck) {
            System.out.println(card);
        }
    }
}