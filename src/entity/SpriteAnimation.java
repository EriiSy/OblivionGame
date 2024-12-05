package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class SpriteAnimation extends JPanel {
    private BufferedImage spritesheet;   // O spritesheet carregado
    private int frameWidth = 64;         // Largura de cada frame
    private int frameHeight = 64;        // Altura de cada frame
    private int currentFrame = 0;        // Controla qual frame está sendo exibido
    private long lastTime = System.nanoTime();
    private final long interval = 200000000; // Intervalo entre mudanças de frame (200 ms)

    public SpriteAnimation() {
        try {
            // Carregar o spritesheet
            spritesheet = javax.imageio.ImageIO.read
            (getClass().getResource("/spritesheet.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Atualiza a animação a cada intervalo
        long now = System.nanoTime();
        if (now - lastTime >= interval) {
            currentFrame = (currentFrame + 1) % 4; // Atualiza o frame (supondo 4 frames)
            lastTime = now;
        }

        // Desenha o frame atual
        int x = currentFrame * frameWidth; // Posição x no spritesheet
        g.drawImage(spritesheet, 0, 0, frameWidth, frameHeight, x, 0, x + frameWidth, frameHeight, this);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        SpriteAnimation panel = new SpriteAnimation();
        frame.setTitle("Sprite Animation");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

        // Redesenha a cada 16ms (aproximadamente 60 FPS)
        new Timer(16, e -> panel.repaint()).start();
    }


}
