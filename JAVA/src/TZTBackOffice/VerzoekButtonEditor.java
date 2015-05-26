/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

/**
 * Door Twan van Gelder
 */
public class VerzoekButtonEditor extends DefaultCellEditor {

    private ArrayList<UitbetalingsVerzoek> verzoeken;
    private JFrame hoofdscherm;

    public VerzoekButtonEditor(JCheckBox checkBox, JFrame hoofdscherm, ArrayList<UitbetalingsVerzoek> verzoeken) {
        super(checkBox);
        this.verzoeken = verzoeken;

        this.hoofdscherm = hoofdscherm;
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
//      

        UitbetalingsVerzoek verzoek = verzoeken.get(row);
        int keuze = JOptionPane.showOptionDialog(hoofdscherm, "Weet u zeker dat u dit uitbetalingsverzoek wil afhandelen?", "Afhandelen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[]{"Keur uitbetaling goed", "Keur uitbetaling af", "Annuleer"}, "default");
        if (keuze != JOptionPane.YES_OPTION && keuze != JOptionPane.NO_OPTION) {
            return null;
        } 
        verzoek.handelAf();
        verzoek.setGoedgekeurd(keuze == JOptionPane.YES_OPTION);
        
        return null;
    }

}
