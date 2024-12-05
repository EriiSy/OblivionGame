package main.Menu;

import javax.swing.JPanel;
import main.Menu.MenuOptions.MenuOptionsSoundsPanel;
import main.Menu.MenuPlayer.MenuPlayerPanel;

import java.awt.CardLayout;

public class MenuPanel extends JPanel {
    MenuMainPanel mmp;
    MenuOptionsPanel mop;
    MenuCreditsPanel mcp;
    MenuOptionsSoundsPanel mosp;
    MenuPlayerPanel playerM; 

    public MenuPanel() {
        this.setLayout(new CardLayout());
        mmp = new MenuMainPanel();
        mop = new MenuOptionsPanel();
        mcp = new MenuCreditsPanel();
        mosp = new MenuOptionsSoundsPanel();
        playerM = new MenuPlayerPanel();
        this.add(mmp, "MenuMain");
        this.add(mop, "MenuOptions");
        this.add(mcp, "MenuCredits");
        this.add(mosp, "MenuOptionsSounds");
        this.add(playerM, "MenuPlayer");
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

    public MenuPlayerPanel getMenuPlayerPanel(){
        return playerM;
    }
}
