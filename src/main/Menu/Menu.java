package main.Menu;

import javax.swing.JPanel;
import main.Main;
import main.WindowGame;
import main.Menu.RenderIcons.*;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.net.URL;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.CardLayout;

public class Menu extends JFrame {
    final int screenWidth = 1920;
    final int screenHeight = 1080;
    private JPanel panel = new JPanel(new CardLayout());
    WindowGame game = new WindowGame();
    MenuPanel mp = new MenuPanel();
    ActionsJFrame actions = new ActionsJFrame(panel, mp);

    IconsMenuRender size = new IconsMenuRender(mp.getMenuMainPanel(), mp.getMenuOptionsPanel());

    public Menu() {
        this.setSize(screenWidth, screenHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setTitle("Oblivion Souls");
        URL iconURL = Main.class.getResource("/res/icons/Logo.png");
        if (iconURL != null) {
            this.setIconImage(new ImageIcon(iconURL).getImage());
        }
    }

    public void startMenu() {
        actions.actionsButtons();

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(screenWidth, screenHeight));

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
            background.setBounds(0, 0, screenWidth, screenHeight);
            layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);
        } else {
            System.out.println("Background image not found: /res/backgrounds/OblivionSoulsStart.jpg");
        }

        panel.setBounds(0, 0, screenWidth, screenHeight);
        panel.setOpaque(false); // Certifica que o painel é transparente

        panel.add(mp.getMenuMainPanel(), "MenuMain");
        panel.add(mp.getMenuOptionsPanel(), "MenuOptions");

        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER); // Adiciona o painel na camada superior

        this.add(layeredPane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        System.out.println("Menu started successfully");
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu();
    }
}
