package entity;

public class SpriteHandler {
    private int spriteCounter = 0;
    private int spriteNumber = 1;
    private int spriteCounterRun = 0;
    private int spriteNumberRun = 1;
    private int spriteCounterJump = 0;
    private int spriteNumberJump = 1;
    private int spriteCounterStop = 0;
    private int spriteNumberStop = 1;
    private int spriteCounterInteract = 0;
    private int spriteNumberInteract = 1;
    private int spriteCounterAttack = 0;
    private int spriteNumberAttack = 1;

    public void updateSpriteCounter(int maxCount, int maxNumber) {
        spriteCounter++;
        if (spriteCounter > maxCount) {
            spriteNumber = (spriteNumber % maxNumber) + 1;
            spriteCounter = 0;
        }
    }

    public void updateRunSpriteCounter(int maxCount, int maxNumber) {
        spriteCounterRun++;
        if (spriteCounterRun > maxCount) {
            spriteNumberRun = (spriteNumberRun % maxNumber) + 1;
            spriteCounterRun = 0;
        }
    }

    public void updateJumpSpriteCounter(int maxCount, int maxNumber) {
        spriteCounterJump++;
        if (spriteCounterJump > maxCount) {
            spriteNumberJump = (spriteNumberJump % maxNumber) + 1;
            spriteCounterJump = 0;
        }
    }

    public void updateInteractSpriteCounter(int maxCount, int maxNumber) {
        spriteCounterInteract++;
        if (spriteCounterInteract > maxCount) {
            spriteNumberInteract = (spriteNumberInteract % maxNumber) + 1;
            spriteCounterInteract = 0;
        }
    }

    public void updateAttackSpriteCounter(int maxCount, int maxNumber) {
        spriteCounterAttack++;
        if (spriteCounterAttack > maxCount) {
            spriteNumberAttack = (spriteNumberAttack % maxNumber) + 1;
            spriteCounterAttack = 0;
        }
    }

    public void updateStopSpriteCounter(int maxCount, int maxNumber) {
        spriteCounterStop++;
        if (spriteCounterStop > maxCount) {
            spriteNumberStop = (spriteNumberStop % maxNumber) + 1;
            spriteCounterStop = 0;
        }
    }

    public int getSpriteNumber() {
        return spriteNumber;
    }
    public int getSpriteNumberRun() {
        return spriteNumberRun;
    }

    public int getSpriteNumberJump() {
        return spriteNumberJump;
    }

    public int getSpriteNumberStop() {
        return spriteNumberStop;
    }

    public int getSpriteNumberInteract() {
        return spriteNumberInteract;
    }

    public int getSpriteNumberAttack() {
        return spriteNumberAttack;
    }


}
