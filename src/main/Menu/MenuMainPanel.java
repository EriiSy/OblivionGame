package main.Menu;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuMainPanel {  
    protected JPanel PMain;
    public JButton BStart, BExit, BOptions;
    
    protected void Buttons() {
        BStart = new JButton("START GAME");
        BExit = new JButton("EXIT GAME");
        BOptions = new JButton("OPTIONS");
    }

    protected void addButtons() {
        for (JButton button : new JButton[]{BStart, BExit, BOptions}) {
            PMain.add(button);
        }
    }
    
    protected void removeButtons() {
        for (JButton button : new JButton[]{BStart, BExit, BOptions}) {
            PMain.remove(button);
        }
    }

    public MenuMainPanel() {
        PMain = new JPanel(); // Inicializa o PMain
        this.Buttons();
        this.addButtons();
    }
}
