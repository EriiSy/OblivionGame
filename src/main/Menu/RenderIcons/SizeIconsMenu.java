package main.Menu.RenderIcons;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import main.Menu.MenuMainPanel;
import main.Menu.MenuOptionsPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class SizeIconsMenu {
    private static final int ICON_WIDTH = 200;
    private static final int ICON_HEIGHT = 50;
    private static final Color BUTTON_FOREGROUND_COLOR = new Color(170, 140, 177);
    private static final Font BUTTON_FONT = new Font("Monocraft", Font.BOLD, 20);

    MenuMainPanel mmp;
    MenuOptionsPanel mop;
    resizeIcons ri = new resizeIcons();

    public SizeIconsMenu(MenuMainPanel mmp, MenuOptionsPanel mop) {
        this.mmp = mmp;
        this.mop = mop;
    }

    public void SizeIconBottonMainMenuPanel() {
        for (JButton button : new JButton[]{mmp.BStart, mmp.BExit, mmp.BOptions}) {
            button.setIcon(ri.resizeIcon("/res/bottons/LightBlue/Normal.png", ICON_WIDTH, ICON_HEIGHT));
            button.setRolloverIcon(ri.resizeIcon("/res/bottons/LightBlue/Hover.png", ICON_WIDTH, ICON_HEIGHT));
            button.setPressedIcon(ri.resizeIcon("/res/bottons/LightBlue/Clicked.png", ICON_WIDTH, ICON_HEIGHT));
            button.setPreferredSize(new Dimension(ICON_WIDTH, ICON_HEIGHT));
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            button.setForeground(BUTTON_FOREGROUND_COLOR);
            button.setFont(BUTTON_FONT);
            button.setVerticalAlignment(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.CENTER);
        }
    }

    public void SizeIconBottonMenuOptionsPanel() {
        for (JButton button : new JButton[]{mop.BOptionsKeys, mop.BOptionsSounds, mop.BOptionsGraphics, mop.BOptionsBack}) {
            button.setIcon(ri.resizeIcon("/res/bottons/LightBlue/Normal.png", ICON_WIDTH, ICON_HEIGHT));
            button.setRolloverIcon(ri.resizeIcon("/res/bottons/LightBlue/Hover.png", ICON_WIDTH, ICON_HEIGHT));
            button.setPressedIcon(ri.resizeIcon("/res/bottons/LightBlue/Clicked.png", ICON_WIDTH, ICON_HEIGHT));
            button.setPreferredSize(new Dimension(ICON_WIDTH, ICON_HEIGHT));
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            button.setForeground(BUTTON_FOREGROUND_COLOR);
            button.setFont(BUTTON_FONT);
            button.setVerticalAlignment(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.CENTER);
        }
    }
}
