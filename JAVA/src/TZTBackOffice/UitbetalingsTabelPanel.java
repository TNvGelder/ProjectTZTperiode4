/*
 * Gemaakt door: Twan
 * Aangepast door: -
 * Functie: Laat de uitbetalingen zien in een tabel
 */
package TZTBackOffice;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class UitbetalingsTabelPanel extends JPanel {

    private DefaultTableModel tableModel;
    private JTable table = new JTable();
    private JFrame hoofdscherm;
    private ArrayList<UitbetalingsVerzoek> verzoeken;
    private boolean afhandelKnop;
    private UitbetalingsPanel overzicht;

    public UitbetalingsTabelPanel(JFrame hoofdscherm, boolean afhandelKnop, UitbetalingsPanel overzicht) {
        this.verzoeken = new ArrayList();
        this.overzicht = overzicht;
        this.hoofdscherm = hoofdscherm;
        this.afhandelKnop = afhandelKnop;
        String col[] = {"Datum", "Naam", "Bedrag", "IBAN", "Goedgekeurd"};
        tableModel = new DefaultTableModel(col, 0) {
            //Zorg dat de tabel niet te bewerken is
            @Override
            public boolean isCellEditable(int data, int columns) {
                if (columns == 4 && afhandelKnop) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        table.setModel(tableModel);
        table.getColumnModel().getColumn(0).setMinWidth(100);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(100);
        table.getColumnModel().getColumn(3).setMinWidth(100);
        TableColumn afhandelColumn = table.getColumnModel().getColumn(4);
        afhandelColumn.setMinWidth(100);
        if (afhandelKnop) {
            ButtonRenderer buttonRenderer = new ButtonRenderer("handel af");
            afhandelColumn.setCellRenderer(buttonRenderer);
            VerzoekButtonEditor editor = new VerzoekButtonEditor(new JCheckBox(), hoofdscherm, verzoeken, overzicht);
            afhandelColumn.setCellEditor(editor);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, scrollPane.getPreferredSize().height));
        scrollPane.getViewport().setBackground(Color.WHITE);

        //Voeg verzoeken toe aan tabel
        add(scrollPane);
    }

    //Voegt een rij toe aan de tabel met gegevens van het meegegeven verzoek.
    public void voegVerzoekToe(UitbetalingsVerzoek verzoek) {
        try {
            verzoeken.add(verzoek);
            TreinKoerier koerier = (TreinKoerier) verzoek.getKoerier();
            Timestamp datum = verzoek.getDatum();
            String naam = koerier.toString();
            Double bedrag = verzoek.getBedrag();
            String rekeningnr = koerier.getRekeningnr();
            String goedgekeurd;
            if (verzoek.isGoedgekeurd()) {
                goedgekeurd = "Ja";
            } else {
                goedgekeurd = "Nee";
            }
            Object[] data = {datum, naam, bedrag, rekeningnr, goedgekeurd};

            tableModel.addRow(data);
            table.setModel(tableModel);
        } catch (ClassCastException ex) {
            Logger.getLogger("").log(Level.SEVERE, null, ex);
        }

    }
}
