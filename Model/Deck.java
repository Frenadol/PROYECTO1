package Model;
import Model.Card;

public class Deck {

    public static Card [] NewDeck = new Card[52];
    private static String[] Suits = new String[] {"Corazones", "Diamantes", "Tréboles", "Picas"};
    private static String[] Values = new String[] {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public Deck(){
        rellenarmazo();
    }

    /**
     * Quiero rellenar mi mazo
     * Una carta esta formada por un string y un entero
     */
    public static Card [] rellenarmazo(){
        int index = 0;
        //devolver arreglo
        int Cards []=new int[52];
        for (String Suit : Suits) {
            for (String Values : Values) {
                NewDeck[index] = new Card(Values, Suit);

                index++;
            }
        }

        return  NewDeck;
    }

    public void ShowDeck() {
        for (Card card : NewDeck) {
            System.out.println(card);
        }
    }
}


