/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 *
 * @author Twan
 */
public class ContactOverzichtPanel extends JPanel implements ActionListener{
    
    private JButton jb1;
    
    public ContactOverzichtPanel(){
        
//        jb1 = new JButton("Toevoegen");
//        jb1.addActionListener((ActionListener) this);
//        jb1.setBounds(100, 50, 200, 30);
//        add(jb1);
        
        jb1 = new JButton("Toevoegen");
        jb1.setBounds(0, 0, 100, 100);
        //jb1.addActionListener((ActionListener) this);
        
        JScrollPane scrollPane1 = new JScrollPane();
        JScrollPane scrollPane2 = new JScrollPane();
        this.setLayout(new GridLayout());
        scrollPane1.setMinimumSize(new Dimension(100,200));
                
        scrollPane1.add(jb1);
                
        scrollPane2.setMinimumSize(new Dimension(100,200));
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane1, scrollPane2);
        JLabel filler = new JLabel("ContactOverzicht");
        filler.setHorizontalAlignment(JLabel.CENTER);
        splitPane.setPreferredSize(new Dimension(400, 200));
        scrollPane1.add(filler);
        this.add(splitPane);
        
        
        
    }
    
        
    
    public static void main(String[] args) {
        ContactOverzichtPanel cop = new ContactOverzichtPanel();
        cop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        // code voor afhandeling knop

        KoerierToevoegenDialoog dialoog = new KoerierToevoegenDialoog();
        dialoog.setVisible(true);

    }

    private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
