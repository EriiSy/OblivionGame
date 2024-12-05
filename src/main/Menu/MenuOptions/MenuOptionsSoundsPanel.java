package main.Menu.MenuOptions;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import main.Menu.ConfigMenu;
import main.Menu.RenderIcons.IconsMenuRender;

import javax.swing.ButtonGroup;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;

public class MenuOptionsSoundsPanel extends JPanel {

    public JCheckBox gameSoundCheckBox, musicSoundCheckBox;
    public JLabel lSound, lMusic;
    public JRadioButton portugueseRadioButton, englishRadioButton, spanishRadioButton;
    public JButton BBack; 
    
    ButtonGroup languageGroup;
    ConfigMenu layout = new ConfigMenu();

    public MenuOptionsSoundsPanel() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        checkBox();
        radioButton();
        buttonGroup();
        Buttons();
        label();
        this.setOpaque(false);
        configureButtons();
        addComponents();
    }
    
    protected void label() {
        lSound = new JLabel("SOUND");
        lMusic = new JLabel("MUSIC");
    }
    protected void Buttons() {
        BBack = new JButton("BACK");
    }

    protected void checkBox() {
        gameSoundCheckBox = new JCheckBox();
        musicSoundCheckBox = new JCheckBox();
    }

    protected void radioButton() {
        portugueseRadioButton = new JRadioButton("Português");
        englishRadioButton = new JRadioButton("Inglês");
        spanishRadioButton = new JRadioButton("Espanhol");
    }

    protected void buttonGroup() {
        languageGroup = new ButtonGroup();
        languageGroup.add(portugueseRadioButton);
        languageGroup.add(englishRadioButton);
        languageGroup.add(spanishRadioButton);
    }
    
    protected void configureButtons() {
        IconsMenuRender size = new IconsMenuRender(null, null, null, null, 
        this, null, null);
        size.SizeIconButton();
        size.SizeIconLabel();
        size.SizeIconCheckBox();
    }

    protected void addComponents() {
        GridBagConstraints gbc;

       
        gbc = layout.createGridBagConstraints(0, 0);
        this.add(lSound, gbc);
        gbc = layout.createGridBagConstraints(1, 0);
        this.add(gameSoundCheckBox, gbc);

    
        gbc = layout.createGridBagConstraints(0, 1);
        this.add(lMusic, gbc);
        gbc = layout.createGridBagConstraints(1, 1);
        this.add(musicSoundCheckBox, gbc);

       
        gbc = layout.createGridBagConstraints(0, 2);
        this.add(portugueseRadioButton, gbc);

      
        gbc = layout.createGridBagConstraints(0, 3);
        this.add(englishRadioButton, gbc);

       
        gbc = layout.createGridBagConstraints(0, 4);
        this.add(spanishRadioButton, gbc);

       
        gbc = layout.createGridBagConstraints(0, 5);
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(BBack, gbc);
    }
}