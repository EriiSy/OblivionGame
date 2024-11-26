package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionsJFrame extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    WindowGame game = new WindowGame();
    final int screenWidth = 800;
    final int screenHeight = 600;
    JButton BStart, BExit, BBack;
    JButton BOptions, BOptionsKeys, BOptionsSound, BOptionsGraphics, BOptionsBack;
    JButton BCredits;
    JLabel LCredits, LCreditsDeveloper, LCreditsArt, LCreditsAdvisor, LCreditsSpecialThanks;
    JLabel LNickName;
    JTextField TFNickName; 
    JComboBox CBDificulty;  
    JCheckBox CHSound;
    JRadioButton RBLegenda; 
    ButtonGroup BGGraphics; 
    JMenuItem MIExit, MISizeMax, MISizeMin, MICredits;
    JMenu MFile, MOptions, MHelp; 
    JMenuBar MBMenu; 
    JTable TBCredits; 
    JScrollPane SCPane;

    

    protected void Buttons(JPanel panel) {
        BStart = new JButton("Start Game");
        BExit = new JButton("Exit Game");
        BOptions = new JButton("Options");
        BOptionsKeys = new JButton("Keyboard");
        BOptionsSound = new JButton("Sounds");
        BOptionsGraphics = new JButton("Video");
        BOptionsBack = new JButton("Back");

        // Definindo ícones para os botões
        BStart.setIcon(new ImageIcon("res/icons/BStart.png"));
        BExit.setIcon(new ImageIcon("res/icons/BExit.png"));
        BOptions.setIcon(new ImageIcon("res/icons/BBack.png"));

        BStart.addActionListener(this);
        BExit.addActionListener(this);
        BOptions.addActionListener(this);

        panel.add(BStart);
        panel.add(BExit);
        panel.add(BOptions);
        panel.add(BOptionsKeys);
        panel.add(BOptionsSound);
        panel.add(BOptionsGraphics);
        panel.add(BOptionsBack);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BStart) {
            game.gameStartThread();
        }if (e.getSource() == BExit) {
            System.exit(0);
        }if (e.getSource() == BOptions) {
            
        }
    }

    
}
