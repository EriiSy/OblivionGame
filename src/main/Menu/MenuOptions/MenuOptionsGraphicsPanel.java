package main.Menu.MenuOptions;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import main.Menu.ConfigMenu;
import main.Menu.RenderIcons.IconsMenuRender;

public class MenuOptionsGraphicsPanel extends JPanel {

    public JCheckBox fullScreenCheckBox, vSyncCheckBox;
    public JButton BBack;
    public JLabel LFullScreen, LVSync;
    ConfigMenu layout = new ConfigMenu();

    public MenuOptionsGraphicsPanel() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        checkBox();
        Buttons();
        label();
        this.setOpaque(false);
        configureButtons();
        addComponents();
    }

    protected void Buttons() {
        BBack = new JButton("BACK");
    }

    protected void checkBox() {
        fullScreenCheckBox = new JCheckBox();
        vSyncCheckBox = new JCheckBox();
    }

    protected void label() {
        LFullScreen = new JLabel("FULL SCREEN");
        LVSync = new JLabel("VSYNC");
    }

    protected void configureButtons() {
        IconsMenuRender size = new IconsMenuRender(null, null, 
        null, null, null, this, null);
        size.SizeIconButton();
        size.SizeIconLabel();   
        size.SizeIconCheckBox();
    }

    protected void addComponents() {
        GridBagConstraints gbc;

        // First row
        gbc = layout.createGridBagConstraints(0, 0);
        this.add(LFullScreen, gbc);
        gbc = layout.createGridBagConstraints(1, 0);
        this.add(fullScreenCheckBox, gbc);


        // Second row
        gbc = layout.createGridBagConstraints(0, 1);
        this.add(LVSync, gbc);
        gbc = layout.createGridBagConstraints(1, 1);
        this.add(vSyncCheckBox, gbc);


        // Back button
        gbc = layout.createGridBagConstraints(0, 2);
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(BBack, gbc);
    }
}
