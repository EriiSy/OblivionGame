package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    long lastWPressTime = 0;
    long lastJPressTime = 0;
    public boolean running = false;

    public boolean upPressed, downPressed, leftPressed, rightPressed, doubleJumpPressed, 
    runRightPressed, runLeftPressed, KInteractPressed, JAttackPressed;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code =  e.getKeyCode(); // Retorna o código da tecla associada a tecla pressionada
        int subCode = e.getKeyCode();
        int subCode1 = e.getKeyCode();
        final long DOUBLE_JUMP_THRESHOLD = 500;

        long currentTime = System.currentTimeMillis();
        // Variável para armazenar o tempo da última pressão

        if (code == KeyEvent.VK_W) {
            upPressed = true;
            // Verifica se o tempo entre as pressões é menor que o limite (500ms)
            if (currentTime - lastWPressTime < DOUBLE_JUMP_THRESHOLD) {
                doubleJumpPressed = true;
            } lastWPressTime = currentTime;
        }if (code == KeyEvent.VK_S){
            downPressed = true;
        }if (code == KeyEvent.VK_A){
            leftPressed = true;
        }if (code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if (subCode == KeyEvent.VK_SHIFT ){
            runRightPressed = true;
        }
        if (subCode == KeyEvent.VK_SHIFT){
            runLeftPressed = true;
        }
        if (subCode1 == KeyEvent.VK_K){
            KInteractPressed = true;
        }
        if (subCode1 == KeyEvent.VK_J){
            JAttackPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        int subCode = e.getKeyCode();
        int subCode1 = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            upPressed = false;
            doubleJumpPressed = false;
        }if (code == KeyEvent.VK_S){
            downPressed = false;
        }if (code == KeyEvent.VK_A){
            leftPressed = false;
        }if (code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if (subCode == KeyEvent.VK_SHIFT){
            runRightPressed = false;
        }
        if (subCode == KeyEvent.VK_SHIFT){
            runLeftPressed= false;
        }
        if (subCode1 == KeyEvent.VK_K){
            KInteractPressed = false;
        }
        if (subCode == KeyEvent.VK_J){
            JAttackPressed = false;
           
        }
    }
}
