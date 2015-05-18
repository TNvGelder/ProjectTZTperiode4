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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Twan
 */
public class ContactOverzichtPanel extends JPanel implements ItemListener, ActionListener {

    JPanel cards; //a panel that uses CardLayout
    final static String Accounthouders = "Accounthouders";
    final static String ProfKoeriers = "Prof. Koeriers";
    private JButton jbNieuwKoerier;

    public ContactOverzichtPanel() {
        //Layout scherm
        String comboBoxItems[] = {Accounthouders, ProfKoeriers};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
//        comboBoxPane.add(cb);

        jbNieuwKoerier = new JButton("Nieuwe prof. Koerier");
        jbNieuwKoerier.addActionListener(this);
        jbNieuwKoerier.setBounds(100, 50, 200, 30);
        add(jbNieuwKoerier);

        //Create the "cards".
        JPanel card1 = new JPanel();

        JPanel card2 = new JPanel();

        JPanel card3 = new JPanel();

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, Accounthouders);
        cards.add(card2, ProfKoeriers);
        add(cb);
        add(cards, BorderLayout.CENTER);

        setVisible(true);

//        pane.add(comboBoxPane, BorderLayout.PAGE_START);
//        pane.add(cards, BorderLayout.CENTER);
    }

    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = {Accounthouders, ProfKoeriers};
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
        cards.add(card1, Accounthouders);
        cards.add(card2, ProfKoeriers);

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
        if (e.getSource() == jbNieuwKoerier) {
            KoerierToevoegenDialoog dialoog = new KoerierToevoegenDialoog();
            dialoog.setVisible(true);
        }
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
