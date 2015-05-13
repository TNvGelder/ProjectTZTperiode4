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
public class UitbetalingsPanel extends JPanel implements ItemListener {

    JPanel cards; //a panel that uses CardLayout
    final static String Aangemelde = "Aangemelde pakketten";
    final static String Verzonden = "Verzonden pakketten";
    final static String Gearriveerde = "Gearriveerde pakketten";

    public UitbetalingsPanel() {
        //Layout scherm
        String comboBoxItems[] = {Aangemelde, Verzonden, Gearriveerde};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
//        comboBoxPane.add(cb);

        //Create the "cards".
        JPanel card1 = new JPanel();

        DefaultTableModel dmAangemeld = new DefaultTableModel();

        dmAangemeld.setDataVector(new Object[][]{{"77777", "16:44 PM", "20:04 PM", "24/4/15", "Aangemeld BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald", "Meer info"}},
                new Object[]{"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", "Details"});

        JTable tableAangemeld = new JTable(dmAangemeld);
        tableAangemeld.getColumn("Details").setCellRenderer(new ButtonRenderer());
        tableAangemeld.getColumn("Details").setCellEditor(new ButtonEditor(new JCheckBox()));
        tableAangemeld.setPreferredScrollableViewportSize(new Dimension(800, 140));
        JScrollPane scrollAangemeld = new JScrollPane(tableAangemeld);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
