package main.Menu;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;

import main.Menu.RenderIcons.IconsMenuRender;

public class MenuMainPanel extends JPanel {
    public JButton BStart, BExit, BOptions;
    ConfigButtons buttonX = new ConfigButtons();
    ConfigButtons buttonY = new ConfigButtons();
    
    
    

    public MenuMainPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // Margem de 50px em cima e embaixo
        this.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0)); 
        Buttons();
        this.setOpaque(false);
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
        this.add(Box.createRigidArea(new Dimension(0, 200)));
        this.add(Box.createVerticalGlue());
        for (JButton button : new JButton[]{BStart, BExit, BOptions}) {
            button.setAlignmentX(buttonX.x); 
            button.setAlignmentY(buttonY.y);
            this.add(button);
            this.add(Box.createVerticalStrut(10));
        }
        this.add(Box.createVerticalGlue());
    }
}
