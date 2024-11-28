package main.Menu;

import javax.swing.BoxLayout;

public class ConfigMenu {
    MenuMainPanel mmp = new MenuMainPanel();
    MenuOptionsPanel mop = new MenuOptionsPanel();

    final float x = 0.235f;
    final float y = 0.5f;

    BoxLayout buttonPanelMain = new BoxLayout(mmp,BoxLayout.PAGE_AXIS);
    BoxLayout buttonPanelOptions = new BoxLayout(mop,BoxLayout.PAGE_AXIS);
}
