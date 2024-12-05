package entity;

import main.GamePanel;

public class Collision {
    private GamePanel gp;

    public Collision(GamePanel gp) {
        this.gp = gp;
    }

    public boolean checkCollision(Entity entity1, Entity entity2) {
        int entity1Left = entity1.x;
        int entity1Right = entity1.x + gp.tileSizePlayer;
        int entity1Top = entity1.y;
        int entity1Bottom = entity1.y + gp.tileSizePlayer;

        int entity2Left = entity2.x;
        int entity2Right = entity2.x + gp.tileSizePlayer;
        int entity2Top = entity2.y;
        int entity2Bottom = entity2.y + gp.tileSizePlayer;

        return entity1Right >= entity2Left && entity1Left <= entity2Right &&
               entity1Bottom >= entity2Top && entity1Top <= entity2Bottom;
    }

    public boolean checkProximity(Entity entity1, Entity entity2, int proximity) {
        return Math.abs(entity1.x - entity2.x) <= proximity;
    }

    public boolean checkMapCollision(Entity entity) {
        int entityLeft = entity.x;
        int entityRight = entity.x + gp.tileSizePlayer;
        int entityTop = entity.y;
        int entityBottom = entity.y + gp.tileSizePlayer;

        return entityLeft < 0 || entityRight > gp.screenWidthPlayer ||
               entityTop < 0 || entityBottom > gp.screenHeightPlayer;
    }

    public void handleCollisions(Player player, NPC[] npcs) {
        for (NPC npc : npcs) {
            if (checkProximity(player, npc, 32)) {
                if (checkCollision(player, npc)) {
                    if (player.normalAttack.isAttacking()) {
                        // Empurra o NPC para trás quando atingido pelo soco do jogador
                        if (player.direction.equals("right")) {
                            npc.x -= 1;
                        } else if (player.direction.equals("left")) {
                            npc.x += 1;
                        }
                    } else {
                        // Impede o jogador de passar pelo NPC
                        if (player.x < npc.x) {
                            player.x = 100;
                            player.y = 900;
                        } else {
                            player.x = npc.x + gp.tileSizePlayer - 31;
                        }
                    }
                }
            }
        }

        if (checkMapCollision(player)) {
            // Lógica para quando o jogador colide com o mapa
            System.out.println("Jogador colidiu com o mapa!");
        }
    }
}
