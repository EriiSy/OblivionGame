package main.Menu;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import main.Menu.RenderIcons.IconsMenuRender;

public class MenuOptionsPanel extends JPanel {
    public JButton BOptionsKeys, BOptionsSounds, BOptionsGraphics, BOptionsBack;
    ConfigMenu layout = new ConfigMenu();

    public MenuOptionsPanel() {
        this.setLayout(layout.createOptionsPanelLayout(this));
        // Margem de 50px em cima e embaixo
        this.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        Buttons();
        this.setOpaque(false);
        configureButtons();
        addButtons();
    }

    protected void Buttons() {
        BOptionsKeys = new JButton("KEYS");
        BOptionsSounds = new JButton("SOUNDS");
        BOptionsGraphics = new JButton("GRAPHICS");
        BOptionsBack = new JButton("BACK");
    }

    protected void configureButtons() {
        IconsMenuRender size = new IconsMenuRender(null, this, null, null, null);
        size.SizeIconButton();
    }

    protected void addButtons() {
        this.add(Box.createRigidArea(new Dimension(0, 200)));
        this.add(Box.createVerticalGlue());
        for (JButton button : new JButton[]{BOptionsGraphics, BOptionsKeys, BOptionsSounds, BOptionsBack}) {
            button.setAlignmentX(layout.x); 
            button.setAlignmentY(layout.y);
            this.add(button);
            this.add(Box.createVerticalStrut(10));
        }
        this.add(Box.createVerticalGlue());
    }
}
