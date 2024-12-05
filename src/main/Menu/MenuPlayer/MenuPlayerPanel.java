package main.Menu.MenuPlayer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;

import main.Menu.ConfigMenu;
import main.Menu.RenderIcons.IconsMenuRender;

public class MenuPlayerPanel extends JPanel {

    ConfigMenu layout = new ConfigMenu(); 
    public JComboBox<String> difficultyComboBox = new JComboBox<>(new String[] {"Easy", "Medium", "Hard"});
    public JButton BBack, BStart;
    public JLabel lbNick, lbDifficulty;
    public JTextField tfNick; 

    public MenuPlayerPanel(){
        this.setLayout(layout.createPlayerPanelLayout(this));
        this.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        label();
        textField();
        comboBox();
        button();
        this.setOpaque(false);
        config();
        addComponents();
    }

    protected void button(){
        BBack = new JButton("BACK");
        BStart = new JButton("START");
    }



    protected void comboBox(){
        difficultyComboBox.setSelectedIndex(0);

    }

    protected void label(){
        lbNick = new JLabel("NICKNAME");
        lbDifficulty = new JLabel("DIFFICULTY");
    }

    protected void textField(){
        tfNick = new JTextField(" ",20); // Ajuste o tamanho do JTextField
    }

    protected void config() {
        IconsMenuRender size = new IconsMenuRender(null, null, null, this, 
        null,null,null);
        size.SizeIconLabel();
        size.SizeIconTextField();
        size.SizeIconComboBox();
        size.SizeIconButton();
    }

    protected void addComponents(){
        GridBagConstraints gbcLabel = layout.createGridBagConstraints(0, 0);
        this.add(lbNick, gbcLabel);

        GridBagConstraints gbcTextField = layout.createGridBagConstraints(1, 0);
        this.add(tfNick, gbcTextField);

        GridBagConstraints gbcLabel2 = layout.createGridBagConstraints(0, 1);
        this.add(lbDifficulty, gbcLabel2);

        GridBagConstraints gbcComboBox = layout.createGridBagConstraints(1, 1);
        this.add(difficultyComboBox, gbcComboBox);

        GridBagConstraints gbcButton = layout.createGridBagConstraints(0, 2);
        this.add(BBack, gbcButton);

        GridBagConstraints gbcButton2 = layout.createGridBagConstraints(1, 2);
        this.add(BStart, gbcButton2);

        

    }
}
