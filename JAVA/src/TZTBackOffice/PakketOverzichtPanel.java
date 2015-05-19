/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jasper
 */
public class PakketOverzichtPanel extends JPanel implements ItemListener {

    private PakketTonen pakkettonen;

    JPanel cards; //a panel that uses CardLayout
    final static String Aangemelde = "Aangemelde pakketten";
    final static String Verzonden = "Verzonden pakketten";
    final static String Gearriveerde = "Gearriveerde pakketten";
    private Pakket pakket;

    private final DatabaseManager databasemanager;
    DatabaseManager databaseManager = new DatabaseManager();
    ArrayList<Pakket> pakketten = databaseManager.getPakketten();

    public PakketOverzichtPanel(DatabaseManager databasemanager) {
        this.databasemanager = databasemanager;

        //Layout scherm
        String comboBoxItems[] = {Aangemelde, Verzonden, Gearriveerde};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
//        comboBoxPane.add(cb);

        //Create the "cards".
        JPanel card1 = new JPanel();
//        System.out.println("De pakketten:");
//        System.out.println(databasemanager.getPakketten());

//        pakketten = databasemanager.getPakketten();
//        Object[][] res = new Object[pakketten.size()][];
//        pakketten.toArray(res);
//        pakketten.ind
        System.out.println("De inhoud van die dingen:");

//        JTable tableAangemeld = new JTable();
//        DefaultTableModel dmAangemeld = new DefaultTableModel();
//
//        tableAangemeld.setModel(dmAangemeld);
//        dmAangemeld.setColumnIdentifiers(new String[]{"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", "Details"});
        String col[] = {"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", "Details"};

        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        JTable table = new JTable(tableModel);

// Populate the JTable (TableModel) with data from ArrayList
        int i = 0;
        for (Object s : pakketten) {

            int strPakketnr = pakketten.get(i).getPakketID();
//            int strAanmeldtijd = pakketten.get(i).;
//            int strAflevertijd = pakketten.get(i).getPakketID();
//            int strDatum = pakketten.get(i);
//            int strOrganisatie = pakketten.get(i).get;
            String strFormaat = pakketten.get(i).getFormaat();
            double strGewicht = pakketten.get(i).getGewicht();
//            int strBetaald = pakketten.get(i).get
            String strDetails = "Meer info";
            String strAanmeldtijd = "14";
            String strAflevertijd = "18";
            String strDatum = "23-47-2015";
            String strOrganisatie = "organisatie";
            String strBetaald = "JA";

            Object[] data = {strPakketnr, strAanmeldtijd, strAflevertijd, strDatum, strOrganisatie, strFormaat,
                strGewicht, strBetaald, strDetails};

//            dmAangemeld.addRow(new Object[]{pakketten.get(i)});
            tableModel.addRow(data);
            i++;
        }

//        dmAangemeld.setDataVector(new Object[][]{{pakketten.get(0)}},
//                new Object[]{"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", "Details"});
//
//
//        JTable tableAangemeld = new JTable(dmAangemeld);
        table.getColumn("Details").setCellRenderer(new ButtonRenderer());
        table.getColumn("Details").setCellEditor(new ButtonEditor(new JCheckBox()));
        table.setPreferredScrollableViewportSize(new Dimension(800, 140));
        JScrollPane scrollAangemeld = new JScrollPane(table);
        card1.add(scrollAangemeld);

        JPanel card2 = new JPanel();
        DefaultTableModel dmVerzonden = new DefaultTableModel();

        dmVerzonden.setDataVector(new Object[][]{{"77777", "16:44 PM", "20:04 PM", "24/4/15", "Verzonden BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"}},
                new Object[]{"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", "Details"});

        JTable tableVerzonden = new JTable(dmVerzonden);
        tableVerzonden.getColumn("Details").setCellRenderer(new ButtonRenderer());
        tableVerzonden.getColumn("Details").setCellEditor(new ButtonEditor(new JCheckBox()));
        tableVerzonden.setPreferredScrollableViewportSize(new Dimension(800, 140));
        JScrollPane scrollVerzonden = new JScrollPane(tableVerzonden);
        card2.add(scrollVerzonden);

        JPanel card3 = new JPanel();
        DefaultTableModel dmGearriveerd = new DefaultTableModel();

        dmGearriveerd.setDataVector(new Object[][]{{"77777", "16:44 PM", "20:04 PM", "24/4/15", "Gearriveerd BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"}},
                new Object[]{"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", "Details"});

        JTable tableGearriveerd = new JTable(dmGearriveerd);
        tableGearriveerd.getColumn("Details").setCellRenderer(new ButtonRenderer());
        tableGearriveerd.getColumn("Details").setCellEditor(new ButtonEditor(new JCheckBox()));
        tableGearriveerd.setPreferredScrollableViewportSize(new Dimension(800, 140));
        JScrollPane scrollGearriveerd = new JScrollPane(tableGearriveerd);
        card3.add(scrollGearriveerd);

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, Aangemelde);
        cards.add(card2, Verzonden);
        cards.add(card3, Gearriveerde);
        add(cb);
        add(cards, BorderLayout.CENTER);

        setVisible(true);

//        pane.add(comboBoxPane, BorderLayout.PAGE_START);
//        pane.add(cards, BorderLayout.CENTER);
    }

    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = {Aangemelde, Verzonden, Gearriveerde};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
        comboBoxPane.add(cb);

        //Create the "cards".
        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));

        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));

        JPanel card3 = new JPanel();
        card3.add(new JTextField("swag", 5));

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, Aangemelde);
        cards.add(card2, Verzonden);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event dispatch thread.
     */
//    private static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("Buttons");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //Create and set up the content pane.
//        PakketOverzichtPanel demo = new PakketOverzichtPanel();
//        demo.addComponentToPane(frame.getContentPane());
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        /* Use an appropriate Look and Feel */
//        try {
//            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//        } catch (UnsupportedLookAndFeelException ex) {
//            ex.printStackTrace();
//        } catch (IllegalAccessException ex) {
//            ex.printStackTrace();
//        } catch (InstantiationException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        /* Turn off metal's use of bold fonts */
//        UIManager.put("swing.boldMetal", Boolean.FALSE);
//
//        //Schedule a job for the event dispatch thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }
}
