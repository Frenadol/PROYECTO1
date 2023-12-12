package Model;


/**
 * Esta clase su funcion, es crea una carta en un juego de cartas, tiene dos atributos
 * los cuales son value y suit,  que representan el valor y su palo correspondiente, el constructor recibe esos valores.El get value
 *
 * devuelve el valor de la carta y el Tostring es la represetacion visual
 */
public class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }
    @Override
    public String toString() {
        String cardValue;
        switch (value) {
            case 11:
                cardValue = "J";
                break;
            case 12:
                cardValue = "Q";
                break;
            case 13:
                cardValue = "K";
                break;
            default:
                cardValue = String.valueOf(value);
                break;
        }

        String suitSymbol;
        switch (suit) {
            case "Corazones":
                suitSymbol = "♥";
                break;
            case "Diamantes":
                suitSymbol = "♦";
                break;
            case "Tréboles":
                suitSymbol = "♣";
                break;
            case "Picas":
                suitSymbol = "♠";
                break;
            default:
                suitSymbol = suit;
                break;
        }

        return "┌───────┐\n" +
                "| " + cardValue + "     |\n" +
                "|       |\n" +
                "|   " + suitSymbol + "   |\n" +
                "|       |\n" +
                "|     " + cardValue + " |\n" +
                "└───────┘";
    }
}
