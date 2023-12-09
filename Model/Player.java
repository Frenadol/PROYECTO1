package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private int score;
    private boolean isAI;

    public Player(String name, boolean isAI) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
        this.isAI = isAI;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
        calculateScore();
    }

    private void calculateScore() {
        score = 0;
        int aceCount = 0;

        for (Card card : hand) {
            int value = card.getValue();
            if (value > 10) {
                value = 10; // Para J, Q, K
            } else if (value == 1) {
                aceCount++;
                value = 11;
            }
            score += value;
        }

        while (score > 21 && aceCount > 0) {
            score -= 10;
            aceCount--;
        }
    }

    public int getScore() {
        return score;
    }

    public List<Card> getHand() {
        return new ArrayList<>(hand);
    }

    public String getName() {
        return name;
    }
    public void setIsAI(boolean isAI) {
        this.isAI = isAI;
    }

    public boolean getIsAI() {
        return this.isAI;
    }
}


