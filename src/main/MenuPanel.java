package main;

import javax.swing.JPanel;
import javax.swing.Box;
import java.awt.FlowLayout;

public class MenuPanel {
    private Menu menu;
    JPanel panel = new JPanel();

    public MenuPanel(Menu menu) {
        this.menu = menu;
    }

    protected JPanel MenuMainPanel(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        panel.add(Box.createVerticalStrut(20));
        panel.add(menu.actions.BStart);
        panel.add(Box.createVerticalStrut(20));
        panel.add(menu.actions.BOptions);
        panel.add(Box.createVerticalStrut(20));
        panel.add(menu.actions.BExit);
        return panel;
    }

    protected JPanel MenuOptionsPanel(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, -1000, 10));
        panel.add(Box.createVerticalStrut(20));
        panel.add(menu.actions.BOptionsKeys);
        panel.add(Box.createVerticalStrut(20));
        panel.add(menu.actions.BOptionsSound);
        panel.add(Box.createVerticalStrut(20));
        panel.add(menu.actions.BOptionsGraphics);
        panel.add(Box.createVerticalStrut(20));
        panel.add(menu.actions.BOptionsBack);
        return panel;
    }
}
