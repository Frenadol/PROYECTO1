import Model.Card;
import Model.Player;
import Model.Deck;
import Model.Card;
import com.sun.jdi.Value;
import View.*;

import java.awt.*;

public class TEST {
    public static void main(String[] args) {

     Deck deck= new Deck();
     deck.rellenarmazo();
     deck.ShuffleDeck();
        System.out.println(deck);


        class Deck {
            public static Card[] newDeck = new Card[52];
            private static String[] suits = new String[]{"Corazones", "Diamantes", "Tréboles", "Picas"};
            private static int[] values = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

            public Deck() {
                rellenarmazo();
            }

            /**
             * Quiero rellenar mi mazo
             * Una carta esta formada por un string y un entero
             */
            public static Card [] rellenarmazo() {
                int index = 0;
                for (String Suit : suits) {
                    for (int Values : values) {
                        newDeck[index] = new Card(Values, Suit);
                        index++;
                    }
                }
                return  newDeck;
            }


            }

        }


    }







