package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame implements ActionListener {

    WindowGame game = new WindowGame();
    JButton BStart;
    JButton BExit;

    private void actionsButtons() {
        BStart = new JButton("Start Game");
        BExit = new JButton("Exit Game");
        BStart.addActionListener(this);
        BExit.addActionListener(this);
    }
    
    private JPanel MenuPanel() {
        JPanel panel = new JPanel();
        panel.add(BStart);
        panel.add(BExit);
        return panel;
    }

    public Menu(){
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para fechar o programa quando clicarmos em "x"
        this.setResizable(true); 
        this.setTitle("Oblivion Souls");
        URL iconURL = Main.class.getResource("/res/icons/Logo.png");
        if (iconURL != null) {
            this.setIconImage(new ImageIcon(iconURL).getImage());
        }
    }

    public void startMenu(){
        this.actionsButtons();
        this.add(MenuPanel());
        this.setLocationRelativeTo(null); // A janela será exibida no centro da tela. Sem especificar a localização
        this.setVisible(true); // Para poder ver a tela.
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == BStart){
            game.gameStartThread();
        }
        if (e.getSource() == BExit){
            game.gameStopThread();
            System.exit(0);
        }

    }

    
}
