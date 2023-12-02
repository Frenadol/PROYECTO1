import Model.Card;
import Model.Deck;
import java.util.Scanner;
public class TEST {
    public static void main(String[] args) {

    }
    private Card [] NewDeck = new Card[52];
    private String[] Suits = new String[] {"Corazones", "Diamantes", "Tréboles", "Picas"};

    private Card [] rellenarmazo(int [] Cards){
        int AllCards = 0;
        for (String suit : Suits) {
            for (int i = 0; i < 13; i++) {
                NewDeck[i] = new Card();
                AllCards++;
            }

        }
        return NewDeck;
    }

}
