package main;

import entity.Player;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public final int ORIGINALTILESIZE = 16;
    public final int SCALE = 3;

    public final int TILESIZE = ORIGINALTILESIZE * SCALE;

    final int FPS = 60;
    final int BILLION = 1000000000;



    final int MAXSCREENCOL = 16;
    final int MAXSCREENROW = 12;
    final int SCREENWIDTH = TILESIZE * MAXSCREENCOL;//768 PIXELS
    final int SCREENHEIGHT = TILESIZE * MAXSCREENROW;//576 PIXELS

    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();

    Player player = new Player(this,keyHandler);

    TileManager tileManager = new TileManager(this);

    //doin players default position





    public GamePanel(){
        this.setPreferredSize(new Dimension(SCREENWIDTH,SCREENHEIGHT));
        this.setBackground(Color.GREEN);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyHandler);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void waitTime(double waitTimeMili){
        if(waitTimeMili < 0)
            waitTimeMili = 0;

        try {
            Thread.sleep((long) waitTimeMili);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void passTime(double waitTimeMili){
        double newTime = System.nanoTime()+waitTimeMili*1000000;
        while(System.nanoTime() < newTime){
            //do nothing
        }

    }

    @Override
    public void run() {
        double drawInterval = BILLION/FPS; //one frame every 0.016666 seconds
        double newTime = System.nanoTime() + drawInterval; //next draw time

        while(gameThread!=null){
            //1.update info
            update();

            //2.draw whatevs
            repaint();

            double remainingTime =newTime - System.nanoTime();

//            if(remainingTime < 0)
//                remainingTime = 0;
//
//            try {
//                Thread.sleep((long) remainingTime/1000000);//nanosec to millisec conv
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            waitTime(remainingTime/1000000);//nanosec to millisec conv

            newTime += drawInterval;
        }

    }

    public void update(){
        player.update();

    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D)graphics;
        tileManager.draw(graphics2D);
        player.draw(graphics2D);

        graphics2D.dispose();

    }
}
