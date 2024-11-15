package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    PlayerImages images;

    private Movement movement;
    private Attack normalAttack;
    private Interact interaction;
    private SpriteHandler spriteHandler;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        this.images = new PlayerImages();
        this.movement = new Movement();
        this.normalAttack = new Attack(18);
        this.interaction = new Interact(30);
        this.spriteHandler = new SpriteHandler();

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 790;
        speed = 3;
        direction = "down";
    }

    public void update() {
        handleDirection();
        handleJump();
        handleFall();
        handleMovement();
        handleRun();
        handleAttack();
        handleInteract();
        updateSpriteCounters();
    }

  private void handleDirection() {

    if (normalAttack.isAttacking()) {
        direction = movement.isMovingRight() ? "attackRight" : "attackLeft";
    } else if (interaction.isInteracting()) {
        direction = movement.isMovingRight() ? "InteractRight" : "InteractLeft";
    } else if (movement.isRunning()) {
        if (keyH.runRightPressed) {
            direction = "rightRun";
        } else if (keyH.runLeftPressed) {
            direction = "leftRun";
        }
    } else if (movement.isJumping() || movement.isFalling()) {
        direction = movement.isMovingRight() ? "right" : "left";
    } else if (movement.isMovingRight()) {
        direction = "stopRight";
    } else {
        direction = "stopLeft";
    }
}

    private void handleJump() {
    if (keyH.upPressed && !movement.isJumping() && movement.jumpCount < 1) {
        movement.startJump();
    } else if (keyH.doubleJumpPressed && movement.jumpCount == 1 && !movement.isFalling()) {
        movement.startJump();
        keyH.doubleJumpPressed = false;
    }
}

    private void handleAttack() {
        if (keyH.JAttackPressed && !normalAttack.isAttacking()) {
            normalAttack.startAttack();
            if (keyH.rightPressed) {
                direction = "attackRight";
            } else if (keyH.leftPressed) {
                direction = "attackLeft";
            } else {
                direction = movement.isMovingRight() ? "attackRight" : "attackLeft";
            }
        }

        normalAttack.update();
    }

    private void handleInteract() {
        if (keyH.KInteractPressed) {
            direction = movement.isMovingRight() ? "InteractRight" : "InteractLeft";
            interaction.startInteract();
        }
        interaction.update();
    }
    
    private void handleFall() {
        if (movement.isJumping() || movement.isFalling()) {
            y += movement.velocityY;
            movement.updateFall();

            if (y >= 790) {
                y = 790;
                movement.stopJump();
            } else if (movement.velocityY > 0) {
                direction = "down";
            }
        }
    }

    private void handleMovement() {
        if (keyH.downPressed) {
            y += speed;
        }
        
        if (keyH.rightPressed && !movement.isRunning()) {
            x += speed;
            movement.moveRight(speed);
            if (!normalAttack.isAttacking() && !interaction.isInteracting()) {
                direction = "right";
            }
        }else if (keyH.leftPressed && !movement.isRunning()) {
            x -= speed;
            movement.moveLeft(speed);
            if (!normalAttack.isAttacking() && !interaction.isInteracting()) {
                direction = "left";
            }
        }
    }
    

    private void handleRun() {
        if (keyH.runRightPressed && keyH.runLeftPressed && (keyH.rightPressed || keyH.leftPressed)) {
            movement.running = true;
            speed = 3;
            if (keyH.rightPressed) {
                x += speed;
            } else {
                x -= speed;
            }
        } else {
            movement.running = false;
        }
        
        if (keyH.runRightPressed && keyH.leftPressed && normalAttack.isAttacking())  {
            movement.stopRun();
            direction = "leftRun"; // Ajuste de direção para a animação de corrida
        }else if (keyH.runLeftPressed && keyH.rightPressed && normalAttack.isAttacking()) {
            movement.stopRun();
            direction = "rightRun"; // Ajuste de direção para a animação de corrida
        }	
        
        if (keyH.runRightPressed && keyH.leftPressed && interaction.isInteracting()){
            movement.stopRun();
            direction = "leftRun"; // Ajuste de direção para a animação de corrida
        }else if (keyH.runLeftPressed && keyH.rightPressed && interaction.isInteracting()) {
            movement.stopRun();
            direction = "rightRun"; // Ajuste de direção para a animação de corrida
        }


        if (keyH.runRightPressed && keyH.leftPressed ){
            movement.stopRun();
            direction = "leftRun"; // Ajuste de direção para a animação de corrida
        }else if (keyH.runLeftPressed && keyH.rightPressed) {
            movement.stopRun();
            direction = "rightRun"; // Ajuste de direção para a animação de corrida
        }

        if (keyH.runRightPressed && keyH.leftPressed && keyH.rightPressed){
            movement.stopRun();
            direction = "rightRun"; // Ajuste de direção para a animação de corrida
        }else if (keyH.runLeftPressed && keyH.rightPressed && keyH.leftPressed) {
            movement.stopRun();
            direction = "leftRun"; // Ajuste de direção para a animação de corrida
        }

        if (movement.isRunning() && !keyH.rightPressed && !keyH.leftPressed) {
            movement.stopRun();
            direction = movement.isMovingRight() ? "stopRight" : "stopLeft";
        }

        if (!keyH.JAttackPressed) { // Apenas ajuste a direção da corrida se não estiver atacando
            if (keyH.runRightPressed && keyH.rightPressed && movement.isRunning()) {
                direction = "rightRun";
                speed = 5;
                x += speed;
            }
            if (keyH.runLeftPressed && keyH.leftPressed && movement.isRunning()) {
                direction = "leftRun";
                speed = 5;
                x -= speed;
            }
        }
        if (!keyH.runRightPressed && !keyH.runLeftPressed) {
            speed = 3;
        }
    }
    

    private void updateSpriteCounters() {
        spriteHandler.updateSpriteCounter(5, 7); // Velocidade média para a animação padrão
        spriteHandler.updateRunSpriteCounter(3, 6); // Velocidade rápida para a animação de corrida
        spriteHandler.updateJumpSpriteCounter(5, 6); // Velocidade média para a animação de pulo
        spriteHandler.updateAttackSpriteCounter(5, 4); // Velocidade rápida para a animação de segundo ataque
        spriteHandler.updateInteractSpriteCounter(20, 4); // Velocidade rápida para a animação de ataque
        spriteHandler.updateStopSpriteCounter(25, 4); // Velocidade lenta para a animação de parada
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        BufferedImage effects = null;
    
        if (normalAttack.isAttacking()) {
            switch (direction) {
                case "attackRight":
                    image = getAttackImage();
                    break;
                case "attackLeft":
                    image = getAttackLeftImage();
                    break;
                default:
                    image = movement.isMovingRight() ? getAttackImage() : getAttackLeftImage();
                    break;
            }
        } else if (movement.isJumping() || movement.isFalling()) {
            switch (direction) {
                case "doubleJump":
                case "rightRun":
                case "right":
                    image = getJumpImage();
                    effects = getDoubleJumpEffect();
                    break;
                case "left":
                case "leftRun":
                    image = getLeftJumpImage();
                    effects = getDoubleJumpEffect();
                    break;
                default:
                    image = movement.isMovingRight() ? getJumpImage() : getLeftJumpImage();
                    break;
            }
        } else if (movement.isRunning() && normalAttack.isAttacking()) {
            if (movement.isMovingRight() && keyH.rightPressed) {
                image = getRightRunImage();
                effects = getAttackImage();
            } else {
                image = getLeftRunImage();
            }
        }else if (movement.isRunning()) {
            if (movement.isMovingRight()) {
                image = getRightRunImage();
            } else {
                image = getLeftRunImage();
            }

        } else if (interaction.isInteracting() && !normalAttack.isAttacking()) {
            switch (direction) {
                case "InteractRight":
                    image = getInteractImage();
                    break;
                case "InteractLeft":
                    image = getInteractLeftImage();
                    break;
                default:
                    image = movement.isMovingRight() ? getInteractImage() : getInteractLeftImage();
                    break;
            }
        } else {
            image = getDefaultImage();
        }
    
        g2.drawImage(image, x, y, gp.tileSizePlayer, gp.tileSizePlayer, null);
        g2.drawImage(effects, x, y, gp.tileSizePlayer, gp.tileSizePlayer, null);
    }
    


    private BufferedImage getJumpImage() {
        return switch (spriteHandler.getSpriteNumberJump()) {
            case 1 -> images.up;
            case 2 -> images.up1;
            case 3 -> images.up2;
            case 4 -> images.up3;
            case 5 -> images.up4;
            case 6 -> images.up5;
            case 7 -> images.up6;
            default -> images.up7;
        };
    }

    private BufferedImage getLeftJumpImage() {
        return switch (spriteHandler.getSpriteNumberJump()) {
            case 1 -> images.leftJump1;
            case 2 -> images.leftJump2;
            case 3 -> images.leftJump3;
            case 4 -> images.leftJump4;
            case 5 -> images.leftJump5;
            case 6 -> images.leftJump6;
            default -> images.leftJump7;
        };
    }

    private BufferedImage getDoubleJumpEffect() {
        return switch (spriteHandler.getSpriteNumberJump()) {
            case 1 -> images.DJump1;
            case 2 -> images.DJump2;
            case 3 -> images.DJump3;
            case 4 -> images.DJump4;
            case 5 -> images.DJump5;
            default -> images.DJump6;
        };
    }

    private BufferedImage getDefaultImage() {
        return switch (direction) {
            case "stopRight" -> getStopImage();
            case "stopLeft" -> getLeftStopImage();
            case "down" -> images.down1;
            case "left" -> getLeftImage();
            case "right" -> getRightImage();
            case "rightRun" -> getRightRunImage();
            case "leftRun" -> getLeftRunImage();
            case "InteractRight" -> getInteractImage();
            case "InteractLeft" -> getInteractLeftImage();
            case "attackRight" -> getAttackImage();
            case "attackLeft" -> getAttackLeftImage();
            default -> null;
        };
    }

    private BufferedImage getStopImage() {
        return switch (spriteHandler.getSpriteNumberStop()) {
            case 1 -> images.stop;
            case 2 -> images.stop1;
            case 3 -> images.stop2;
            default -> images.stop3;
        };
    }

    private BufferedImage getLeftStopImage() {
        return switch (spriteHandler.getSpriteNumberStop()) {
            case 1 -> images.leftStop;
            case 2 -> images.leftStop1;
            case 3 -> images.leftStop2;
            default -> images.leftStop3;
        };
    }

    private BufferedImage getLeftImage() {
        return switch (spriteHandler.getSpriteNumber()) {
            case 1 -> images.left1;
            case 2 -> images.left1;
            case 3 -> images.left2;
            case 4 -> images.left3;
            case 5 -> images.left4;
            default -> images.left5;
        };
    }

    private BufferedImage getRightImage() {
        return switch (spriteHandler.getSpriteNumber()) {
            case 1 -> images.right;
            case 2 -> images.right1;
            case 3 -> images.right2;
            case 4 -> images.right3;
            case 5 -> images.right4;
            default -> images.right5;
        };
    }

    private BufferedImage getRightRunImage() {
        return switch (spriteHandler.getSpriteNumberRun()) {
            case 1 -> images.rightRun;
            case 2 -> images.rightRun1;
            case 3 -> images.rightRun2;
            case 4 -> images.rightRun3;
            case 5 -> images.rightRun4;
            default -> images.rightRun5;
        };
    }

    private BufferedImage getLeftRunImage() {
        return switch (spriteHandler.getSpriteNumberRun()) {
            case 1 -> images.leftRun;
            case 2 -> images.leftRun1;
            case 3 -> images.leftRun2;
            case 4 -> images.leftRun3;
            case 5 -> images.leftRun4;
            default -> images.leftRun5;
        };
    }

    private BufferedImage getInteractImage() {
        return switch (spriteHandler.getSpriteNumberInteract()) {
            case 1 -> images.interact1;
            case 2 -> images.interact2;
            case 3 -> images.interact3;
            default -> images.interact4;
          
        };
    }

    private BufferedImage getInteractLeftImage() {
        return switch (spriteHandler.getSpriteNumberInteract()) {
            case 1 -> images.interactLeft1;
            case 2 -> images.interactLeft2;
            case 3 -> images.interactLeft3;
            default -> images.interactLeft4;
        };
    }

    private BufferedImage getAttackImage() {
        return switch (spriteHandler.getSpriteNumberAttack()) {
            case 1 -> images.attack1;
            case 2 -> images.attack2;
            case 3 -> images.attack3;
            default -> images.attack4;
        };
    }

    private BufferedImage getAttackLeftImage() {
        return switch (spriteHandler.getSpriteNumberAttack()) {
            case 1 -> images.attackLeft1;
            case 2 -> images.attackLeft2;
            case 3 -> images.attackLeft3;
            default -> images.attackLeft4;
        };
    }
}
