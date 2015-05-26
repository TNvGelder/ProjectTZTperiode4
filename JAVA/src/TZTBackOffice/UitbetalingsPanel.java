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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jasper
 */
public class UitbetalingsPanel extends JPanel implements ItemListener {

    private PakketTonen pakkettonen;

    JPanel cards; //a panel that uses CardLayout
    final static String Aangemelde = "Aangemelde pakketten";
    final static String Verzonden = "Verzonden pakketten";
    final static String Gearriveerde = "Gearriveerde pakketten";
    private JPanel categoriePanel;
    private JComboBox cb;
    private JFrame hoofdscherm;
    DatabaseManager databaseManager = new DatabaseManager();
    ArrayList<Pakket> pakketten = databaseManager.getPakketten();

    public UitbetalingsPanel(DatabaseManager databasemanager, JFrame hoofdscherm) {

        setLayout(new BorderLayout());
//        comboBoxPane.add(cb);
        
        //Create the "cards".
        //refresh();

        setVisible(true);
    }

    public void maakCategorie(String categorieNaam) {
        ArrayList<Pakket> pakketArray;
        PakketTabelPanel card;
//        if (!categorieNaam.equals("Alle Pakketten")){
//            card = new PakketTabelPanel(hoofdscherm, pakketten);
//        }else {
//            card = new PakketTabelPanel(hoofdscherm);
//        }
        
        cb.addItem(categorieNaam);
        //cards.add(card, categorieNaam);
    }

    public void refresh() {
        this.removeAll();
        categoriePanel = new JPanel();
        add(categoriePanel, BorderLayout.NORTH);
        cards = new JPanel(new CardLayout());

        cb = new JComboBox();
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
        maakCategorie("Niet Afgehandeld");
        maakCategorie("Afgehandeld");
        maakCategorie("Alle Pakketten");
        categoriePanel.add(cb);
        add(cards);

        // Populate the JTable (TableModel) with data from ArrayList
        for (Pakket pakket : pakketten) {
            //Bekijk status van pakket

            String strStatus = pakket.getStatus();
            

//            PakketTabelPanel pakketTabel = sorteerCategorieën.get(strStatus);
//            pakketTabel.voegPakketToe(pakket);
//            PakketTabelPanel pakketTabel2 = sorteerCategorieën.get("Alle Pakketten");
//            pakketTabel2.voegPakketToe(pakket);
//            String strBetaald = null;

        }

    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }

}
