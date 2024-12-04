package main.Menu;

import main.Menu.MenuTable.TableCredits;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuCreditsPanel extends JPanel {

    private JScrollPane creditsScrollPane;
    private JButton backButton;

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
        TableCredits tableCredits = new TableCredits(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação do botão "Back"
            }
        });
        creditsScrollPane = tableCredits.getScrollPane();
        backButton = tableCredits.getBackButton();
        gbc.fill = GridBagConstraints.BOTH;
        this.add(creditsScrollPane, gbc);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
