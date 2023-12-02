package Model;

public class Deck {
    Card cards[]= new Card[51];


    static void Deckgenerator(){
        String[] numeros = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] palos = {"Corazones", "Diamantes", "Picas", "Tréboles"};
        for (String numero : numeros) {
            for (String palo : palos) {
                Deck.Addcard(numero + " de " + palo);
            }
        }
    }

    public static int Addcard(Card card)
}

