package main.Menu;

import javax.swing.JPanel;
import main.Menu.MenuOptions.MenuOptionsSoundsPanel;
import main.Menu.MenuOptions.MenuOptionsKeyPanel;
import main.Menu.MenuOptions.MenuOptionsGraphicsPanel;
import main.Menu.MenuPlayer.MenuPlayerPanel;

import java.awt.CardLayout;

public class MenuPanel extends JPanel {
    MenuMainPanel mmp;
    MenuOptionsPanel mop;
    MenuCreditsPanel mcp;
    MenuOptionsSoundsPanel mosp;
    MenuOptionsGraphicsPanel mogp;
    MenuOptionsKeyPanel mokp;
    MenuPlayerPanel playerM; 

    public MenuPanel() {
        this.setLayout(new CardLayout());
        mmp = new MenuMainPanel();
        mop = new MenuOptionsPanel();
        mcp = new MenuCreditsPanel();
        mosp = new MenuOptionsSoundsPanel();
        mogp = new MenuOptionsGraphicsPanel();
        mokp = new MenuOptionsKeyPanel();
        playerM = new MenuPlayerPanel();
        this.add(mmp, "MenuMain");
        this.add(mop, "MenuOptions");
        this.add(mcp, "MenuCredits");
        this.add(mosp, "MenuOptionsSounds");
        this.add(mogp, "MenuOptionsGraphics");
        this.add(mokp, "MenuOptionsKeys");
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
    public MenuOptionsGraphicsPanel getMenuOptionsGraphicsPanel() {
        return mogp;
    }
    public MenuOptionsSoundsPanel getMenuOptionsSoundsPanel() {
        return mosp;
    }
    public MenuOptionsKeyPanel getMenuOptionsKeyPanel() {
        return mokp;
    }
    public MenuPlayerPanel getMenuPlayerPanel(){
        return playerM;
    }
}
