/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 *
 * @author Twan
 */
public class ContactOverzichtPanel extends JPanel{
    
    
    public ContactOverzichtPanel(){
        JScrollPane scrollPane1 = new JScrollPane();
        JScrollPane scrollPane2 = new JScrollPane();
        this.setLayout(new GridLayout());
        scrollPane1.setMinimumSize(new Dimension(100,200));
        scrollPane2.setMinimumSize(new Dimension(100,200));
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane1, scrollPane2);
        JLabel filler = new JLabel("ContactOverzicht");
        filler.setHorizontalAlignment(JLabel.CENTER);
        splitPane.setPreferredSize(new Dimension(400, 200));
        scrollPane1.add(filler);
        this.add(splitPane);
        
    }
    
}
