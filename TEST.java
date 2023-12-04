import Model.Card;
import Model.Game;
import Model.Player;
import Model.Deck;
import Model.Card;
public class TEST {
    public static void main(String[] args) {

        Card[] cards= Model.Deck.rellenarmazo();
        for(int i=0;i< cards.length;i++){
            System.out.println(cards[i]);
        }

        class Deck {
            public static Card[] NewDeck = new Card[52];
            private static String[] Suits = new String[]{"Corazones", "Diamantes", "Tréboles", "Picas"};
            private static String[] Values = new String[]{"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

            public Deck() {
                rellenarmazo();
            }

            /**
             * Quiero rellenar mi mazo
             * Una carta esta formada por un string y un entero
             */
            public static Card [] rellenarmazo() {
                int index = 0;
                for (String Suit : Suits) {
                    for (String Values : Values) {
                        NewDeck[index] = new Card(Values, Suit);
                        index++;
                    }
                }
                return  NewDeck;
            }


            }

        }

    }







