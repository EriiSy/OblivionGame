package main;

public class Main {

    public static void main(String[] args) {
        WindowGame windowGame = new WindowGame();
        Menu menu = new Menu();
        menu.startMenu();
        windowGame.gameStartThread();
    }
}

