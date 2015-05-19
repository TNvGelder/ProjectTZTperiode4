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
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
    private final String comboBoxItem2 = "Accounthouders";
    private final String comboBoxItem1 = "Koeriersdienst";
    private final String comboBoxItem3 = "Treinkoerier";
    private JButton jbNieuwKoerier;
    private DatabaseManager databasemanager;

    private JLabel picture;
    private JList lijst1;
    private JList lijst2;
    private JSplitPane splitPane;
    private JPanel lijsten;
    private String[] imageNames = {"254 Niet Gearriveerd", "253 Te laat", "252 Niet Gearriveerd", "251 Niet Gearriveerd", "250 Niet Gearriveerd", "249 Niet Gearriveerd",
        "248 Te laat", "247 Te laat", "246 Niet Gearriveerd", "245 Niet Gearriveerd", "244 Niet Gearriveerd", "243 Niet Gearriveerd"};
    private String[] afgehandeld = {"254 pakket foetsie", "253 pakket stuk", "252 pakket niet gearriveerd", "251 Niet Gearriveerd", "250 Niet Gearriveerd", "249 Niet Gearriveerd",
        "248 Te laat", "247 Te laat", "246 Niet Gearriveerd", "245 Niet Gearriveerd", "244 Niet Gearriveerd", "243 Niet Gearriveerd"};

    public ContactOverzichtPanel(DatabaseManager databasemanager) {
        this.databasemanager = databasemanager;
        //Layout scherm
        String comboBoxItems[] = {comboBoxItem1, comboBoxItem2, comboBoxItem3};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
//        comboBoxPane.add(cb);

        this.setLayout(new GridLayout(1, 1));

        lijst1 = new JList(imageNames);
        lijst1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lijst1.setSelectedIndex(0);
        lijst1.addListSelectionListener(this);
        
        lijst2 = new JList(afgehandeld);
        lijst2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lijst2.setSelectedIndex(0);
        lijst2.addListSelectionListener(this);
        
        JPanel lijstPanel = new JPanel();
        lijstPanel.setLayout(new BorderLayout());
        
        lijsten = new JPanel(new CardLayout());
        lijsten.add(lijst1, "Problemen");
        lijsten.add(lijst2, "Afgehandelde Problemen");
        //cb.setBounds(0,0,100, 30);
        //lijsten.setBounds(0,30,200,100);
        lijsten.validate();
        lijsten.setPreferredSize(lijst1.getPreferredSize());
        lijstPanel.setPreferredSize(lijst1.getPreferredSize());
       
        
        JScrollPane lijstScrollPane = new JScrollPane(lijsten);
        picture = new JLabel();
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);

        
        lijstPanel.add(cb, BorderLayout.NORTH);
        lijstPanel.add(lijstScrollPane);
        
        JScrollPane pictureScrollPane = new JScrollPane(picture);

        //Create a split pane with the two scroll panes in it.
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
        lijstPanel, pictureScrollPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);

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

//public class ContactOverzichtPanel extends JPanel implements ActionListener{
//
//    //private JButton jb1;
//
//    public ContactOverzichtPanel(){
//
////        jb1 = new JButton("Toevoegen");
////        jb1.addActionListener((ActionListener) this);
////        jb1.setBounds(100, 50, 200, 30);
////        add(jb1);
//
////        jb1 = new JButton("Toevoegen");
////        jb1.setBounds(0, 0, 100, 100);
//        //jb1.addActionListener((ActionListener) this);
//
//        JScrollPane scrollPane1 = new JScrollPane();
//        JScrollPane scrollPane2 = new JScrollPane();
//        this.setLayout(new GridLayout());
//        scrollPane1.setMinimumSize(new Dimension(100,200));
//
//        //scrollPane1.add(jb1);
//
//        scrollPane2.setMinimumSize(new Dimension(100,200));
//        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane1, scrollPane2);
//        JLabel filler = new JLabel("ContactOverzicht");
//        filler.setHorizontalAlignment(JLabel.CENTER);
//        splitPane.setPreferredSize(new Dimension(400, 200));
//        scrollPane1.add(filler);
//        this.add(splitPane);
//
//
//
//    }
//
//
//
////    public static void main(String[] args) {
////        ContactOverzichtPanel cop = new ContactOverzichtPanel();
////        cop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////    }
//
//    public void actionPerformed(ActionEvent ae) {
//        // code voor afhandeling knop
//
////        KoerierToevoegenDialoog dialoog = new KoerierToevoegenDialoog();
////        dialoog.setVisible(true);
//
//    }
//
//    private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//>>>>>>> 3e5869ec2e280d2fa10aaf7a2af1652483a3954c
//    }
//}
//
////    public ContactOverzichtPanel(){
////        JScrollPane scrollPane1 = new JScrollPane();
////        JScrollPane scrollPane2 = new JScrollPane();
////        this.setLayout(new GridLayout());
////        scrollPane1.setMinimumSize(new Dimension(100,200));
////        scrollPane2.setMinimumSize(new Dimension(100,200));
////        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane1, scrollPane2);
////        JLabel filler = new JLabel("ContactOverzicht");
////        filler.setHorizontalAlignment(JLabel.CENTER);
////        splitPane.setPreferredSize(new Dimension(400, 200));
////        scrollPane1.add(filler);
////        this.add(splitPane);
////
////    }
//
