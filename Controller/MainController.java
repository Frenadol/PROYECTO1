package Controller;

import Model.Game;
import View.Menu;

public class MainController {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.Showmenu();
        if (menu.getChoice() == 1) {
            Game game = new Game(menu.getNumPlayers(), menu.getPlayerNames(), menu.getIsAI());
            game.startGame();
        }
    }
} 