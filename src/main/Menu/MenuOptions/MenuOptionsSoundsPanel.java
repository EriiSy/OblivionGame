package main.Menu.MenuOptions;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MenuOptionsSoundsPanel extends JPanel {

    JButton BOptionsSounds;
    JCheckBox gameSoundCheckBox;
    JCheckBox musicSoundCheckBox;
    JRadioButton portugueseRadioButton;
    JRadioButton englishRadioButton;
    JRadioButton spanishRadioButton;
    ButtonGroup languageGroup;

    public MenuOptionsSoundsPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        // Adicionar CheckBox para habilitar/desabilitar som do jogo
        gameSoundCheckBox = new JCheckBox("Habilitar Som do Jogo");
        gbc.gridy++;
        this.add(gameSoundCheckBox, gbc);

        // Adicionar CheckBox para habilitar/desabilitar som da música
        musicSoundCheckBox = new JCheckBox("Habilitar Som da Música");
        gbc.gridy++;
        this.add(musicSoundCheckBox, gbc);

        // Adicionar RadioButton para seleção de legendas
        portugueseRadioButton = new JRadioButton("Português");
        englishRadioButton = new JRadioButton("Inglês");
        spanishRadioButton = new JRadioButton("Espanhol");

        // Adicionar RadioButtons a um ButtonGroup
        languageGroup = new ButtonGroup();
        languageGroup.add(portugueseRadioButton);
        languageGroup.add(englishRadioButton);
        languageGroup.add(spanishRadioButton);

        // Adicionar RadioButtons ao painel
        gbc.gridy++;
        this.add(portugueseRadioButton, gbc);
        gbc.gridy++;
        this.add(englishRadioButton, gbc);
        gbc.gridy++;
        this.add(spanishRadioButton, gbc);
    }
}
