package main.Menu;

import javax.swing.JPanel;
import main.Menu.MenuOptions.MenuOptionsSoundsPanel;
import java.awt.CardLayout;

public class MenuPanel extends JPanel {
    MenuMainPanel mmp;
    MenuOptionsPanel mop;
    MenuCreditsPanel mcp;
    MenuOptionsSoundsPanel mosp;

    public MenuPanel() {
        this.setLayout(new CardLayout());
        mmp = new MenuMainPanel();
        mop = new MenuOptionsPanel();
        mcp = new MenuCreditsPanel();
        mosp = new MenuOptionsSoundsPanel();
        this.add(mmp, "MenuMain");
        this.add(mop, "MenuOptions");
        this.add(mcp, "MenuCredits");
        this.add(mosp, "MenuOptionsSounds");
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

    public MenuOptionsSoundsPanel getMenuOptionsSoundsPanel() {
        return mosp;
    }
}
