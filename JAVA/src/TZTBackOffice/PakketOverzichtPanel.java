package TZTBackOffice;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private JPanel categoriePanel;
    private HashMap<String, PakketTabelPanel> sorteerCategorieën;
    private JComboBox cb;

    private final DatabaseManager databasemanager;
    DatabaseManager databaseManager = new DatabaseManager();
    ArrayList<Pakket> pakketten = databaseManager.getPakketten();

    public PakketOverzichtPanel(DatabaseManager databasemanager) {
        this.databasemanager = databasemanager;
        setLayout(new BorderLayout());
//        comboBoxPane.add(cb);
        categoriePanel = new JPanel();
        add(categoriePanel, BorderLayout.NORTH);
        //Create the "cards".
        refresh();

        setVisible(true);

//        pane.add(comboBoxPane, BorderLayout.PAGE_START);
//        pane.add(cards, BorderLayout.CENTER);
    }

    public void maakCategorie(String categorieNaam) {
        PakketTabelPanel card = new PakketTabelPanel();

        sorteerCategorieën.put(categorieNaam, card);
        cb.addItem(categorieNaam);
        cards.add(card, categorieNaam);
    }

    public void refresh() {
        sorteerCategorieën = new HashMap();
        cards = new JPanel(new CardLayout());

        cb = new JComboBox();
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
        maakCategorie("Alle Pakketten");

//        for (String categorie : sorteerCategorieën.keySet()) {
//            cb.addItem(categorie);
//            JPanel card = new JPanel();
//            cards.add(card, categorie);
//        }
        categoriePanel.add(cb);
        add(cards);

        // Populate the JTable (TableModel) with data from ArrayList
        for (Pakket pakket : pakketten) {
            //Bekijk status van pakket

            String strStatus = pakket.getStatus();
            if (!sorteerCategorieën.containsKey(strStatus)) {
                maakCategorie(strStatus);
            }

            PakketTabelPanel pakketTabel = sorteerCategorieën.get(strStatus);
            pakketTabel.voegPakketToe(pakket);
            PakketTabelPanel pakketTabel2 = sorteerCategorieën.get("Alle Pakketten");
            pakketTabel2.voegPakketToe(pakket);
            String strBetaald = null;

        }

    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }

    public void shit() {
        JPanel card1 = new JPanel();
//        System.out.println("De pakketten:");
//        System.out.println(databasemanager.getPakketten());

//        pakketten = databasemanager.getPakketten();
//        Object[][] res = new Object[pakketten.size()][];
//        pakketten.toArray(res);
//        pakketten.ind
//        JTable tableAangemeld = new JTable();
//        DefaultTableModel dmAangemeld = new DefaultTableModel();
//
//        tableAangemeld.setModel(dmAangemeld);
//        dmAangemeld.setColumnIdentifiers(new String[]{"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", "Details"});
        String col[] = {"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", "Details"};

        DefaultTableModel tableModel = new DefaultTableModel(col, 0) {

        };

        JTable table = new JTable(tableModel);

// Populate the JTable (TableModel) with data from ArrayList
        int i = 0;
        for (Pakket s : pakketten) {
            //Bekijk status van pakket

            System.out.println(s);
            String strStatus = pakketten.get(i).getStatus();
            String strBetaald = null;

            if (strStatus.equals("Aangemeld")) {
                int strPakketnr = pakketten.get(i).getPakketID();

                Timestamp strAanmeldtijd = pakketten.get(i).getOrder().getAanmeldTijd();

                String strOrganisatie = pakketten.get(i).getOrder().getKlant().getNaam();
                String strFormaat = pakketten.get(i).getFormaat();
                double strGewicht = pakketten.get(i).getGewicht();
                boolean intBetaald = pakketten.get(i).getDefinitief();
                if (intBetaald == true) {
                    strBetaald = "Betaald";
                } else {
                    strBetaald = "-";
                }

                //                String strAflevertijd = "18 - niet uit DB";
//                Timestamp strAflevertijd = pakketten.get(0).getTrajecten().get(0).getAfleverTijdstip();
                Timestamp strAflevertijd = null;
                int x = 0;
                for (Traject t : pakketten.get(i).getTrajecten()) {
                    System.out.println("In loop!!!!!!!!!!");
                    if (x == 0) {
                        strAflevertijd = t.getAfleverTijdstip();
                    }
                    x++;
                    System.out.println("De aflevertijd: " + strAflevertijd);

                }

                String strDatum = "23-47-2015 - niet uit DB";
                //            int strDatum = pakketten.get(i);
                String strDetails = "Meer info";

                Object[] data = {strPakketnr, strAanmeldtijd, strAflevertijd, strDatum, strOrganisatie, strFormaat,
                    strGewicht, strBetaald, strDetails};

                tableModel.addRow(data);
            }

            i++;
        }

        table.getColumn("Details").setCellRenderer(new ButtonRenderer());
        table.getColumn("Details").setCellEditor(new ButtonEditor(new JCheckBox()));
        table.setPreferredScrollableViewportSize(new Dimension(800, 140));
        JScrollPane scrollAangemeld = new JScrollPane(table);
        card1.add(scrollAangemeld);

//        System.out.println("geselecteerd: " + table.getSelectedRow());
//
//        int trajectPanelY = 50;
////        dmAangemeld.setDataVector(new Object[][]{{pakketten.get(0)}},
////                new Object[]{"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", "Details"});
////
////
////        JTable tableAangemeld = new JTable(dmAangemeld);
//        JPanel card2 = new JPanel();
//        DefaultTableModel dmVerzonden = new DefaultTableModel();
//
//        dmVerzonden.setDataVector(new Object[][]{{"77777", "16:44 PM", "20:04 PM", "24/4/15", "Verzonden BV", "30x40x10", "476 g", "Betaald", "Meer info"},
//        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
//        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
//        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
//        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
//        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
//        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"}},
//                new Object[]{"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", "Details"});
//
//        JTable tableVerzonden = new JTable(dmVerzonden);
//        tableVerzonden.getColumn("Details").setCellRenderer(new ButtonRenderer());
//        tableVerzonden.getColumn("Details").setCellEditor(new ButtonEditor(new JCheckBox()));
//        tableVerzonden.setPreferredScrollableViewportSize(new Dimension(800, 140));
//        JScrollPane scrollVerzonden = new JScrollPane(tableVerzonden);
//        card2.add(scrollVerzonden);
//
//        JPanel card3 = new JPanel();
//        DefaultTableModel dmGearriveerd = new DefaultTableModel();
//
//        dmGearriveerd.setDataVector(new Object[][]{{"77777", "16:44 PM", "20:04 PM", "24/4/15", "Gearriveerd BV", "30x40x10", "476 g", "Betaald", "Meer info"},
//        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
//        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
//        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
//        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
//        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
//        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"}},
//                new Object[]{"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", "Details"});
//
//        JTable tableGearriveerd = new JTable(dmGearriveerd);
//        tableGearriveerd.getColumn("Details").setCellRenderer(new ButtonRenderer());
//        tableGearriveerd.getColumn("Details").setCellEditor(new ButtonEditor(new JCheckBox()));
//        tableGearriveerd.setPreferredScrollableViewportSize(new Dimension(800, 140));
//        JScrollPane scrollGearriveerd = new JScrollPane(tableGearriveerd);
//        card3.add(scrollGearriveerd);
        //Create the panel that contains the "cards".
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
