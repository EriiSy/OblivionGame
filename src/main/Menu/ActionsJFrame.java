package main.Menu;

import javax.swing.*;
import main.WindowGame;
import main.Menu.RenderIcons.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

public class ActionsJFrame extends JFrame implements ActionListener {
    private JPanel panel;
    WindowGame game = new WindowGame();
    MenuPanel mp;
    IconsMenuRender size;
    MenuCreditsPanel creditsPanel;

    public ActionsJFrame(JPanel panel, MenuPanel mp) {
        this.panel = panel; // Certifica-se de que é o painel correto
        this.mp = mp;
        this.size = new IconsMenuRender(mp.getMenuMainPanel(), mp.getMenuOptionsPanel(),
        mp.getMenuCreditsPanel(), mp.getMenuPlayerPanel(), mp.getMenuOptionsSoundsPanel(),
        mp.getMenuOptionsGraphicsPanel(), mp.getMenuOptionsKeyPanel());
        this.creditsPanel = new MenuCreditsPanel(); // Inicializa o painel de créditos

        // Acredito que sirva para redimensionar a qualquer tela adaptavelmente.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth, screenHeight);
    }

    protected void ButtonsMouseListener() {
        for (final JButton button : new JButton[]{
            mp.getMenuMainPanel().BStart, mp.getMenuMainPanel().BNew, mp.getMenuMainPanel().BExit, 
            mp.getMenuOptionsGraphicsPanel().BBack, mp.getMenuOptionsKeyPanel().BBack,
            mp.getMenuPlayerPanel().BStart, mp.getMenuPlayerPanel().BBack, mp.getMenuOptionsSoundsPanel().BBack,
            mp.getMenuMainPanel().BOptions, mp.getMenuMainPanel().BCredits, mp.getMenuOptionsPanel().BOptionsKeys, 
            mp.getMenuOptionsPanel().BOptionsSounds, mp.getMenuOptionsPanel().BOptionsGraphics, 
            mp.getMenuOptionsPanel().BOptionsBack, creditsPanel.getBackButton()}) {
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setForeground(Color.GRAY);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setForeground(new Color(170, 140, 177));
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    button.setIcon(size.resizeIcon("/res/bottons/LightBlue/Clicked.png", 200, 50));
                    button.setIconTextGap(-10);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    button.setIcon(size.resizeIcon("/res/bottons/LightBlue/Normal.png", 200, 50));
                    button.setIconTextGap(0);
                }
            });
        }

        for (final JCheckBox checkBox : new JCheckBox[]{
            mp.getMenuOptionsGraphicsPanel().fullScreenCheckBox, 
            mp.getMenuOptionsGraphicsPanel().vSyncCheckBox}) {
            checkBox.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    checkBox.setForeground(Color.GRAY);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    checkBox.setForeground(new Color(170, 140, 177));
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    // No need to change icon here, it will be handled by the action listener
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // No need to change icon here, it will be handled by the action listener
                }
            });
        }
    }

    protected void ActionListenerButtons() {
        for (final JButton button : new JButton[]{
            mp.getMenuMainPanel().BStart, mp.getMenuMainPanel().BNew, mp.getMenuMainPanel().BExit, 
            mp.getMenuOptionsGraphicsPanel().BBack, mp.getMenuOptionsKeyPanel().BBack,
            mp.getMenuMainPanel().BOptions, mp.getMenuPlayerPanel().BStart, mp.getMenuPlayerPanel().BBack,
            mp.getMenuOptionsPanel().BOptionsKeys, mp.getMenuMainPanel().BCredits, mp.getMenuOptionsSoundsPanel().BBack,
            mp.getMenuOptionsPanel().BOptionsSounds, mp.getMenuOptionsPanel().BOptionsGraphics, 
            mp.getMenuOptionsPanel().BOptionsBack, mp.getMenuCreditsPanel().getBackButton()}) {
            button.addActionListener(this);
        }

        for(final JCheckBox checkBox : new JCheckBox[]{
            mp.getMenuOptionsGraphicsPanel().fullScreenCheckBox, mp.getMenuOptionsGraphicsPanel().vSyncCheckBox}) {
            checkBox.addActionListener(this);
        }
    }

    protected void actionsButtons() {
        ButtonsMouseListener();
        ActionListenerButtons();
        System.out.println("Actions buttons initialized");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) panel.getLayout();
        
        if (e.getSource() == mp.getMenuMainPanel().BStart) {
            game.gameStartThread();

        } if (e.getSource() == mp.getMenuMainPanel().BNew){
            cl.show(panel, "MenuPlayer");
            panel.revalidate();
            panel.repaint();
        } if (e.getSource() == mp.getMenuMainPanel().BExit) {
            System.exit(0);
        } if (e.getSource() == mp.getMenuMainPanel().BOptions) {
            System.out.println("Botão clicado: " + ((JButton)e.getSource()).getText());
            cl.show(panel, "MenuOptions");
            panel.revalidate();
            panel.repaint();
        } if (e.getSource() == mp.getMenuMainPanel().BCredits){
            cl.show(panel, "MenuCredits");
            panel.revalidate();
            panel.repaint();
        } if (e.getSource() == mp.getMenuOptionsPanel().BOptionsBack) {
            cl.show(panel, "MenuMain");
        } if (e.getSource() == mp.getMenuCreditsPanel().getBackButton()) {
            cl.show(panel, "MenuMain");
        } if (e.getSource() == mp.getMenuOptionsPanel().BOptionsSounds) {
            cl.show(panel, "MenuOptionsSounds");
        } if (e.getSource() == mp.getMenuOptionsPanel().BOptionsGraphics) {
            cl.show(panel, "MenuOptionsGraphics");
            System.out.println("Botão clicado: " + ((JButton)e.getSource()).getText());
        } if (e.getSource() == mp.getMenuOptionsPanel().BOptionsKeys) {
            cl.show(panel, "MenuOptionsKeys");
            System.out.println("Botão clicado: " + ((JButton)e.getSource()).getText());
        }if (e.getSource() == mp.getMenuPlayerPanel().BBack) {
            cl.show(panel, "MenuMain");
            panel.revalidate(); 
            panel.repaint();
        } if (e.getSource() == mp.getMenuPlayerPanel().BStart) {
            game.gameStartThread();
        } if (e.getSource() == mp.getMenuOptionsSoundsPanel().BBack) {
            cl.show(panel, "MenuOptions");
        } if (e.getSource() == mp.getMenuOptionsKeyPanel().BBack) {
            cl.show(panel, "MenuOptions");
        } if (e.getSource() == mp.getMenuOptionsGraphicsPanel().BBack) {
            cl.show(panel, "MenuOptions");
        } if (e.getSource() == mp.getMenuOptionsGraphicsPanel().fullScreenCheckBox){
            panel.revalidate();
            panel.repaint();
        } if (e.getSource() == mp.getMenuOptionsGraphicsPanel().vSyncCheckBox){
            panel.revalidate();
            panel.repaint();
        }
    }
}