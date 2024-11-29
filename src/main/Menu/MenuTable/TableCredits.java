package main.Menu.MenuTable;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class TableCredits {

    private JTable table;

    public TableCredits() {
        table = new JTable(new CreditsTableModel());
        table.setRowHeight(30);
        table.setShowGrid(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setEnabled(false);
    }

    public JTable getTable() {
        return table;
    }

    private static class CreditsTableModel extends AbstractTableModel {
        private final String[] columnNames = {"Credits"};
        private final String[][] data = {
            {"CREDITS"},
            {"DEVELOPER: ---"},
            {"DESIGNER: ----"},
            {"Special Thanks"}
        };

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }
}
