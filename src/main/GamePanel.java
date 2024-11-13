package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; // tamanho dos NPC'S, Personagens entre outros
    final int scale = 5;  // Será utilizado para aumentar o tamanho dos Sprites

    public final int tileSize = originalTileSize * scale; // tamanho real que será mostrado na tela
    final int maxScreenColumns = 16; // Quantidade de colunas a serem exibidas na tela
    final int maxScreenRow = 12; // Quantidade de linhas a serem exibidas na tela
    final int screenWidth = tileSize * maxScreenColumns; // tamanho da  largura da tela
    final int screenHeight = tileSize * maxScreenRow;  // tamanho da altura da tela

    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 5;

    public GamePanel(){ //Construtor
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // definir o tamanho do painel;
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true); //Todo o desenho. A partir deste componente será feito em um buffer de pintura fora da tela.
        this.addKeyListener(keyH); // para que o Painel reconheça os inputs das teclas
        this.setFocusable(true); // é usado para fazer com que o GamePanel receba de maneira "focada" o input da tecla/
    }

    public void startGameThread (){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; // 0.01666 segundos
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;


        while (gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }

            if ( timer >= 1000000000){
//                System.out.println("FPS " + drawCount);
                timer = 0;
            }
        }
    }

    public void update(){  // método de atualização de quadros dos personagens
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2  = (Graphics2D)g; // Permite um controle mais sofisticado da Geometria 2D

        player.draw(g2);

        g2.dispose(); // Descarta esse contexto gráfico e libere quaisquer recursos do sistema que ele esteja usando.
    }
}
