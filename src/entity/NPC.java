package entity;

import main.GamePanel;
import main.KeyHandler;

public class NPC extends Player {
    private boolean movingRight = false;

    public NPC(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        setDefaultValues();
    }

    @Override
    public void setDefaultValues() {

        x = gp.screenWidthPlayer - 1300; // Posiciona o NPC na direita do mapa
        y = size_Y;
        speed = 5;
        direction = "left";
    }

    @Override
    public void update() {
        if (movingRight) {
            x += speed;
            if (x >= gp.screenWidthPlayer - 1140) {
                movingRight = false;
                direction = "left";
            }
        } else {
            x -= speed;
            if (x <= 0) {
                movingRight = true;
                direction = "right";
            }
        }
        updateSpriteCounters();
    }
}
