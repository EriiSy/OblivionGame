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

public class ActionsJFrame extends JFrame implements ActionListener {
    private JPanel panel;
    WindowGame game = new WindowGame();
    MenuPanel mp;
    IconsMenuRender size;

    public ActionsJFrame(JPanel panel, MenuPanel mp) {
        this.panel = panel; // Certifica-se de que é o painel correto
        this.mp = mp;
        this.size = new IconsMenuRender(mp.getMenuMainPanel(), mp.getMenuOptionsPanel());
    }
    

    protected void ButtonsMouseListener() {
        for (final JButton button : new JButton[]{
            mp.getMenuMainPanel().BStart, mp.getMenuMainPanel().BExit, mp.getMenuMainPanel().BOptions,
            mp.getMenuOptionsPanel().BOptionsKeys, mp.getMenuOptionsPanel().BOptionsSounds, mp.getMenuOptionsPanel().BOptionsGraphics, mp.getMenuOptionsPanel().BOptionsBack}) {
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
    }

    protected void ActionListenerButtons() {
        for (final JButton button : new JButton[]{
            mp.getMenuMainPanel().BStart, mp.getMenuMainPanel().BExit, mp.getMenuMainPanel().BOptions,
            mp.getMenuOptionsPanel().BOptionsKeys, mp.getMenuOptionsPanel().BOptionsSounds, 
            mp.getMenuOptionsPanel().BOptionsGraphics, mp.getMenuOptionsPanel().BOptionsBack}) {
            button.addActionListener(this);
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
        } else if (e.getSource() == mp.getMenuMainPanel().BExit) {
            System.exit(0);
        } else if (e.getSource() == mp.getMenuMainPanel().BOptions) {
            System.out.println("Botão clicado: " + ((JButton)e.getSource()).getText());
            cl.show(panel, "MenuOptions");
            panel.revalidate();
            panel.repaint();

        } else if (e.getSource() == mp.getMenuOptionsPanel().BOptionsBack) {
            cl.show(panel, "MenuMain");
        }
    }
}
