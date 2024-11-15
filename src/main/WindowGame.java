package main;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class WindowGame extends JFrame {
    
    GamePanel gamePanel = new GamePanel();
    JLayeredPane layeredPane = new JLayeredPane();

    public WindowGame() {
        this.setSize(gamePanel.screenWidth, gamePanel.screenHeight); // Define o tamanho da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para fechar o programa quando clicarmos em "x"
        this.setResizable(false); // Podemos redimensionar a janela
        this.setTitle("Oblivion Souls");
    
        URL iconURL = Main.class.getResource("/res/icons/Logo.png");
        if (iconURL != null) {
            this.setIconImage(new ImageIcon(iconURL).getImage());
        }
    }
    
    public void gameStopThread(){
        gamePanel.gameThread = null;
    }

    public void gameStartThread(){
        this.add(gamePanel);
        gamePanel.setBounds(0, 0, gamePanel.screenWidth, gamePanel.screenHeight); 
        this.pack(); // Como essa janela deve ser dimensionada, ela se ajustará ao tamanho e layout preferidos de seus subcomponentes.
        this.setLocationRelativeTo(null); // A janela será exibida no centro da tela. Sem especificar a localização
        this.setVisible(true); // Para poder ver a tela.
        gamePanel.startGameThread();
    }

    public static void main(String[] args) {
        WindowGame windowGame = new WindowGame();
        windowGame.gameStartThread();
    }

}
