package main.Menu.RenderIcons;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import main.Menu.MenuMainPanel;
import main.Menu.MenuOptionsPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import java.awt.Image;

public class IconsMenuRender {
    private static final int ICON_WIDTH = 200;
    private static final int ICON_HEIGHT = 50;
    private static final Color BUTTON_FOREGROUND_COLOR = new Color(170, 140, 177);
    private static final Font BUTTON_FONT = new Font("Monocraft", Font.BOLD, 20);

    MenuMainPanel mmp;
    MenuOptionsPanel mop;

    public ImageIcon resizeIcon(String path, int width, int height) {
        URL resource = getClass().getResource(path);
        if (resource == null) {
            System.out.println("Resource not found: " + path);
            return null;
        }
        ImageIcon icon = new ImageIcon(resource);
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        System.out.println("Icon resized: " + path);
        return new ImageIcon(resizedImg);
    }

    public IconsMenuRender(MenuMainPanel mmp, MenuOptionsPanel mop) {
        this.mmp = mmp;
        this.mop = mop;
    }

    public void SizeIconBotton() {
        if (mmp != null) {
            for (JButton button : new JButton[]{mmp.BStart, mmp.BExit, mmp.BOptions}) {
                configureButton(button);
            }
        }
        if (mop != null) {
            for (JButton button : new JButton[]{mop.BOptionsKeys, mop.BOptionsSounds, mop.BOptionsGraphics, mop.BOptionsBack}) {
                configureButton(button);
            }
        }
    }

    private void configureButton(JButton button) {
        button.setIcon(resizeIcon("/res/bottons/LightBlue/Normal.png", ICON_WIDTH, ICON_HEIGHT));
        button.setRolloverIcon(resizeIcon("/res/bottons/LightBlue/Hover.png", ICON_WIDTH, ICON_HEIGHT));
        button.setPressedIcon(resizeIcon("/res/bottons/LightBlue/Clicked.png", ICON_WIDTH, ICON_HEIGHT));
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
