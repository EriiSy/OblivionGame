package main.Menu.MenuTable;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TableCredits {

    private JTextPane textPane;
    private JScrollPane scrollPane;
    private JPanel panelWithBackground;

    public TableCredits() {
        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setFont(new java.awt.Font("Monocraft", java.awt.Font.BOLD, 24));
        textPane.setForeground(Color.BLACK);
        textPane.setBackground(new java.awt.Color(0, 0, 0, 0)); // Fundo transparente

        // Adicionar o texto desejado
        String text = "Trabalho de POO\n" + 
                      "\nNome do jogo: Oblivion Souls\n\n" + "Integrantes do grupo:" +
                      "\nJonathan Jr. (developer)\n" +
                      "Erick Vinicius (developer)\n" +
                      "Aloisio (designer)\n" +
                      "\nObrigado por jogar!";

        textPane.setText(text);

        // Centralizar o texto
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        StyleConstants.setForeground(center, Color.BLACK);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        // Criar um JPanel personalizado com imagem de fundo
        panelWithBackground = new JPanel() {
            private Image backgroundImage = new ImageIcon("path/to/your/image.png").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelWithBackground.setLayout(new java.awt.BorderLayout());
        panelWithBackground.add(textPane, java.awt.BorderLayout.CENTER);

        scrollPane = new JScrollPane(panelWithBackground);
        scrollPane.setPreferredSize(new java.awt.Dimension(800, 400));
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}
