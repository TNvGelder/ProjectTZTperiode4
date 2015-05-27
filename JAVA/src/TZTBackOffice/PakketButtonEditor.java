/*
 * Gemaakt door: Jasper
 * Aangepast door: Twan
 * Functie: Maakt de knop in PakketOverzichtPanel tabel werkend en opent PakketInfoDialoog wanneer er op een knop gedrukt is
 */
package TZTBackOffice;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;

public class PakketButtonEditor extends DefaultCellEditor {

    private ArrayList<Pakket> pakketten;
    private JFrame hoofdscherm;

    public PakketButtonEditor(JCheckBox checkBox, JFrame hoofdscherm, ArrayList<Pakket> pakketten) {
        super(checkBox);
        this.pakketten = pakketten;

        this.hoofdscherm = hoofdscherm;
        //button = new JButton("meer");
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        //Open PakketInfoDialoog bij indrukken van knop
        Pakket pakket = pakketten.get(row);
        PakketInfoDialoog dialoog = new PakketInfoDialoog(pakket, hoofdscherm);
        dialoog.setVisible(true);
        return null;
    }

}
