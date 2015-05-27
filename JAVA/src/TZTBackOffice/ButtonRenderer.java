/*
 * Gemaakt door: Jasper
 * Aangepast door: Twan
 * Functie: Zorgt voor de vormgeving van de knoppen in JTable
 */
package TZTBackOffice;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer(String naam) {
        super(naam);
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        String naam = this.getText();
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText(naam);
        return this;
    }
}
