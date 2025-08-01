package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tiles.Region;

import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Eggventure");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        gamePanel.startGameThread();
        //System.out.println("Bunger");
//        while(true)
//        System.out.println(gamePanel.hasFocus());
        ///Shift tab to enable focus for some reason gah dayum
        }

}



///Special thanks to https://www.youtube.com/@RyiSnow