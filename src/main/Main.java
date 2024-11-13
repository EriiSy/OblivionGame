package main;

import javax.swing.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para fechar o programa quando clicarmos em "x"
        window.setResizable(false); // Podemos redimensionar a janela
        window.setTitle("Oblivion Souls");
        URL iconURL = Main.class.getResource("/res/icons/Logo.png");
        //iconURL is null when not found
        ImageIcon icon = new ImageIcon(iconURL);
        window.setIconImage(icon.getImage());


        GamePanel gamePanel = new GamePanel(); //Criando o painel
        window.add(gamePanel);

        window.pack(); // Como essa janela deve ser dimensionada, ela se ajustará ao tamanho e layout preferidos de seus subcomponentes.

        window.setLocationRelativeTo(null); // A janela será exibida no centro da tela. Sem especificar a localização
        window.setVisible(true); // Para poder ver a tela.

        gamePanel.startGameThread();

    }
}

