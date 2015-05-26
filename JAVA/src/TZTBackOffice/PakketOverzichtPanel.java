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
import javax.swing.JFrame;
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
    private JFrame hoofdscherm;
    DatabaseManager databaseManager = new DatabaseManager();
    ArrayList<Pakket> pakketten = databaseManager.getPakketten();

    public PakketOverzichtPanel(DatabaseManager databasemanager, JFrame hoofdscherm) {

        setLayout(new BorderLayout());
//        comboBoxPane.add(cb);
        
        //Create the "cards".
        //refresh();

        setVisible(true);
    }

    public void maakCategorie(String categorieNaam) {
        ArrayList<Pakket> pakketArray;
        PakketTabelPanel card;
        if (!categorieNaam.equals("Alle Pakketten")){
            card = new PakketTabelPanel(hoofdscherm, pakketten);
        }else {
            card = new PakketTabelPanel(hoofdscherm);
        }
        

        sorteerCategorieën.put(categorieNaam, card);
        cb.addItem(categorieNaam);
        cards.add(card, categorieNaam);
    }

    public void refresh() {
        this.removeAll();
        categoriePanel = new JPanel();
        add(categoriePanel, BorderLayout.NORTH);
        sorteerCategorieën = new HashMap();
        cards = new JPanel(new CardLayout());

        cb = new JComboBox();
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
        maakCategorie("Alle Pakketten");
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


}
