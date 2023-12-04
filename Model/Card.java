package Model;

import java.util.Objects;

public class Card {
    private String value;
    private String suit;

    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }
    public Card(){
        this("","");
    }


    public String getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && Objects.equals(suit, card.suit);
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit='" + suit + '\'' +
                '}';
    }
}
