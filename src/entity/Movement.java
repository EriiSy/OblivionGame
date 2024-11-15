package entity;

public class Movement {
    private boolean jumping = false;
    boolean running = false;
    private boolean falling = false;
    private boolean isMovingRight = true;
    double velocityY = 0;
    private final double gravity = 0.7;
    private final double jumpStrength = 12;
    double jumpCount = 0;

    public boolean isJumping() {
        return jumping;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isFalling() {
        return falling;
    }

    public boolean isMovingRight() {
        return isMovingRight;
    }

    public void startJump() {
        jumping = true;
        velocityY = -jumpStrength;
        jumpCount++;
    }

    public void startFall() {
        falling = true;
    }

    public void stopJump() {
        jumping = false;
        falling = false;
        velocityY = 0;
        jumpCount = 0;
    }

    public void updateFall() {
        if (jumping || falling) {
            velocityY += gravity;
            if (velocityY > 0) {
                startFall();
            }
        }
    }

    public void moveRight(int speed) {
        isMovingRight = true;
        // logic to move right
    }

    public void moveLeft(int speed) {
        isMovingRight = false;
        // logic to move left
    }

    public void runRight(int speed) {
        running = true;
        moveRight(speed);
    }

    public void runLeft(int speed) {
        running = true;
        moveLeft(speed);
    }

    public void stopRun() {
        running = false;
    }
}
