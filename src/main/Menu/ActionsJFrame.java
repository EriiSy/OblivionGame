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
    private JPanel panel = new JPanel(new CardLayout());
    WindowGame game = new WindowGame();
    MenuPanel mp;
    MenuMainPanel mmp = new MenuMainPanel();
    MenuOptionsPanel mop = new MenuOptionsPanel();
    resizeIcons resize = new resizeIcons();
    SizeIconsMenu size = new SizeIconsMenu(mmp, mop);

    public ActionsJFrame(MenuPanel mp) {
        this.mp = mp;
    }

    protected void ButtonsMouseListenerMenuMainPanel() {
        for (final JButton button : new JButton[]{mmp.BStart, mmp.BExit, mmp.BOptions}) {
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
                    button.setIcon(resize.resizeIcon("/res/bottons/LightBlue/Clicked.png", 200, 50));
                    button.setIconTextGap(-10);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    button.setIcon(resize.resizeIcon("/res/bottons/LightBlue/Normal.png", 200, 50));
                    button.setIconTextGap(0);
                }
            });
        }
    }

    protected void ButtonsMouseListenerMenuOptionsPanel() {
        for (JButton button : new JButton[]{mop.BOptionsKeys, mop.BOptionsSounds, mop.BOptionsGraphics, mop.BOptionsBack}) {
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
                    button.setIcon(resize.resizeIcon("/res/bottons/LightBlue/Clicked.png", 200, 50));
                    button.setIconTextGap(-10);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    button.setIcon(resize.resizeIcon("/res/bottons/LightBlue/Normal.png", 200, 50));
                    button.setIconTextGap(0);
                }
            });
        }
    }

    protected void ActionListenerButtons() {
        for (final JButton button : new JButton[]{mmp.BStart, mmp.BExit, mmp.BOptions, mop.BOptionsKeys, mop.BOptionsSounds, mop.BOptionsGraphics, mop.BOptionsBack}) {
            button.addActionListener(this);
        }
    }

    protected void actionsButtons() {
        mp.MenuMainPanel(panel);
        size.SizeIconBottonMainMenuPanel();
        ButtonsMouseListenerMenuMainPanel();
        ActionListenerButtons();
        System.out.println("Actions buttons initialized");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) (panel.getLayout());
        if (e.getSource() == mmp.BStart) {
            game.gameStartThread();
        } else if (e.getSource() == mmp.BExit) {
            System.exit(0);
        } else if (e.getSource() == mmp.BOptions) {
            cl.show(panel, "MenuOptions");
        } else if (e.getSource() == mop.BOptionsBack) {
            cl.show(panel, "MenuMain");
        }
    }
}
