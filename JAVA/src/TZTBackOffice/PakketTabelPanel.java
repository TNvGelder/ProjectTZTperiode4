/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Twan
 */
public class PakketTabelPanel extends JPanel {

    private DefaultTableModel tableModel;
    JTable table = new JTable();

    public PakketTabelPanel() {
        String col[] = {"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Koerier", "Formaat", "Gewicht", "Betaald", "Details"};
        tableModel = new DefaultTableModel(col, 0) {
            //Zorg dat de tabel niet te bewerken is
            @Override
            public boolean isCellEditable(int data, int columns) {
                if (columns == 7) {
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
        table.getColumnModel().getColumn(5).setMinWidth(100);
        table.getColumnModel().getColumn(6).setMinWidth(100);
        table.getColumnModel().getColumn(7).setMinWidth(100);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(900, scrollPane.getPreferredSize().height));
        scrollPane.getViewport().setBackground(Color.WHITE);
        add(scrollPane);

    }

    public void voegPakketToe(Pakket pakket) {
        int strPakketnr = pakket.getPakketID();

        VerzendOrder order = pakket.getOrder();
        Timestamp strAanmeldtijd = order.getAanmeldTijd();

        String strOrganisatie = order.getKlant().toString();
        String strFormaat = pakket.getFormaat();
        double strGewicht = pakket.getGewicht();
        boolean intBetaald = pakket.getDefinitief();
        String strBetaald = "Betaald";
        if (!intBetaald) {
            strBetaald = "Niet Betaald";
        }
        ArrayList<Traject> trajecten = pakket.getTrajecten();

        Timestamp aflevertijd = null;
        if (trajecten.size() > 0) {
            Traject laatsteTraject = trajecten.get(trajecten.size() - 1);
            aflevertijd = laatsteTraject.getAfleverTijdstip();
        }

        String strDetails = pakket.getOpmerking();

        Object[] data = {strPakketnr, strAanmeldtijd, aflevertijd, strOrganisatie, strFormaat,
            strGewicht, strBetaald};
        table.getColumn("Details").setCellRenderer(new ButtonRenderer());
        table.getColumn("Details").setCellEditor(new ButtonEditor(new JCheckBox()));

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("#################################################################################hey");
                String selectedCell1 = table.getValueAt(table.getSelectedRow(), 0).toString();
                int selectedCelltest = Integer.parseInt(selectedCell1);
//                int selectedCelltest = Integer.valueOf(selectedCell1);
                //setSelectedCell(selectedCelltest);
                //getSelectedCell();
                //System.out.println("dit is de cel volgens value: " + getSelectedCell());
                System.out.println("De cel: " + selectedCelltest);

            }
        });

        tableModel.addRow(data);
        table.setModel(tableModel);

    }
}
