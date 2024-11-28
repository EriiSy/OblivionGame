package main.Menu;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class MenuOptionsPanel extends JPanel {
    public JButton BOptionsKeys;
    public JButton BOptionsSounds;
    public JButton BOptionsGraphics;
    public JButton BOptionsBack;

    public MenuOptionsPanel() {
        this.setLayout(new FlowLayout());
        Buttons();
        addButtons();
    }

    protected void Buttons() {
        BOptionsKeys = new JButton("KEYS");
        BOptionsSounds = new JButton("SOUNDS");
        BOptionsGraphics = new JButton("GRAPHICS");
        BOptionsBack = new JButton("BACK");
    }

    protected void addButtons() {
        for (JButton button : new JButton[]{BOptionsGraphics, BOptionsKeys, BOptionsSounds, BOptionsBack}) {
            this.add(button);
        }
    }
}
