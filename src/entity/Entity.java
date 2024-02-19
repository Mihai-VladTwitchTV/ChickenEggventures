package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int coordX,coordY;
    public int speed;

    public BufferedImage up1,up2,down1,down2,right1,right2,left1,left2;
    public String direction;
    public boolean firstAnim = true;
    public int spriteCounter=0;

    public boolean isMoving = false;
}
