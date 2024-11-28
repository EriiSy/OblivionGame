package main.Menu;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import main.Menu.RenderIcons.IconsMenuRender;

public class MenuMainPanel extends JPanel {
    public JButton BStart, BExit, BOptions;

    public MenuMainPanel() {
        this.setLayout(new FlowLayout());
        Buttons();
        configureButtons();
        addButtons();
    }

    protected void Buttons() {
        BStart = new JButton("START GAME");
        BExit = new JButton("EXIT GAME");
        BOptions = new JButton("OPTIONS");
    }

    protected void configureButtons() {
        IconsMenuRender size = new IconsMenuRender(this, null);
        size.SizeIconBotton();
    }

    protected void addButtons() {
        for (JButton button : new JButton[]{BStart, BExit, BOptions}) {
            this.add(button);
        }
    }
}
