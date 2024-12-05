package main.Menu.MenuOptions;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import main.Menu.ConfigMenu;
import main.Menu.RenderIcons.IconsMenuRender;

public class MenuOptionsGraphicsPanel extends JPanel {

    JCheckBox fullScreenCheckBox, vSyncCheckBox;
    public JButton BBack;
    ConfigMenu layout = new ConfigMenu();

    public MenuOptionsGraphicsPanel() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        checkBox();
        Buttons();
        this.setOpaque(false);
        configureButtons();
        addComponents();
    }

    protected void Buttons() {
        BBack = new JButton("BACK");
    }

    protected void checkBox() {
        fullScreenCheckBox = new JCheckBox("Enable Full Screen");
        vSyncCheckBox = new JCheckBox("Enable V-Sync");
    }

    protected void configureButtons() {
        IconsMenuRender size = new IconsMenuRender(null, null, 
        null, null, null,this, null);
        size.SizeIconButton();
    }

    protected void addComponents() {
        GridBagConstraints gbc = layout.createGridBagConstraints(0, 0);
        this.add(fullScreenCheckBox, gbc);

        gbc = layout.createGridBagConstraints(0, 1);
        this.add(vSyncCheckBox, gbc);

        gbc = layout.createGridBagConstraints(0, 2);
        this.add(BBack, gbc);
    }
}
