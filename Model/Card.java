package Model;

public class Card {
    private final int value;
    private final String suit;
    private final String rank;

    public Card(int value, String suit, String rank) {
        // Aquí podrías añadir validación para los argumentos
        this.value = value;
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        String formattedRank = rank.length() == 1 ? rank + " " : rank;
        return "Card:\n" +
                "┌─────────┐\n" +
                "| " + formattedRank + "      |\n" +
                "|         |\n" +
                "|    " + suit + "   |\n" +
                "|         |\n" +
                "|      " + formattedRank + " |\n" +
                "└─────────┘\n";
    }
}
