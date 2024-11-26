package main;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.net.URL;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;

public class Menu extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    WindowGame game = new WindowGame();
    ActionsJFrame actions = new ActionsJFrame();
    

    private void actionsButtons() {
        actions.Buttons(panel);
    }

    private JPanel MenuPanel(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, actions.screenHeight / 2 - 50));
        panel.add(Box.createVerticalGlue()); // Espaço flexível acima
        panel.add(Box.createVerticalGlue()); // Espaço flexível acima
        panel.add(actions.BStart);
        panel.add(Box.createVerticalStrut(10)); // Espaço fixo entre os botões
        panel.add(actions.BExit);
        panel.add(Box.createVerticalStrut(10)); // Espaço fixo entre os botões
        panel.add(actions.BOptions);
        panel.add(Box.createVerticalGlue()); // Espaço flexível abaixo
        return panel;
    }

    private JPanel MenuOptionsPanel(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, actions.screenHeight / 2 - 50));
        panel.setOpaque(false); // Torna o painel transparente
        panel.add(Box.createVerticalGlue()); // Espaço flexível acima
        panel.add(actions.BOptionsGraphics);
        panel.add(Box.createVerticalStrut(10)); // Espaço fixo entre os botões
        panel.add(actions.BOptionsSound);
        panel.add(Box.createVerticalStrut(10)); // Espaço fixo entre os botões
        panel.add(actions.BOptionsKeys);
        panel.add(Box.createVerticalStrut(10)); // Espaço fixo entre os botões
        panel.add(actions.BOptionsBack);
        panel.add(Box.createVerticalGlue()); // Espaço flexível abaixo
        return panel;
    }

    public Menu() {
        this.setSize(actions.screenWidth, actions.screenHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para fechar o programa quando clicarmos em "x"
        this.setResizable(true);
        this.setTitle("Oblivion Souls");
        URL iconURL = Main.class.getResource("/res/icons/Logo.png");
        if (iconURL != null) {
            this.setIconImage(new ImageIcon(iconURL).getImage());
        }
    }

    public void startMenu() {
        this.actionsButtons();

        // Cria um JLayeredPane para organizar os componentes
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(actions.screenWidth, actions.screenHeight));

        // Adiciona a imagem de fundo
        URL backgroundURL = Main.class.getResource("/res/backgrounds/windriseRose.png");
        ImageIcon backgroundImageIcon = new ImageIcon(backgroundURL);
        Image backgroundImage = backgroundImageIcon.getImage();
        JLabel background = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        background.setBounds(0, 0, actions.screenWidth, actions.screenHeight);
        layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);

        // Configura o painel com os botões
        panel.setBounds(0, 0, actions.screenWidth, actions.screenHeight);
        panel.setOpaque(false); // Torna o painel transparente
        layeredPane.add(MenuPanel(panel), JLayeredPane.PALETTE_LAYER);

        // Adiciona o JLayeredPane ao JFrame
        this.add(layeredPane);
        this.pack(); // Ajusta o tamanho da janela aos componentes
        this.setLocationRelativeTo(null); // A janela será exibida no centro da tela
        this.setVisible(true); // Para poder ver a tela
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == actions.BStart) {
            game.gameStartThread();
        }
        if (e.getSource() == actions.BExit) {
            game.gameStopThread();
            System.exit(0);
        }
        if (e.getSource() == actions.BOptions) {
            panel.removeAll();
            MenuOptionsPanel(panel);
            panel.revalidate();
            panel.repaint();
        }

        if (e.getSource() == actions.BOptionsBack) {
            panel.removeAll();
            MenuPanel(panel);
            panel.revalidate();
            panel.repaint();
        }
    }
}
