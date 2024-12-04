package main.Menu.MenuOptions;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import main.Menu.ConfigMenu;

import javax.swing.ButtonGroup;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MenuOptionsSoundsPanel extends JPanel {

    JButton BOptionsSounds;
    JCheckBox gameSoundCheckBox, musicSoundCheckBox;
    JRadioButton portugueseRadioButton, englishRadioButton, spanishRadioButton;
    ButtonGroup languageGroup;
    ConfigMenu layout = new ConfigMenu();
    GridBagConstraints gbc = new GridBagConstraints();

    public MenuOptionsSoundsPanel() {
        this.setLayout(new GridBagLayout());
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
    }

    protected void CheckBox() {
        gameSoundCheckBox = new JCheckBox("Habilitar Som do Jogo");
        musicSoundCheckBox = new JCheckBox("Habilitar Som da Música");
    }

    protected void addCheckBox() {
        gbc.gridy++;
        this.add(gameSoundCheckBox);
        this.add(musicSoundCheckBox);
    }

    protected void RadioButton() {
        portugueseRadioButton = new JRadioButton("Português");
        englishRadioButton = new JRadioButton("Inglês");
        spanishRadioButton = new JRadioButton("Espanhol");
    }

    protected void addRadioButton() {
        this.add(portugueseRadioButton);
        this.add(englishRadioButton);
        this.add(spanishRadioButton);
    }

    protected void ButtonGroup() {
        languageGroup = new ButtonGroup();
        languageGroup.add(portugueseRadioButton);
        languageGroup.add(englishRadioButton);
        languageGroup.add(spanishRadioButton);
    }

    protected void addButtons() {
        gbc.gridy++;
        this.add(gameSoundCheckBox, gbc);
        this.add(musicSoundCheckBox);
        this.add(portugueseRadioButton);
        this.add(englishRadioButton);
        this.add(spanishRadioButton);
    }

}