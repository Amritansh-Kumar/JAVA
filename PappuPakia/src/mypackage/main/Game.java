package mypackage.main;

import javax.swing.*;

public class Game {

    public static final int GAME_HEIGHT = 500;
    public static final int GAME_WIDTH = 1000;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GamePanel panel = new GamePanel();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
