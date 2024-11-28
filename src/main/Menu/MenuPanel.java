package main.Menu;

import javax.swing.JPanel;
import java.awt.CardLayout;

public class MenuPanel extends JPanel {
    MenuMainPanel mmp;
    MenuOptionsPanel mop;

    public MenuPanel() {
        this.setLayout(new CardLayout());
        mmp = new MenuMainPanel();
        mop = new MenuOptionsPanel();
        this.add(mmp, "MenuMainPanel");
        this.add(mop, "MenuOptionsPanel");
    }

    public MenuMainPanel getMenuMainPanel() {
        return mmp;
    }

    public MenuOptionsPanel getMenuOptionsPanel() {
        return mop;
    }
}