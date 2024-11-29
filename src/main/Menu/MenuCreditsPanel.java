package main.Menu;
import javax.swing.JPanel;

import main.Menu.RenderIcons.IconsMenuRender;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import main.Menu.ConfigMenu;


public class MenuCreditsPanel extends JPanel {

        private JLabel lblCredits,lblDeveloper,lblDesigner, lSpecialThanks;
        ConfigMenu layout = new ConfigMenu();

        public MenuCreditsPanel() {
            this.setLayout(layout.createCreditsPanelLayout(this));
            this.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
            setOpaque(false);
            Labels();
            configLabels();
            configPopUP();
            addCreditsPanel();

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
            this.add(Box.createRigidArea(new Dimension(0, 200)));
            this.add(Box.createVerticalGlue());
            for (JLabel label : new JLabel[]{lblCredits, lblDeveloper, lblDesigner, lSpecialThanks}) {
                label.setAlignmentX(layout.x); 
                label.setAlignmentY(layout.y);
                this.add(label);
                this.add(Box.createVerticalStrut(10));
            }
            this.add(Box.createVerticalGlue());
        }
}

