package main.Menu.MenuOptions;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import main.Menu.ConfigMenu;
import main.Menu.RenderIcons.IconsMenuRender;

public class MenuOptionsKeyPanel extends JPanel {

    public JLabel upKeyLabel, downKeyLabel, leftKeyLabel, rightKeyLabel, jumpKeyLabel, attackKeyLabel;
    public JButton BBack;
    ConfigMenu layout = new ConfigMenu();

    public MenuOptionsKeyPanel() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        Labels();
        Buttons();
        this.setOpaque(false);
        configureButtons();
        addComponents();
    }

    protected void Labels() {
        upKeyLabel = new JLabel("Move Up: W");
        downKeyLabel = new JLabel("Move Down: S");
        leftKeyLabel = new JLabel("Move Left: A");
        rightKeyLabel = new JLabel("Move Right: D");
        jumpKeyLabel = new JLabel("Jump: Space");
        attackKeyLabel = new JLabel("Attack: J");
    }

    protected void Buttons() {
        BBack = new JButton("BACK");
    }

    protected void configureButtons() {
        IconsMenuRender size = new IconsMenuRender(null, null, null, null, 
        null,null, this);
        size.SizeIconButton();
    }

    protected void addComponents() {
        GridBagConstraints gbc = layout.createGridBagConstraints(0, 0);
        this.add(upKeyLabel, gbc);

        gbc = layout.createGridBagConstraints(0, 1);
        this.add(downKeyLabel, gbc);

        gbc = layout.createGridBagConstraints(0, 2);
        this.add(leftKeyLabel, gbc);

        gbc = layout.createGridBagConstraints(0, 3);
        this.add(rightKeyLabel, gbc);

        gbc = layout.createGridBagConstraints(0, 4);
        this.add(jumpKeyLabel, gbc);

        gbc = layout.createGridBagConstraints(0, 5);
        this.add(attackKeyLabel, gbc);

        gbc = layout.createGridBagConstraints(0, 6);
        this.add(BBack, gbc);
    }
}
