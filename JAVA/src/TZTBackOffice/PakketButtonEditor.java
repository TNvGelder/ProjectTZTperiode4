/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author Twan
 */
public class PakketButtonEditor extends DefaultCellEditor {
   
    private ArrayList<Pakket> pakketten;
    private JFrame hoofdscherm;
    
    public PakketButtonEditor(JCheckBox checkBox, JFrame hoofdscherm, ArrayList<Pakket> pakketten) {
        super(checkBox);
        this.pakketten = pakketten;
        
        this.hoofdscherm = hoofdscherm;
        //button = new JButton("meer");
    }
    
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
//      
        Pakket pakket = pakketten.get(row);
        PakketInfoDialoog dialoog = new PakketInfoDialoog(pakket, hoofdscherm);
        dialoog.setVisible(true);
        System.out.println("wowwww");
        return null;
    }
    private ArrayList<Pakket> pakket;
    private JFrame scherm;

    

    

}
