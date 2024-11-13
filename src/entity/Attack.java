package entity;

public class Attack {
    private boolean attacking = false;
    private int attackCounter = 0;
    private final int attackDuration;

    public Attack(int attackDuration) {
        this.attackDuration = attackDuration;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void stopAttack() {
        attacking = false;
        attackCounter = 0;
    }

    public void startAttack() {
        attacking = true;
        attackCounter = 0;
    }

    public void update() {
        if (attacking) {
            attackCounter++;
            if (attackCounter > attackDuration) {
                attacking = false;
                attackCounter = 0;
            }
        }
    }
}
