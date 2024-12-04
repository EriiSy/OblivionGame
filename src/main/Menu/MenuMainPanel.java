package main.Menu;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import main.Menu.RenderIcons.IconsMenuRender;

public class MenuMainPanel extends JPanel {
    public JButton BStart, BExit, BOptions, BCredits;
    ConfigMenu layout = new ConfigMenu();

    public MenuMainPanel() {
        this.setLayout(layout.createMainPanelLayout(this));
        // Margem de 50px em cima e embaixo
        this.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        Buttons();
        this.setOpaque(false);
        configureButtons();
        addButtons();
    }

    protected void Buttons() {
        BStart = new JButton("START GAME");
        BOptions = new JButton("OPTIONS");
        BCredits = new JButton("CREDITS");
        BExit = new JButton("EXIT GAME");
    }

    protected void configureButtons() {
        IconsMenuRender size = new IconsMenuRender(this, null, null);
        size.SizeIconBotton();
    }

    protected void addButtons() {
        this.add(Box.createRigidArea(new Dimension(0, 200)));
        this.add(Box.createVerticalGlue());
        for (JButton button : new JButton[]{BStart, BOptions, BCredits,BExit}) {
            button.setAlignmentX(layout.x); 
            button.setAlignmentY(layout.y);
            this.add(button);
            this.add(Box.createVerticalStrut(10));
        }
        this.add(Box.createVerticalGlue());
    }
}
