/*
 * Gemaakt door: Jasper
 * Aangepast door: Twan
 * Functie: Zorgt voor de vormgeving van de knoppen in JTable
 */
package TZTBackOffice;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer(String naam) {
        super(naam);
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //Maak de opmaak van de knop
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
