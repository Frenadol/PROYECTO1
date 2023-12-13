package Model;

import java.util.Scanner;

public class Game {
    private Deck deck;
    private Player[] players;
    private Player aiPlayer;

    /**
     * Metodo que crea los mazos de los jugadores.
     * @param playerNames inicializa un arreglo con los jugadores con su nombre proporcionado
     * @param isAI comprueba de que la IA juegue y con el booleano( participa en caso de que solo juegue un jugador)
     */
    public Game(int numPlayers, String[] playerNames, boolean isAI) {
        deck = new Deck();
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player(playerNames[i], false);
        }
        if (isAI) {
            aiPlayer = new Player("IA", true);
        }
    }

    /**
     * Este metodo hace varias funciones las cuales son
     * Reparto inicial de cartas con que reparten 2 a cada jugadores(incluyendo a la IA)
     * Se utiliza un while que se ejecuta hasta que juego termina permitiendo el "bucle" de las interacciones de los jugadores
     * En caso del turno de la IA (getIsAI() devuelve true) y llama a aiplay para que juegue la IA
     * Si no es el caso  pasara a playerPlay
     * Se verifica las condiciones del juego(jugadores pasado de 21 o se acaba el ciclo)
     * el %se utiliza para lograr un ciclo continuo a través de los índices del arreglo de jugadores,
     * asegurando que el índice no exceda la longitud del arreglo.
     */
    public void startGame() {
        dealInitialHands();
        boolean gameEnded = false;
        int currentPlayerIndex = 0;

        while (!gameEnded) {
            Player currentPlayer = players[currentPlayerIndex];
            if (currentPlayer.getIsAI()) {
                aiPlay(currentPlayer);
            } else {
                playerPlay(currentPlayer);
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
            gameEnded = checkAllPlayersBust() || currentPlayerIndex == 0;
        }

        if (aiPlayer != null) {
            aiPlayer.showHand();
        }

        System.out.println("El ganador es: " + checkWinner());
        System.exit(0);
    }

    /**
     * Un for each que intera con cada jugaodor, se compara sus puntos y se compara.
     *
     * @return si encuentra al menos  un jugador que no ha superado 21 ya lo devuelve, sino devuelve un true diciendo que ya han superado 21
     */
    private boolean checkAllPlayersBust() {
        for (Player player : players) {
            if (player.getScore() <= 21) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo utilizado para inicializar las manos a los jugadores correspondientes( saber a cuantos jugadores tiene que dar las cartas) con un for each
     * Despues un if cuya funcion es qu si participa la IA que se le asignen dos cartas aleatorias
     */
    private void dealInitialHands() {
        for (Player player : players) {
            dealInitialCards(player);
        }
        if (aiPlayer != null) {
            dealInitialCards(aiPlayer);
        }
    }

    /**
     * La diferencia con el de arriba es que este ya sabe el numero de jugadores y asgina 2 cartas a los jugadores participantes
     * (IA incluida)
     *
     */
    private void dealInitialCards(Player player) {
        for (int i = 0; i < 2; i++) {
            player.addCardToHand(deck.drawCard());
        }
    }

    /**
     * Metodo donde jugaodr juega, se decide si saca otras cartas, enseña las cartas de su mano
     *  Mientras su puntuacion sea menor a 21 y el jugador quiere seguir sacando cartas se dice un mensaje que si se quiere una cartsa
     *  Si se eilge "s" se añade otra carta al mazo y tambien se controla si se pasa de 21
     *
     */
    private void playerPlay(Player player) {
        System.out.println("Turno de " + player.getName());
        boolean continueDrawing = true;

        while (continueDrawing && player.getScore() <= 21) {
            player.showHand();
            System.out.println("¿Deseas otra carta? (s/n)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("s")) {
                Card newCard = deck.drawCard();
                player.addCardToHand(newCard);
                System.out.println("Has obtenido la carta: \n" + newCard);

                if (player.getScore() > 21) {
                    System.out.println("Te has pasado de 21. ¡Vaya pringao!");
                    continueDrawing = false;
                }
            } else if (choice.equalsIgnoreCase("n")) {
                continueDrawing = false;
            } else {
                System.out.println("Opción inválida. Por favor, selecciona 's' o 'n'.");
            }
        }

        if (player.getScore() > 21) {
            System.out.println("Turno del siguiente jugador...");
        }
    }

    /**
     * Aqui lo que haces es jugar la IA, poner mensajes de que la IA juega por pantalla,
     * Se le añaden cartas a su mano
     * Tambien se tiene control por si se pasa de 21 la IA
     * @param aiPlayer
     */
    private void aiPlay(Player aiPlayer) {
        int maxScore = getMaxPlayerScore();
        System.out.println("Turno de " + aiPlayer.getName());

        while (aiPlayer.getScore() < maxScore) {
            Card drawnCard = deck.drawCard();
            aiPlayer.addCardToHand(drawnCard);
            System.out.println(aiPlayer.getName() + " ha obtenido la carta: " + drawnCard);

            if (aiPlayer.getScore() > 21) {
                System.out.println("La IA se ha pasado de 21.");
            }
        }
    }
/**
 * Se utiliza un bucle for each para iterar con todos los jugadores y se verifica sus puntos obtenidos
 * Se verifican los puntos de todos los jugadores para saber si es menor o igual que 21
 * Si es menor a 21 se devuelve false inmediatamente
 * Si todos tienen 21 se deveuleve un true(Dificil que pase)
 */
    private int getMaxPlayerScore() {
        int maxScore = 0;
        for (Player player : players) {
            if (player.getScore() <= 21 && player.getScore() > maxScore) {
                maxScore = player.getScore();
            }
        }
        return maxScore;
    }

    /**
     * Max score se pone a 0 y winner una cadena vacia
     * Se utiliza un for each para interar con todos los jugadores del arreglo
     * Se verifica los puntos de todos los jugadores si su puntuacion es mayor a maxscore y menor a 21
     * Tambien se tiene en cuenta la verificacion de la IA
     * Se busca el jugador que tenga el max score y que sea menor o igual que 21
     * Tambien se verifica la IA por si esta gana
     * @return el resultado
     */
    public String checkWinner() {
        int maxScore = 0;
        String winner = "";

        for (Player player : players) {
            int score = player.getScore();
            if (score > maxScore && score <= 21) {
                maxScore = score;
                winner = player.getName();
            }
        }

        if (aiPlayer != null && aiPlayer.getScore() > maxScore && aiPlayer.getScore() <= 21) {
            maxScore = aiPlayer.getScore();
            winner = aiPlayer.getName();
        }

        String result = winner.isEmpty() ? "Dealer" : winner;
        if (result.equals("IA")) {
            System.out.println("¡La IA ha ganado el juego!");
        }

        return result;
    }

    public Game() {
    }

    public Game(Deck deck, Player[] players, Player aiPlayer) {
        this.deck = deck;
        this.players = players;
        this.aiPlayer = aiPlayer;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player getAiPlayer() {
        return aiPlayer;
    }

    public void setAiPlayer(Player aiPlayer) {
        this.aiPlayer = aiPlayer;
    }
}
