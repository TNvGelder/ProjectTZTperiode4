/*
 * Gemaakt door: Jasper - opzet gemaakt in oud document
 * Aangepast door: Twan - bestand voornamelijk gemaakt door Twan
 * Functie: Maakt een tabel waarin de verschillende pakketten getond worden
 */
package TZTBackOffice;

import java.awt.Color;
import java.awt.Dimension;
import static java.nio.file.Files.delete;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class PakketTabelPanel extends JPanel {

    private DefaultTableModel tableModel;
    private JTable table = new JTable();
    private JFrame hoofdscherm;
    private ArrayList<Pakket> pakketten;
    private boolean vulArray = false;

    //Als
    public PakketTabelPanel(JFrame hoofdscherm) {
        this(hoofdscherm, new ArrayList());
        vulArray = true;
    }

    public PakketTabelPanel(JFrame hoofdscherm, ArrayList<Pakket> pakketten) {
        this.pakketten = pakketten;
        this.hoofdscherm = hoofdscherm;

        String col[] = {"Ordernr", "Pakketnr", "Status", "Aanmeldtijd", "Aflevertijd", "Afzender", "Formaat", "Gewicht", "Betaald", "Details"};
        tableModel = new DefaultTableModel(col, 0) {
            //Zorg dat de tabel niet te bewerken is
            @Override
            public boolean isCellEditable(int data, int columns) {
                if (columns == 9) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        System.out.println(table.getColumnCount());
        table.setModel(tableModel);
        table.getColumnModel().getColumn(0).setMinWidth(75);
        table.getColumnModel().getColumn(1).setMinWidth(75);
        table.getColumnModel().getColumn(2).setMinWidth(100);
        table.getColumnModel().getColumn(3).setMinWidth(100);
        table.getColumnModel().getColumn(4).setMinWidth(100);
        table.getColumnModel().getColumn(5).setMinWidth(100);
        table.getColumnModel().getColumn(6).setMinWidth(100);
        table.getColumnModel().getColumn(7).setMinWidth(50);
        table.getColumnModel().getColumn(8).setMinWidth(100);
        TableColumn detailColumn = table.getColumn("Details");
        detailColumn.setCellRenderer(new ButtonRenderer("meer"));
        detailColumn.setCellEditor(new PakketButtonEditor(new JCheckBox(), hoofdscherm, pakketten));
        detailColumn.setMinWidth(100);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(950, scrollPane.getPreferredSize().height));
        scrollPane.getViewport().setBackground(Color.WHITE);
        add(scrollPane);
    }

    public void voegPakketToe(Pakket pakket) {
        if (vulArray) {
            pakketten.add(pakket);
        }
        int strPakketnr = pakket.getPakketID();

        VerzendOrder order = pakket.getOrder();
        Timestamp strAanmeldtijd = order.getAanmeldTijd();

        int orderID = order.getOrderID();
        String strOrganisatie = order.getKlant().toString();
        String strFormaat = pakket.getFormaat();
        double strGewicht = pakket.getGewicht();
        boolean intBetaald = pakket.getDefinitief();
        String strBetaald = "Betaald";
        String status = pakket.getStatus();
        if (!intBetaald) {
            strBetaald = "Niet Betaald";
        }
        ArrayList<Traject> trajecten = pakket.getTrajecten();

        Timestamp aflevertijd = null;
        if (trajecten.size() > 0) {
            Traject laatsteTraject = trajecten.get(trajecten.size() - 1);
            aflevertijd = laatsteTraject.getAfleverTijdstip();
        }

        Object[] data = {orderID, strPakketnr, status, strAanmeldtijd, aflevertijd, strOrganisatie, strFormaat,
            strGewicht, strBetaald};
        TableColumn column = table.getColumn("Details");

        tableModel.addRow(data);
        table.setModel(tableModel);

    }
}
