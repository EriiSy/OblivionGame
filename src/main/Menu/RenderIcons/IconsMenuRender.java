package main.Menu.RenderIcons;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import main.Menu.MenuMainPanel;
import main.Menu.MenuOptionsPanel;
import main.Menu.MenuPlayer.MenuPlayerPanel;
import main.Menu.MenuCreditsPanel;
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
    MenuCreditsPanel mcp;
    MenuPlayerPanel playerM; 

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

    public IconsMenuRender(MenuMainPanel mmp, MenuOptionsPanel mop, MenuCreditsPanel mcp, MenuPlayerPanel playerM) {
        this.mmp = mmp;
        this.mop = mop;
        this.mcp = mcp;
        this.playerM = playerM;
    }

    public void SizeIconBotton() {
        if (mmp != null) {
            for (JButton button : new JButton[]{mmp.BStart, mmp.BNew,mmp.BCredits,mmp.BExit,mmp.BOptions}) {
                configureButton(button);
            }
        }
        if (mop != null) {
            for (JButton button : new JButton[]{mop.BOptionsKeys, mop.BOptionsSounds, mop.BOptionsGraphics, 
                mop.BOptionsBack}) {
                configureButton(button);
            }
        }
    }

    public void SizeIconTextField(){
        if (playerM != null){
            for (JTextField textField : new JTextField[]{playerM.tfNick}){
                configureTextField(textField);
            }
        }
          
    }
    public void SizeIconLabel(){
        if (playerM != null){
            for (JLabel label : new JLabel[]{playerM.lbNick}){
                configureLabel(label);
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

    private void configureTextField(JTextField textField) {
        textField.setFont(BUTTON_FONT);
        textField.setPreferredSize(new Dimension(200, 30)); // Ajuste o tamanho do JTextField
        textField.setMinimumSize(new Dimension(200, 30));
        textField.setMaximumSize(new Dimension(200, 30));
        textField.setForeground(BUTTON_FOREGROUND_COLOR);
        textField.setOpaque(false); // Certifique-se de que o campo de texto seja transparente
    }

    private void configureLabel(JLabel label) {
        label.setFont(BUTTON_FONT);
        label.setPreferredSize(new Dimension(50, 30)); // Ajuste o tamanho do JLabel
        label.setForeground(BUTTON_FOREGROUND_COLOR);
        label.setBorder(null);
        label.setOpaque(false); // Certifique-se de que o label seja transparente
    }
}
