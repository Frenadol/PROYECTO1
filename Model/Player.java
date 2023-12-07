package Model;

import java.util.ArrayList;

public class Player {
    private String name; // Nombre del jugador
    private ArrayList<Card> hand; // Las cartas que el jugador tiene en la mano
    private int score; // La puntuación actual del jugador

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    // Método para agregar una carta a la mano del jugador
    public void addCardToHand(Card card) {
        hand.add(card);
        calculateScore();
    }

    // Método para calcular la puntuación del jugador
    private void calculateScore() {
        score = 0;
        boolean hasAce = false;

        for (Card card : hand) {
            int value = card.getValue();
            if (value > 10) {
                value = 10; // Para J, Q, K
            } else if (value == 1) {
                hasAce = true;
            }
            score += value;
        }

        // Si el jugador tiene un As y si contar el As como 11 no hace que el jugador se pase de 21, entonces cuenta el As como 11
        if (hasAce && score + 10 <= 21) {
            score += 10;
        }
    }

    /**
     *
     * @return puntuacion de la persona
     */
    public int getScore() {
        return score;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }
}