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
    private JSplitPane splitPane;
    private JPanel lijsten;
    private ArrayList<KoeriersDienst> koeriersDiensten;
    private ArrayList<AccountHouder> accountHouders;
    private ArrayList<TreinKoerier> treinKoeriers;
    private JPanel infoPanel;
    private Contact geselecteerdContact;

    public ContactOverzichtPanel(DatabaseManager databaseManager) {
        
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

        
        this.setLayout(new GridLayout(1, 1));
        DefaultListModel lijstModel =  new DefaultListModel();
        for (AccountHouder accountHouder : accountHouders) {
            int contactID = accountHouder.getContactID();
            String naam = accountHouder.getNaam() + " " + accountHouder.getAchternaam();
            
            lijstModel.addElement(contactID + " " + naam);
        }
        
        DefaultListModel lijstModel2 = new DefaultListModel();
        for (TreinKoerier treinKoerier : treinKoeriers){
            int contactID = treinKoerier.getContactID();
            String naam = treinKoerier.getNaam() + " " + treinKoerier.getAchternaam();
            
            lijstModel2.addElement(contactID + " " + naam);
        }
        
        KoeriersDienst k = null;
        DefaultListModel lijstModel3 = new DefaultListModel();
        for (KoeriersDienst koeriersDienst : koeriersDiensten){
            int contactID = koeriersDienst.getContactID();
            String naam = koeriersDienst.getNaam();
            k = koeriersDienst;
            lijstModel3.addElement(contactID + " " + naam);
        }
        
        lijst1 = new JList(lijstModel);
        lijst1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        lijst1.addListSelectionListener(this);
        
        
        lijst2 = new JList(lijstModel2);
        lijst2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lijst2.setSelectedIndex(0);
        lijst2.addListSelectionListener(this);
        
        
        lijst3 = new JList(lijstModel3);
        lijst3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lijst3.setSelectedIndex(0);
        lijst3.addListSelectionListener(this);
        
        JPanel lijstPanel = new JPanel();
        lijstPanel.setLayout(new BorderLayout());
        
        lijsten = new JPanel(new CardLayout());
        lijsten.add(lijst1, comboBoxItem1);
        lijsten.add(lijst2, comboBoxItem2);
        lijsten.add(lijst3, comboBoxItem3);
       
        
        JScrollPane lijstScrollPane = new JScrollPane(lijsten);
        infoPanel = new JPanel(new GridLayout(1,1));

        
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
        
        lijst1.setSelectedIndex(0);
        splitPane.setPreferredSize(new Dimension(800, 200));
        add(splitPane);
    }

    //Herbouwt onderdelen van het scherm, zodat het overeenkomt met de gegevens uit databaseManager.
    public void refresh(){
        koeriersDiensten = databaseManager.getKoeriersDiensten();
        accountHouders = databaseManager.getAccountHouders();
        treinKoeriers = databaseManager.getTreinKoeriers();
    }
    
    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (lijsten.getLayout());
        String item = (String) evt.getItem();
        if (item.equals(comboBoxItem1)){
            selectieVeranderd(lijst1);
        }else if (item.equals(comboBoxItem2)){
            selectieVeranderd(lijst2);
        }else {
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

    public void toonContactInfo(Contact c){
        infoPanel.removeAll();
        if (c instanceof AccountHouder){
            infoPanel.add(new AccountHoudersInfoPanel((AccountHouder) c));
        }else if(c instanceof TreinKoerier){
            infoPanel.add(new TreinKoeriersInfoPanel((TreinKoerier) c));
        }
        else if (c instanceof KoeriersDienst){
            infoPanel.add(new KoeriersInfoPanel((KoeriersDienst) c));
        }
        
        
        infoPanel.validate();
        infoPanel.repaint();
    }
    
    public void selectieVeranderd(JList list){
        Contact c;
        if (list == lijst1){
            c = accountHouders.get(list.getSelectedIndex());
        }else if(list == lijst2){
            c = treinKoeriers.get(list.getSelectedIndex());
        } else {
            c = koeriersDiensten.get(list.getSelectedIndex());
        }
        if (c != geselecteerdContact){
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
        System.out.println("sdfasdf");
        JList list = (JList) e.getSource();
        selectieVeranderd(list);
        
    }
}


