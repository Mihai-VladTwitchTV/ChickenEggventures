package main;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        gamePanel.startGameThread();
//        while(true)
//        System.out.println(gamePanel.hasFocus());
        ///Shift tab to enable focus for some reason gah dayum
        }

}