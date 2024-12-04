package main.Menu.MenuPlayer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;

import main.Menu.ConfigMenu;
import main.Menu.RenderIcons.IconsMenuRender;

public class MenuPlayerPanel extends JPanel {

    ConfigMenu layout = new ConfigMenu(); 
    public JLabel lbNick; 
    public JTextField tfNick; 

    public MenuPlayerPanel(){
        this.setLayout(layout.createPlayerPanelLayout(this));
        this.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        label();
        textField();
        this.setOpaque(false);
        config();
        addComponents();
    }

    protected void label(){
        lbNick = new JLabel("NICKNAME: ");
    }

    protected void textField(){
        tfNick = new JTextField(" ",20); // Ajuste o tamanho do JTextField
    }

    protected void config() {
        IconsMenuRender size = new IconsMenuRender(null, null, null, this);
        size.SizeIconLabel();
        size.SizeIconTextField();
    }

    protected void addComponents(){
        GridBagConstraints gbcLabel = layout.createGridBagConstraints(0, 0);
        this.add(lbNick, gbcLabel);

        GridBagConstraints gbcTextField = layout.createGridBagConstraints(1, 0);
        this.add(tfNick, gbcTextField);
    }
}
