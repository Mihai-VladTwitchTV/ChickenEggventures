package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean wPressed,aPressed,sPressed,dPressed,spacePressed;

    @Override
    public void keyTyped(KeyEvent e) {
        ///do nothing

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            wPressed = true;
        }
        if(code == KeyEvent.VK_A){
            aPressed = true;
        }
        if(code == KeyEvent.VK_S){
            sPressed = true;
        }
        if(code == KeyEvent.VK_D){
            dPressed = true;
        }
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            spacePressed= true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            wPressed = false;
        }
        if(code == KeyEvent.VK_A){
            aPressed = false;
        }
        if(code == KeyEvent.VK_S){
            sPressed = false;
        }
        if(code == KeyEvent.VK_D){
            dPressed = false;
        }
        if(code == KeyEvent.VK_SPACE)
            spacePressed = false;

    }
}
