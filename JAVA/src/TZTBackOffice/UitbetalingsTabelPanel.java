/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Twan
 */
public class UitbetalingsTabelPanel extends JPanel {

    private DefaultTableModel tableModel;
    private JTable table = new JTable();
    private JFrame hoofdscherm;
    private ArrayList<UitbetalingsVerzoek> verzoeken;
    private boolean vulArray = false;

    //Als 
    public UitbetalingsTabelPanel(JFrame hoofdscherm) {
        this.verzoeken = new ArrayList();
        this.hoofdscherm = hoofdscherm;

        String col[] = {"Datum", "Naam", "Bedrag", "IBAN", "", ""};
        tableModel = new DefaultTableModel(col, 0) {
            //Zorg dat de tabel niet te bewerken is
            @Override
            public boolean isCellEditable(int data, int columns) {
                if (columns == 6 || columns == 7) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        System.out.println(table.getColumnCount());
        table.setModel(tableModel);
        table.getColumnModel().getColumn(0).setMinWidth(100);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(100);
        table.getColumnModel().getColumn(3).setMinWidth(100);
        table.getColumnModel().getColumn(4).setMinWidth(100);
        TableColumn afkeurColumn = table.getColumnModel().getColumn(6);
        TableColumn afhandelColumn = table.getColumnModel().getColumn(6);
        afhandelColumn.setMinWidth(100);
        afkeurColumn.setMinWidth(100);
        ButtonRenderer buttonRenderer = new ButtonRenderer();
        afhandelColumn.setCellRenderer(buttonRenderer);
        afkeurColumn.setCellRenderer(buttonRenderer);
//        PakketButtonEditor editor = new PakketButtonEditor(new JCheckBox(), hoofdscherm, verzoeken);
//        afhandelColumn.setCellEditor(editor);
//        afkeurColumn.setCellEditor(editor);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1000, scrollPane.getPreferredSize().height));
        scrollPane.getViewport().setBackground(Color.WHITE);
        add(scrollPane);
    }

    public void voegVerzoekToe(UitbetalingsVerzoek verzoek) {
        verzoeken.add(verzoek);
        
        try {
            TreinKoerier koerier = (TreinKoerier) verzoek.getKoerier();
            Timestamp datum = verzoek.getDatum();
            String naam = koerier.toString();
            Double bedrag = verzoek.getBedrag();
            String rekeningnr = koerier.getRekeningnr();
            Object[] data = {datum, naam, bedrag, rekeningnr};
            

            tableModel.addRow(data);
            table.setModel(tableModel);
        } catch (ClassCastException ex) {

        }

    }
}
