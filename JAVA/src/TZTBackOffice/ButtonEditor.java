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
 * @version 1.0 11/09/98
 */
public class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton("meer");
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    public Object getCellEditorValue() {
        if (isPushed) {
            //
            //
//            System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
//            DatabaseManager databaseManager = new DatabaseManager();
//            ArrayList<Pakket> pakketten = databaseManager.getPakketten();
//            Pakket pakket = pakketten.get(14);
//            System.out.println("\n Het pakket: " + pakket);
//
//            PakketInfoDialoog pakketInfo = new PakketInfoDialoog(pakket, null);

            DatabaseManager databaseManager = new DatabaseManager();
            ArrayList<Pakket> pakketten = databaseManager.getPakketten();
            PakketOverzichtPanel pakketOverzicht = new PakketOverzichtPanel(databaseManager);
//            int intSelectedCell = Integer.parseInt(pakketOverzicht.selectedCell);
//            int intSelectedCell = Integer.valueOf(pakketOverzicht.selectedCell);

            //###############################################################################||Pakket meegeven om te laten werken||########################################################################
//            Pakket pakket = databaseManager.getPakket(pakketOverzicht.getSelectedCell());
//            System.out.println("\n" + pakket);
//            System.out.println("het pakket is: " + pakket);
//
//            JFrame testScherm = new JFrame();
//            testScherm.setVisible(false);
//            PakketInfoDialoog pakketInfo = new PakketInfoDialoog(pakket, null);
//            pakketInfo.setVisible(true);
        }
        isPushed = false;
        return new String(label);
    }

    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
        System.out.println("dsfads");
    }
}
