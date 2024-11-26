package main;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;

public class Menu extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    WindowGame game = new WindowGame();
    MenuPanel mp = new MenuPanel(this);
    ActionsJFrame actions = new ActionsJFrame(mp);

    private void actionsButtons() {
        actions.Buttons(panel);
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

        URL backgroundURL = Main.class.getResource("/res/backgrounds/windriseRose.png");
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
            System.out.println("Background image not found: /res/backgrounds/windriseRose.png");
        }

        panel.setBounds(0, 0, actions.screenWidth, actions.screenHeight);
        panel.setOpaque(false); 
        layeredPane.add(mp.MenuMainPanel(panel), JLayeredPane.PALETTE_LAYER);

        this.add(layeredPane);
        this.pack(); 
        this.setLocationRelativeTo(null); 
        this.setVisible(true); 
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
