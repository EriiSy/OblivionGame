package main.Menu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class MenuCreditsPanel extends JPanel {

    private JLabel lblCredits, lblDeveloper, lblDesigner, lSpecialThanks;
    private JLabel backgroundImageLabel;
    ConfigMenu layout = new ConfigMenu();

    public MenuCreditsPanel() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        setOpaque(false);
        Labels();
        configLabels();
        configPopUP();
        addCreditsPanel();
        addBackgroundImage();
    }

    public void configPopUP() {
        lSpecialThanks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                javax.swing.JOptionPane.showMessageDialog(null, "OBRIGADO!");
            }
        });
    }

    public void Labels() {
        lblCredits = new JLabel("CREDITS");
        lblDeveloper = new JLabel("DEVELOPER: ---");
        lblDesigner = new JLabel("DESIGNER:----");
        lSpecialThanks = new JLabel("Special Thanks");
    }

    public void configLabels() {
        for (JLabel label : new JLabel[]{lblCredits, lblDeveloper, lblDesigner, lSpecialThanks}) {
            label.setFont(new Font("Monocraft", Font.BOLD, 20));
            label.setForeground(Color.WHITE);
        }
    }

    public void addCreditsPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new java.awt.Insets(10, 0, 10, 0);

        this.add(Box.createRigidArea(new Dimension(0, 200)), gbc);
        gbc.gridy++;
        this.add(Box.createVerticalGlue(), gbc);
        for (JLabel label : new JLabel[]{lblCredits, lblDeveloper, lblDesigner, lSpecialThanks}) {
            label.setAlignmentX(layout.x);
            label.setAlignmentY(layout.y);
            gbc.gridy++;
            this.add(label, gbc);
            gbc.gridy++;
            this.add(Box.createVerticalStrut(10), gbc);
        }
        gbc.gridy++;
        this.add(Box.createVerticalGlue(), gbc);
    }

    public void addBackgroundImage() {
        ImageIcon backgroundImage = new ImageIcon("path/to/your/image.png");
        backgroundImageLabel = new JLabel(backgroundImage);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(backgroundImageLabel, gbc);
    }
}
