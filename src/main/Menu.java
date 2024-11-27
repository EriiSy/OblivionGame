package main;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.net.URL;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.CardLayout;

public class Menu extends JFrame {
    private JPanel panel = new JPanel(new CardLayout());
    WindowGame game = new WindowGame();
    MenuPanel mp = new MenuPanel(this);
    ActionsJFrame actions = new ActionsJFrame(mp);

    private void actionsButtons() {
        actions.Buttons();
        actions.SizeIconBotton();
        actions.ButtonsMouseListener();
        actions.ActionListenerButtons();
    }

    public Menu() {
        this.setSize(actions.screenWidth, actions.screenHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setTitle("Oblivion Souls");
        URL iconURL = Main.class.getResource("/res/icons/Logo.png");
        if (iconURL != null) {
            this.setIconImage(new ImageIcon(iconURL).getImage());
        }
    }

    public void startMenu() {
        this.actionsButtons();

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(actions.screenWidth, actions.screenHeight));

        URL backgroundURL = Main.class.getResource("/res/backgrounds/OblivionSoulsStart.jpg");
        if (backgroundURL != null) {
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
        } else {
            System.out.println("Background image not found: /res/backgrounds/OblivionSoulsStart.jpg");
        }

        // Adiciona os painéis ao CardLayout
        panel.add(mp.MenuMainPanel(new JPanel()), "MenuMain");
        panel.add(mp.MenuOptionsPanel(new JPanel()), "MenuOptions");

        panel.setBounds(0, 0, actions.screenWidth, actions.screenHeight);
        panel.setOpaque(false); // Certifica que o painel é transparente

        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER); // Adiciona o painel na camada superior

        this.add(layeredPane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu();
    }
}
