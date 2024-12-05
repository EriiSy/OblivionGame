package main.Menu.RenderIcons;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import main.Menu.MenuMainPanel;
import main.Menu.MenuOptionsPanel;
import main.Menu.MenuOptions.MenuOptionsGraphicsPanel;
import main.Menu.MenuOptions.MenuOptionsKeyPanel;
import main.Menu.MenuOptions.MenuOptionsSoundsPanel;
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
    private static final Color LABEL_FOREGROUND_COLOR = new Color(Color.white.getRGB());
    private static final Font BUTTON_FONT = new Font("Monocraft", Font.BOLD, 20);
    private static final Font LABEL_FONT = new Font("Monocraft", Font.BOLD, 40);
 
    MenuMainPanel mmp;
    MenuOptionsPanel mop;
    MenuCreditsPanel mcp;
    MenuOptionsSoundsPanel mosp;
    MenuOptionsKeyPanel mokp;
    MenuOptionsGraphicsPanel mogp;
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

    public IconsMenuRender(MenuMainPanel mmp, MenuOptionsPanel mop,MenuCreditsPanel mcp, MenuPlayerPanel playerM
    , MenuOptionsSoundsPanel mosp, MenuOptionsGraphicsPanel mogp, MenuOptionsKeyPanel mokp) {
        this.mmp = mmp;
        this.mop = mop;
        this.mcp = mcp;
        this.playerM = playerM;
        this.mosp = mosp;
        this.mogp = mogp;
        this.mokp = mokp;
    }


    public void SizeIconCheckBox(){
        if (mogp != null){
            for (JCheckBox checkBox : new JCheckBox[]{mogp.fullScreenCheckBox, mogp.vSyncCheckBox}) {
                configureCheckBox(checkBox);
            }
        }
    }
    public void SizeIconButton() {
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

        if (mosp != null){
            configureButton(mosp.BBack);
        }
        if (mokp != null){
            configureButton(mokp.BBack);
        }
        if (mogp != null){
            configureButton(mogp.BBack);
        }

        if (playerM != null) {
            for (JButton button : new JButton[]{playerM.BBack, playerM.BStart}) {
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
            for (JLabel label : new JLabel[]{playerM.lbNick, playerM.lbDifficulty}){
                configureLabel(label);
            }
        }
        if (mokp != null){
            for (JLabel label : new JLabel[]{mokp.upKeyLabel,
                 mokp.downKeyLabel, mokp.leftKeyLabel, mokp.rightKeyLabel}){
                configureLabel(label);
            }
        }
        
    }
    @SuppressWarnings("unchecked")
    public void SizeIconComboBox(){
        if (playerM != null){
            for (JComboBox<String> comboBox : new JComboBox[]{playerM.difficultyComboBox}){
                configureComboBox(comboBox);
            }
        }
    }

    private void configureComboBox(JComboBox<String> comboBox) {
        comboBox.setFont(BUTTON_FONT);
        comboBox.setPreferredSize(new Dimension(200, 50)); // Ajuste o tamanho do JComboBox
        comboBox.setForeground(BUTTON_FOREGROUND_COLOR);
    }

    private void configureCheckBox(JCheckBox checkBox) {
        ImageIcon uncheckedIcon = resizeIcon("/res/item/uncheckButton.png", ICON_WIDTH, ICON_HEIGHT);
        ImageIcon checkedIcon = resizeIcon("/res/item/checkButton.png", ICON_WIDTH, ICON_HEIGHT);

        checkBox.setIcon(uncheckedIcon);
        checkBox.setSelectedIcon(checkedIcon);
        checkBox.setBorderPainted(false);
        checkBox.setFocusPainted(false);
        checkBox.setContentAreaFilled(false);
        checkBox.setForeground(BUTTON_FOREGROUND_COLOR);
        checkBox.setFont(BUTTON_FONT);
        checkBox.setVerticalAlignment(SwingConstants.CENTER);
        checkBox.setHorizontalTextPosition(SwingConstants.CENTER);
        checkBox.setVerticalTextPosition(SwingConstants.CENTER);
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
        textField.setPreferredSize(new Dimension(200, 50)); // Ajuste o tamanho do JTextField
        textField.setMinimumSize(new Dimension(200, 30));
        textField.setMaximumSize(new Dimension(200, 30));
        textField.setForeground(BUTTON_FOREGROUND_COLOR);
        
    }

    private void configureLabel(JLabel label) {
        ImageIcon icon = resizeIcon("/res/bottons/Gold/Normal.png", 400, 100);
        label.setIcon(icon);
        label.setFont(LABEL_FONT);
        label.setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight())); // Ajuste o tamanho do JLabel
        label.setForeground(LABEL_FOREGROUND_COLOR);
        label.setBorder(null);
        label.setOpaque(false); // Certifique-se de que o label seja transparente
        label.setHorizontalTextPosition(SwingConstants.CENTER); // Texto centralizado horizontalmente
        label.setVerticalTextPosition(SwingConstants.CENTER); // Texto centralizado verticalmente
    }
}
