package main.Menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ConfigMenu {

    float x = 0.235f;
    float y = 0.5f;

    public BoxLayout createMainPanelLayout(JPanel panel) {
        return new BoxLayout(panel, BoxLayout.Y_AXIS);
    }

    public LayoutManager createPlayerPanelLayout(JPanel panel) {
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        return layout;
    }

    public GridBagConstraints createGridBagConstraints(int gridx, int gridy) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.insets = new Insets(5, 5, 5, 5); // Reduza os Insets para aproximar os componentes
        gbc.anchor = GridBagConstraints.WEST;
        // gbc.fill = GridBagConstraints.HORIZONTAL; // Permite que o JTextField ocupe o espaço horizontal disponível
        return gbc;
    }

    public BoxLayout createOptionsPanelLayout(JPanel panel) {
        return new BoxLayout(panel, BoxLayout.Y_AXIS);
    }

    public BoxLayout createCreditsPanelLayout(JPanel panel) {
        return new BoxLayout(panel, BoxLayout.Y_AXIS);
    }

    public BoxLayout createOptionsSoundsLayout(JPanel panel) {
        return new BoxLayout(panel, BoxLayout.Y_AXIS);
    }
}
