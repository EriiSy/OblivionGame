package main.Menu;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuOptionsPanel extends JPanel {
    protected JPanel POptions = new JPanel();
    public JButton BOptionsGraphics, BOptionsKeys, BOptionsSounds, BOptionsBack;

    protected void Buttons() {
        BOptionsGraphics = new JButton("VIDEO");
        BOptionsKeys = new JButton("KEYBOARD");
        BOptionsSounds = new JButton("SOUNDS");
        BOptionsBack = new JButton("BACK");
    }

    protected void addButtons() {
        for (JButton button : new JButton[]{BOptionsGraphics, BOptionsKeys, BOptionsSounds, BOptionsBack}) {
            POptions.add(button);
        }
    }

    protected void removeButtons() {
        for (JButton button : new JButton[]{BOptionsGraphics, BOptionsKeys, BOptionsSounds, BOptionsBack}) {
            POptions.remove(button);
        }
    }


    public MenuOptionsPanel() {
        this.Buttons();
        this.addButtons();
    }
    

}
