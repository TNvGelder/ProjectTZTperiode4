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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Twan
 */
public class ContactOverzichtPanel extends JPanel implements ItemListener, ActionListener, ListSelectionListener {

    JPanel cards; //a panel that uses CardLayout
    private final String comboBoxItem1 = "Accounthouders";
    private final String comboBoxItem3 = "Koeriersdienst";
    private final String comboBoxItem2 = "Treinkoerier";
    private JButton jbNieuwKoerier;
    private DatabaseManager databaseManager;

    private JList lijst1;
    private JList lijst2;
    private JList lijst3;
    private JList geselecteerdeJList;
    private JSplitPane splitPane;
    private JPanel lijsten;
    private ArrayList<KoeriersDienst> koeriersDiensten;
    private ArrayList<AccountHouder> accountHouders;
    private ArrayList<TreinKoerier> treinKoeriers;
    private JPanel infoPanel;
    private Contact geselecteerdContact;

    public ContactOverzichtPanel(DatabaseManager databaseManager) {

        this.setLayout(new GridLayout(1, 1));
        koeriersDiensten = databaseManager.getKoeriersDiensten();
        accountHouders = databaseManager.getAccountHouders();
        treinKoeriers = databaseManager.getTreinKoeriers();
        this.databaseManager = databaseManager;
        //Layout scherm
        String comboBoxItems[] = {comboBoxItem1, comboBoxItem2, comboBoxItem3};
        jbNieuwKoerier = new JButton("Koeriersdienst toevoegen");
        jbNieuwKoerier.addActionListener(this);
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
        JPanel sorteerPanel = new JPanel(new FlowLayout());
        sorteerPanel.add(cb);
        sorteerPanel.add(jbNieuwKoerier);

        lijst1 = new JList();
        lijst1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lijst1.addListSelectionListener(this);


        lijst2 = new JList();
        lijst2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lijst2.addListSelectionListener(this);

        lijst3 = new JList();
        lijst3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lijst3.addListSelectionListener(this);

        JPanel lijstPanel = new JPanel();
        lijstPanel.setLayout(new BorderLayout());

        lijsten = new JPanel(new CardLayout());
        lijsten.add(lijst1, comboBoxItem1);
        lijsten.add(lijst2, comboBoxItem2);
        lijsten.add(lijst3, comboBoxItem3);

        JScrollPane lijstScrollPane = new JScrollPane(lijsten);
        infoPanel = new JPanel(new GridLayout(1, 1));

        lijstPanel.add(sorteerPanel, BorderLayout.NORTH);
        lijstPanel.add(lijstScrollPane);

        JScrollPane infoScrollPane = new JScrollPane(infoPanel);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                lijstPanel, infoScrollPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(320);

        Dimension minimumSize = new Dimension(100, 50);
        lijstScrollPane.setMinimumSize(minimumSize);
        infoScrollPane.setMinimumSize(minimumSize);
        geselecteerdeJList = lijst1;
        refresh();

        splitPane.setPreferredSize(new Dimension(800, 200));
        add(splitPane);
    }

    //Herbouwt onderdelen van het scherm, zodat het overeenkomt met de gegevens uit databaseManager.
    public final void refresh() {
        JList huidigeJList = geselecteerdeJList;
        int index = huidigeJList.getSelectedIndex();
        koeriersDiensten = databaseManager.getKoeriersDiensten();
        accountHouders = databaseManager.getAccountHouders();
        treinKoeriers = databaseManager.getTreinKoeriers();
        
        DefaultListModel lijstModel = new DefaultListModel();
        for (AccountHouder accountHouder : accountHouders) {
            int contactID = accountHouder.getContactID();
            String naam = accountHouder.getNaam() + " " + accountHouder.getAchternaam();

            lijstModel.addElement(contactID + " " + naam);
        }

        DefaultListModel lijstModel2 = new DefaultListModel();
        for (TreinKoerier treinKoerier : treinKoeriers) {
            int contactID = treinKoerier.getContactID();
            String naam = treinKoerier.getNaam() + " " + treinKoerier.getAchternaam();

            lijstModel2.addElement(contactID + " " + naam);
        }

        DefaultListModel lijstModel3 = new DefaultListModel();
        for (KoeriersDienst koeriersDienst : koeriersDiensten) {
            int contactID = koeriersDienst.getContactID();
            String naam = koeriersDienst.getNaam();
            KoeriersDienst k = koeriersDienst;
            lijstModel3.addElement(contactID + " " + naam);
        }
        lijst1.setModel(lijstModel);
        lijst2.setModel(lijstModel2);
        lijst3.setModel(lijstModel3);
        huidigeJList.setSelectedIndex(index);
        selectieVeranderd(huidigeJList);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (lijsten.getLayout());
        String item = (String) evt.getItem();
        if (item.equals(comboBoxItem1)) {
            selectieVeranderd(lijst1);
        } else if (item.equals(comboBoxItem2)) {
            selectieVeranderd(lijst2);
        } else {
            selectieVeranderd(lijst3);
        }
        cl.show(lijsten, item);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbNieuwKoerier) {
            KoerierToevoegenDialoog dialoog = new KoerierToevoegenDialoog(databaseManager, this);
            dialoog.setVisible(true);
        }
    }

    //Kijkt welke klasse het contact is en toont het contact op bijbehorende manier.
    public void toonContactInfo(Contact c) {
        infoPanel.removeAll();
        if (c instanceof TreinKoerier) {
            infoPanel.add(new TreinKoeriersInfoPanel((TreinKoerier) c));
        } else if (c instanceof AccountHouder) {
            infoPanel.add(new AccountHoudersInfoPanel((AccountHouder) c, databaseManager));
        } else if (c instanceof KoeriersDienst) {
            infoPanel.add(new KoeriersInfoPanel((KoeriersDienst) c));
        }

        infoPanel.validate();
        infoPanel.repaint();
    }

    //Deze functie wordt aangeroepen wanneer er van lijst wordt gewisseld of wanneer er een andere pakket wordt aangeklikt op de lijst.
    //De functie zoekt het juiste contact erbij en toont dan vervolgens dit contact.
    public void selectieVeranderd(JList list) {
        geselecteerdeJList = list;
        Contact c = null;
        int index = list.getSelectedIndex();
        if (index < 0){
            index = 0;
        }
        if (list == lijst1 && accountHouders.size() > 0) {
            System.out.println("lijst1");
            if (index >= accountHouders.size()){
                index = 0;
            }
            c = accountHouders.get(index);
        } else if (list == lijst2 && treinKoeriers.size() > 0) {
            System.out.println("lijst2");
            if (index >= treinKoeriers.size()){
                index = 0;
            }
            c = treinKoeriers.get(index);
        } else if (list == lijst3 && koeriersDiensten.size() > 0) {
            System.out.println("lijst3");
            if (index >= koeriersDiensten.size()){
                index = 0;
            }
            c = koeriersDiensten.get(index);
        }
        if (c != null && c != geselecteerdContact) {
            geselecteerdContact = c;
            System.out.println(c);
            toonContactInfo(c);
        }

    }

    public JList getLijst3() {
        return lijst3;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList) e.getSource();
        selectieVeranderd(list);

    }
}
