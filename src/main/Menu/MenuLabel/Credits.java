package main.Menu.MenuLabel;


import javax.swing.*;
import java.awt.*;


public class Credits {
    public Credits() {
        JFrame frame = new JFrame("Créditos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);

        String[] columnNames = {"Nome", "Função"};
        Object[][] data = {
            {"Erick", "Desenvolvedor"},
            {"Maria", "Designer"},
            {"João", "Gerente de Projeto"}
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
}
