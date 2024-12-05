package main.Menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import main.Main;

public class MenuPop {

    private JFrame frame;

    // Método para configurar a interface do usuário
    public MenuPop() {
        initializeUI();
    }

    @SuppressWarnings("unused")
    private void initializeUI() {
        
        // Configuração da janela principal
        frame = new JFrame("Exemplo de Pop-up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null); // Centraliza a janela principal

        // Set the icon image
        URL iconURL = Main.class.getResource("/res/icons/Logo.png");
        if (iconURL != null) {
            frame.setIconImage(new ImageIcon(iconURL).getImage());
        }
    }

    // Método que exibe o pop-up
    @SuppressWarnings("unused")
    public void showPopup() {
        // Botão "Entendi"
        JButton okButton = new JButton("Entendi");
        // Texto centralizado
        JLabel messageLabel = new JLabel("<html>TUTORIAL<br><br>Space - Pular<br>W - Pular<br>A - Esquerda<br>S - Descer<br>D - Direita</html>", JLabel.CENTER);

        // Painel configurado com GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Adiciona o texto ao painel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(messageLabel, gbc);

        // Adiciona o botão ao painel
        gbc.gridy = 1;
        gbc.insets = new java.awt.Insets(10, 0, 0, 0); // 10 pixels a cima da borda
        gbc.anchor = GridBagConstraints.SOUTH;
        panel.add(okButton, gbc);

        // Set the icon image
        URL iconURL = Main.class.getResource("/res/icons/Logo.png");
        JFrame popupFrame = new JFrame("Oblivion Souls Tutorial");
        if (iconURL != null) {
            popupFrame.setIconImage(new ImageIcon(iconURL).getImage());
        }

        // Configuração da janela pop-up
        popupFrame.setSize(600, 400);
        popupFrame.setLocationRelativeTo(null); // Centraliza o pop-up
        popupFrame.add(panel);
        popupFrame.setVisible(true);

        // Evento para fechar o pop-up ao clicar no botão
        okButton.addActionListener(e -> popupFrame.dispose());
    }
}