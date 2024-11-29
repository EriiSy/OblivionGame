package main.Menu;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ConfigMenu {

    float x = 0.235f;
    float y = 0.5f;

    
    public BoxLayout createMainPanelLayout(JPanel panel) {
        return new BoxLayout(panel, BoxLayout.Y_AXIS);
    }

    public BoxLayout createOptionsPanelLayout(JPanel panel) {
        return new BoxLayout(panel, BoxLayout.Y_AXIS);
    }

    public BoxLayout createCreditsPanelLayout(JPanel panel) {
        return new BoxLayout(panel, BoxLayout.Y_AXIS);
    }
}
