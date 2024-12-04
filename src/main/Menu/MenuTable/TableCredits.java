package main.Menu.MenuTable;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableCredits {

    private JTextPane textPane;
    private JScrollPane scrollPane;
    private JPanel panelWithBackground;
    private JButton backButton;

    public TableCredits(ActionListener backAction) {
        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setFont(new java.awt.Font("Monocraft", java.awt.Font.BOLD, 50));
        textPane.setForeground(Color.ORANGE);
        textPane.setBackground(new java.awt.Color(0, 0, 0, 0)); // Fundo transparente
        textPane.setOpaque(false); // Certifica que o JTextPane é transparente

        // Adicionar o texto desejado
        String text = "Trabalho de POO\n" + 
                      "\nNome do jogo: Oblivion Souls\n\n" + "Integrantes do grupo:" +
                      "\nJonathan Jr. (developer)\n" +
                      "Erick Vinicius (developer)\n" +
                      "Aloisio (designer e developer)\n" +
                      "\nObrigado por jogar!";

        textPane.setText(text);

        // Centralizar o texto
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        // Desativar a seleção de texto
        textPane.setHighlighter(null);
        textPane.setFocusable(false);
        textPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                e.consume();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                e.consume();
            }
        });
        panelWithBackground = new JPanel() {
            private Image backgroundImage = new ImageIcon().getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelWithBackground.setLayout(new BorderLayout());
        panelWithBackground.setOpaque(false); // Certifica que o JPanel é transparente
        panelWithBackground.add(textPane, BorderLayout.CENTER);

        // Adicionar o botão "Back"
        backButton = new JButton("Back");
        backButton.addActionListener(backAction);
        panelWithBackground.add(backButton, BorderLayout.SOUTH);

        scrollPane = new JScrollPane(panelWithBackground);
        scrollPane.setPreferredSize(new java.awt.Dimension(800, 400));
        scrollPane.setOpaque(false); // Certifica que o JScrollPane é transparente
        scrollPane.getViewport().setOpaque(false); // Certifica que a viewport do JScrollPane é transparente
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
