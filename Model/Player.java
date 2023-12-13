// Player.java
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

    /**
     * Encargado de añadir cartas a las manos de los jugadores
     * @param card que es la carta
     */
    public void addCardToHand(Card card) {
        hand[handSize++] = card;
        calculateScore();
    }

    /**
     * Metodo cuya funcion es la de calcular los puntos recorriendo los  arrays(manos) de los jugadores
     * En donde obtiene sus valores, las letras J Q y K pasan a tener de valor 10 y el tema de los AS
     * Dependiendo de la puntuacion valdra un valor u otro
     */
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
            setScore(score);
        }
        while (score > 21 && aceCount > 0) {
            score -= 10;
            aceCount--;
        }
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public boolean getIsAI() {
        return this.isAI;
    }

    /**
     * funcion encargada de enseñar la mano de cada jugadores compuesta por un arrive que recorre
     * el arreglo de las cartas de los jugadores y las muestra por pantalla
     */
    public void showHand() {
        System.out.println("Cartas en mano de " + name + ":");
        for (int i = 0; i < handSize; i++) {
            System.out.println(hand[i]);
        }
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public boolean isAI() {
        return isAI;
    }

    public void setAI(boolean AI) {
        isAI = AI;
    }

    public int getHandSize() {
        return handSize;
    }

    public void setHandSize(int handSize) {
        this.handSize = handSize;
    }
}