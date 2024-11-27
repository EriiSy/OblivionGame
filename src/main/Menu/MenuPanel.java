package main.Menu;

import javax.swing.JPanel;
import javax.swing.Box;
import java.awt.FlowLayout;

public class MenuPanel {

    private Menu menu;
    
    MenuMainPanel mmp = new MenuMainPanel();
    MenuOptionsPanel mop = new MenuOptionsPanel();


    public MenuPanel(Menu menu) {
        this.menu = menu;
    }

    public JPanel MenuMainPanel(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.setOpaque(false); // Certifica que o painel é transparente
        panel.add(Box.createVerticalStrut(100));
        panel.add(mmp.BStart);
        panel.add(Box.createVerticalStrut(20));
        panel.add(mmp.BOptions);
        panel.add(Box.createVerticalStrut(20));
        panel.add(mmp.BExit);
        return panel;
    }

    public JPanel MenuOptionsPanel(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.setOpaque(false); // Certifica que o painel é transparente
        panel.add(Box.createVerticalStrut(20));
        panel.add(mop.BOptionsGraphics);
        panel.add(Box.createVerticalStrut(100));
        panel.add(mop.BOptionsKeys);
        panel.add(Box.createVerticalStrut(20));
        panel.add(mop.BOptionsSounds);
        panel.add(Box.createVerticalStrut(20));
        panel.add(mop.BOptionsBack);
        return panel;
    }

    public Menu getMenu() {
        return menu;
    }
}
