package Model;

public class Player {
    private String name;
    private Card[] hand;
    private int score;
    private boolean isAI;
    private int handSize;

    public Player(String name, boolean isAI) {
        this.name = name;
        this.hand = new Card[10]; // Tamaño máximo de la mano
        this.score = 0;
        this.isAI = isAI;
        this.handSize = 0;
    }

    public void addCardToHand(Card card) {
        hand[handSize++] = card;
        calculateScore();
    }

    private void calculateScore() {
        score = 0;
        int aceCount = 0;
        for (int i = 0; i < handSize; i++) {
            int value = hand[i].getValue();
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

    public Card[] getHand() {
        return hand;
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

    public void showHand() {
        for (int i = 0; i < handSize; i++) {
            System.out.println(hand[i]);
        }
    }

    public boolean checkCardInHand(Card card) {
        for (int i = 0; i < handSize; i++) {
            if (hand[i].equals(card)) {
                return true;
            }
        }
        return false;
    }
}
