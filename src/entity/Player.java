package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Key;

public class Player extends Entity{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    boolean dashing = false;

    public int dashingSpeed;
    public int speedCopy;

    public double dashedCooldownMilli = 100;
    public double dashedCooldownRemaining=0;
    public double dashTimeMilli=8;
    public double dashTimeRemaining=dashTimeMilli;

    public boolean justDashed=false;


    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        setDefaults();
        getPlayerSprite();
    }


    public void setDefaults(){
        coordX=100;
        coordY=100;
        speed=4;
        direction="right";
        speedCopy = speed;
        dashingSpeed = speed * 3;
    }

    public void getPlayerSprite(){
        try{

            up1= ImageIO.read(getClass().getResourceAsStream("/player/chicken_up1.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/player/chicken_up2.png"));
            down1= ImageIO.read(getClass().getResourceAsStream("/player/chicken_down1.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/player/chicken_down2.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/player/chicken_right1.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/player/chicken_right2.png"));
            left1= ImageIO.read(getClass().getResourceAsStream("/player/chicken_left1.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/player/chicken_left2.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

        movementCheck();
        animateSprite();
        dashCheck();






    }

    void animateSprite(){
        if(!isMoving)
            return;
        spriteCounter++;
        if(spriteCounter > 20) {///toggle sprite every 20 frames
            firstAnim = !firstAnim;
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D graphics2D){

        BufferedImage buffIm = null;

        switch(direction){
            case "up":
                if(firstAnim == true)
                    buffIm = up1;
                else
                    buffIm = up2;
                break;
            case "down":
                if(firstAnim == true)
                    buffIm = down1;
                else
                    buffIm = down2;
                break;
            case "right":
                if(firstAnim == true || isMoving == false)
                    buffIm = right1;
                else
                    buffIm = right2;
                break;
            case "left":
                if(firstAnim == true || isMoving == false)
                    buffIm = left1;
                else
                    buffIm = left2;;
                break;
            default:
                buffIm = right1;

        }

        graphics2D.drawImage(buffIm,coordX,coordY,gamePanel.TILESIZE,gamePanel.TILESIZE,null);

    }

    public void movementCheck(){
        if (keyHandler.wPressed == true){
            isMoving=true;
            direction="up";
            coordY = coordY - speed;

        } else if (keyHandler.sPressed == true){
            isMoving=true;
            direction="down";
            coordY = coordY + speed;

        }
        if(keyHandler.aPressed == true){
            isMoving=true;
            direction="left";
            coordX = coordX - speed;

        }else if (keyHandler.dPressed == true){
            isMoving=true;
            direction="right";
            coordX = coordX + speed;

        } else if (keyHandler.wPressed == false &&
                keyHandler.aPressed == false &&
                keyHandler.sPressed == false &&
                keyHandler.dPressed == false)
            isMoving=false;
    }

    public void dashCheck() {

        if (dashedCooldownRemaining > 0) {
            dashedCooldownRemaining--;
            return;
        }


        if (keyHandler.spacePressed && dashTimeRemaining >= 0)
            dashing = true;

        if (dashing) {
            speed = dashingSpeed;

//            switch (direction) {
//                case "up":
//                    coordY -= speed * 2;
//                    break;
//                case "down":
//                    coordY += speed * 2;
//                    break;
//                case "right":
//                    coordX += speed * 2;
//                    break;
//                case "left":
//                    coordX -= speed * 2;
//                    break;
//                default:
//                    coordX += speed;
//
//
//            }

            dashTimeRemaining--;

            if (dashTimeRemaining <= 0) {
                dashing = false;
                speed = speedCopy;
                dashedCooldownRemaining = dashedCooldownMilli;
                dashTimeRemaining = dashTimeMilli;
                justDashed = false;
            }
        }
    }
}
