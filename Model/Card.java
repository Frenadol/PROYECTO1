package Model;

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

    public String getSuit() {
        return suit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}