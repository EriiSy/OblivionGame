package main.Menu.MenuOptions;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import main.Menu.ConfigMenu;
import main.Menu.RenderIcons.IconsMenuRender;

import javax.swing.ButtonGroup;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;

public class MenuOptionsSoundsPanel extends JPanel {

    JButton BOptionsSounds;
    JCheckBox gameSoundCheckBox, musicSoundCheckBox;
    JRadioButton portugueseRadioButton, englishRadioButton, spanishRadioButton;
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
        this.setOpaque(false);
        configureButtons();
        addComponents();
    }

    protected void Buttons() {
        BBack = new JButton("BACK");
    }

    protected void checkBox() {
        gameSoundCheckBox = new JCheckBox("Habilitar Som do Jogo");
        musicSoundCheckBox = new JCheckBox("Habilitar Som da Música");
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
    }

    protected void addComponents() {
        GridBagConstraints gbc = layout.createGridBagConstraints(0, 0);
        this.add(gameSoundCheckBox, gbc);

        gbc = layout.createGridBagConstraints(0, 1);
        this.add(musicSoundCheckBox, gbc);

        gbc = layout.createGridBagConstraints(0, 2);
        this.add(portugueseRadioButton, gbc);

        gbc = layout.createGridBagConstraints(0, 3);
        this.add(englishRadioButton, gbc);

        gbc = layout.createGridBagConstraints(0, 4);
        this.add(spanishRadioButton, gbc);

        gbc = layout.createGridBagConstraints(0, 5);
        this.add(BBack, gbc);
    }
}