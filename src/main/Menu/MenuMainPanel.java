package main.Menu;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class MenuMainPanel extends JPanel {
    public JButton BStart, BExit, BOptions;

    public MenuMainPanel() {
        this.setLayout(new FlowLayout());
        Buttons();
        addButtons();
    }

    protected void Buttons() {
        BStart = new JButton("START GAME");
        BExit = new JButton("EXIT GAME");
        BOptions = new JButton("OPTIONS");
    }

    protected void addButtons() {
        for (JButton button : new JButton[]{BStart, BExit, BOptions}) {
            this.add(button);
        }
    }
}
