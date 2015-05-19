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
    private DatabaseManager databasemanager;

    private JLabel picture;
    private JList lijst1;
    private JList lijst2;
    private JList lijst3;
    private JSplitPane splitPane;
    private JPanel lijsten;
    private ArrayList<KoeriersDienst> koeriersDiensten;
    private ArrayList<AccountHouder> accountHouders;
    private ArrayList<TreinKoerier> treinKoeriers;

    public ContactOverzichtPanel(DatabaseManager databaseManager) {
        
        koeriersDiensten = databaseManager.getKoeriersDiensten();
        accountHouders = databaseManager.getAccountHouders();
        treinKoeriers = databaseManager.getTreinKoeriers();
        this.databasemanager = databaseManager;
        //Layout scherm
        String comboBoxItems[] = {comboBoxItem1, comboBoxItem2, comboBoxItem3};
        jbNieuwKoerier = new JButton("Koeriersdienst toevoegen");
        jbNieuwKoerier.addActionListener(this);
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
//        comboBoxPane.add(cb);
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
        
        DefaultListModel lijstModel3 = new DefaultListModel();
        for (KoeriersDienst koeriersDienst : koeriersDiensten){
            int contactID = koeriersDienst.getContactID();
            String naam = koeriersDienst.getNaam();
            
            lijstModel3.addElement(contactID + " " + naam);
        }
        
        lijst1 = new JList(lijstModel);
        lijst1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lijst1.setSelectedIndex(0);
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
        //cb.setBounds(0,0,100, 30);
        //lijsten.setBounds(0,30,200,100);
       
        
        JScrollPane lijstScrollPane = new JScrollPane(lijsten);
        picture = new JLabel();
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);

        
        lijstPanel.add(sorteerPanel, BorderLayout.NORTH);
        lijstPanel.add(lijstScrollPane);
        
        JScrollPane pictureScrollPane = new JScrollPane(picture);

        //Create a split pane with the two scroll panes in it.
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
        lijstPanel, pictureScrollPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(320);

        //Provide minimum sizes for the two components in the split pane.
        Dimension minimumSize = new Dimension(100, 50);
        lijstScrollPane.setMinimumSize(minimumSize);
        pictureScrollPane.setMinimumSize(minimumSize);

        //Provide a preferred size for the split pane.
        splitPane.setPreferredSize(new Dimension(800, 200));
        add(splitPane);
    }


    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (lijsten.getLayout());
        cl.show(lijsten, (String) evt.getItem());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbNieuwKoerier) {
            KoerierToevoegenDialoog dialoog = new KoerierToevoegenDialoog(databasemanager);
            dialoog.setVisible(true);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


