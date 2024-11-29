package main.Menu;

import javax.swing.JPanel;
import java.awt.CardLayout;

public class MenuPanel extends JPanel {
    MenuMainPanel mmp;
    MenuOptionsPanel mop;
    MenuCreditsPanel mcp;

    public MenuPanel() {
        this.setLayout(new CardLayout());
        mmp = new MenuMainPanel();
        mop = new MenuOptionsPanel();
        mcp = new MenuCreditsPanel();
        this.add(mmp, "MenuMain");
        this.add(mop, "MenuOptions");
        this.add(mcp, "MenuCredits");
    }

    public MenuMainPanel getMenuMainPanel() {
        return mmp;
    }

    public MenuOptionsPanel getMenuOptionsPanel() {
        return mop;
    }

    public MenuCreditsPanel getMenuCreditsPanel() {
        return mcp;
    }
}
