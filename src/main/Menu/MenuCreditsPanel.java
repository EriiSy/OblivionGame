package main.Menu;

import main.Menu.MenuTable.TableCredits;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
//import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class MenuCreditsPanel extends JPanel {

    private JScrollPane creditsScrollPane;

    public MenuCreditsPanel() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        setOpaque(false);
        addCreditsPanel();
    }

    public void addCreditsPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new java.awt.Insets(10, 0, 10, 0);

        // Adicionar o JTextArea com o texto de créditos
        TableCredits tableCredits = new TableCredits();
        creditsScrollPane = tableCredits.getScrollPane();
        gbc.fill = GridBagConstraints.BOTH;
        this.add(creditsScrollPane, gbc);
    }
}
