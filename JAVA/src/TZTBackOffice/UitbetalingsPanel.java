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
import java.util.HashMap;
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
    final static String Openstaand = "Openstaande aanvragen";
    final static String Afgehandeld = "Afgehandelde aanvragen";

    private JPanel categoriePanel;
    private HashMap<String, PakketTabelPanel> sorteerCategorieën;
    private JComboBox cb;

    public UitbetalingsPanel() {
        //Layout scherm
        String comboBoxItems[] = {Openstaand, Afgehandeld};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
//        comboBoxPane.add(cb);

        //Create the "cards".
        JPanel card1 = new JPanel();

        DefaultTableModel dmAangemeld = new DefaultTableModel();

        dmAangemeld.setDataVector(new Object[][]{{"77777", "16:44 PM", "20:04 PM", "24/4/15", "Openstaand BV", "30x40x10", "476 g", "Betaald", "Meer info"},
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

        dmVerzonden.setDataVector(new Object[][]{{"77777", "16:44 PM", "20:04 PM", "24/4/15", "Afgehandeld BV", "30x40x10", "476 g", "Betaald", "Meer info"},
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

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, Openstaand);
        cards.add(card2, Afgehandeld);
        add(cb);
        add(cards, BorderLayout.CENTER);

        setVisible(true);

//        pane.add(comboBoxPane, BorderLayout.PAGE_START);
//        pane.add(cards, BorderLayout.CENTER);
    }

    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = {Openstaand, Afgehandeld};
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
        cards.add(card1, Openstaand);
        cards.add(card2, Afgehandeld);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
