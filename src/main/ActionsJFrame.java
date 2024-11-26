package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class ActionsJFrame extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    WindowGame game = new WindowGame();
    MenuPanel mp;
    
    final int screenWidth = 1920;
    final int screenHeight = 1080;
    JButton BStart, BExit, BBack;
    JButton BOptions, BOptionsKeys, BOptionsSound, BOptionsGraphics, BOptionsBack;
    JButton BCredits;
    JLabel LCredits, LCreditsDeveloper, LCreditsArt, LCreditsAdvisor, LCreditsSpecialThanks;
    JLabel LNickName;
    JTextField TFNickName; 
    JCheckBox CHSound;
    JRadioButton RBLegenda; 
    ButtonGroup BGGraphics; 
    JMenuItem MIExit, MISizeMax, MISizeMin, MICredits;
    JMenu MFile, MOptions, MHelp; 
    JMenuBar MBMenu; 
    JTable TBCredits; 
    JScrollPane SCPane;

    public ActionsJFrame(MenuPanel mp) {
        this.mp = mp;
    }

    
    protected void Buttons(JPanel panel) {
        BStart = new JButton("START GAME");
        BExit = new JButton("EXIT GAME");
        BOptions = new JButton("OPTIONS");
        BOptionsKeys = new JButton("KEYBOARD");
        BOptionsSound = new JButton("SOUNDS");
        BOptionsGraphics = new JButton("VIDEO");
        BOptionsBack = new JButton("BACK<-");

        panel.add(BStart);
        panel.add(BExit);
        panel.add(BOptions);
    }
  

    protected void SizeIconBotton(){
        for (JButton button : new JButton[]{BStart, BExit, BOptions, BOptionsKeys, 
            BOptionsSound, BOptionsGraphics, BOptionsBack}) {
            button.setIcon(resizeIcon("/res/bottons/LightBlue/Normal.png", 200, 50));
            button.setRolloverIcon(resizeIcon("/res/bottons/LightBlue/Hover.png", 200, 50));
            button.setPressedIcon(resizeIcon("/res/bottons/LightBlue/Clicked.png", 200, 50));
            button.setPreferredSize(new Dimension(200, 50));
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            button.setForeground(new Color(170,140,177));
            button.setFont(new Font("Monocraft", Font.BOLD, 20));
            button.setVerticalAlignment(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setContentAreaFilled(false);
        }
    }

    private ImageIcon resizeIcon(String path, int width, int height) {
        URL iconURL = getClass().getResource(path);
        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            Image img = icon.getImage();
            Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImg);
        } else {
            System.out.println("Imagem não encontrada: " + path);
            return null;
        }
    }

    protected void ButtonsMouseListener(){
        for (JButton button : new JButton[]{BStart, BExit, BOptions, BOptionsKeys, 
            BOptionsSound, BOptionsGraphics, BOptionsBack}) {
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setForeground(Color.GRAY); 
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setForeground(new Color(170,140,177)); 
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    button.setIcon(resizeIcon("/res/bottons/LightBlue/Clicked.png", 200, 50)); 
                    button.setIconTextGap(-10); 
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    button.setIcon(resizeIcon("/res/bottons/LightBlue/Normal.png", 200, 50)); 
                    button.setIconTextGap(0); 
                }
            });
        }
    }

    protected void ActionListenerButtons() {
        for (JButton button : new JButton[]{BStart, BExit, BOptions, BOptionsKeys, 
            BOptionsSound, BOptionsGraphics, BOptionsBack}) {
            button.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BStart) {
            game.gameStartThread();
        } else if (e.getSource() == BExit) {
            System.exit(0);
        } else if (e.getSource() == BOptions) {
            panel.removeAll();
            panel.add(BOptionsKeys);
            panel.add(BOptionsSound);
            panel.add(BOptionsGraphics);
            panel.add(BOptionsBack);
            panel.revalidate();
            panel.repaint();
        } else if (e.getSource() == BOptionsBack) {
            panel.removeAll();
            panel.add(BStart);
            panel.add(BExit);
            panel.add(BOptions);
            panel.revalidate();
            panel.repaint();
        }
    }
}
