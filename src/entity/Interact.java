package entity;

public class Interact {
    private boolean interacting = false;
    private int interactCounter = 0;
    private final int interactDuration;

    public Interact(int interactDuration) {
        this.interactDuration = interactDuration;
    }

    public boolean isInteracting() {
        return interacting;
    }

    public void stopInteract() {
        interacting = false;
        interactCounter = 0;
    }

    public void startInteract() {
        interacting = true;
        interactCounter = 0;
    }

    public void update() {
        if (interacting) {
            interactCounter++;
            if (interactCounter > interactDuration) {
                interacting = false;
                interactCounter = 0;
            }
        }
    }
}
