package main.Menu;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import main.Main;
import main.WindowGame;
import main.Menu.RenderIcons.*;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.CardLayout;
import java.awt.Toolkit;

public class Menu extends JFrame {

    private JPanel panel = new JPanel(new CardLayout());
    WindowGame game = new WindowGame();
    MenuPanel mp = new MenuPanel();
    ActionsJFrame actions = new ActionsJFrame(panel, mp);

    IconsMenuRender size = new IconsMenuRender(mp.getMenuMainPanel(), mp.getMenuOptionsPanel(), 
    mp.getMenuCreditsPanel(), mp.getMenuPlayerPanel());

    public static final URL backgroundURL = Main.class.getResource("/res/backgrounds/OblivionSoulsStart.jpg");
    public static final Image backgroundImage = new ImageIcon(backgroundURL).getImage();
    public int screenHeight;
    public int screenWidth;

    public Menu() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenHeight = screenSize.height;
        this.screenWidth = screenSize.width;
        this.setSize(screenWidth, screenHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setTitle("Oblivion Souls");
        URL iconURL = Main.class.getResource("/res/icons/Logo.png");
        if (iconURL != null) {
            this.setIconImage(new ImageIcon(iconURL).getImage());
        }

         // Add JMenu to the frame
         JMenuBar menuBar = new JMenuBar();
         JMenu helpMenu = new JMenu("Ajuda");
         JMenuItem helpItem = new JMenuItem("Tutorial");
         helpItem.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 MenuPop menuPop = new MenuPop();
                 menuPop.showPopup();
             }
         });
 
         helpMenu.add(helpItem);
         menuBar.add(helpMenu);
         this.setJMenuBar(menuBar); 
    }

    public void startMenu() {
        actions.actionsButtons();

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(screenWidth, screenHeight));

        if (backgroundURL != null) {
            JLabel background = new JLabel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, screenWidth, screenHeight, this);
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
        panel.add(mp.getMenuPlayerPanel(), "MenuPlayer");
        panel.add(mp.getMenuOptionsPanel(), "MenuOptions");
        panel.add(mp.getMenuCreditsPanel(), "MenuCredits");
        panel.add(mp.getMenuOptionsSoundsPanel(), "MenuOptionsSounds");

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
