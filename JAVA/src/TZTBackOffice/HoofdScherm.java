/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Twan
 */
public class HoofdScherm extends JFrame {

    public HoofdScherm() {
        super("BackOffice Applicatie");
        setSize(1280, 680);

        JTabbedPane tabbedPane = new JTabbedPane();
        ContactOverzichtPanel contactPanel = new ContactOverzichtPanel();
        PakketOverzichtPanel pakketPanel = new PakketOverzichtPanel();
        JComponent panel1 = new JPanel();
        JComponent panel2 = new JPanel();
        JComponent panel4 = new JPanel();
        tabbedPane.addTab("Problemen", panel1);
        tabbedPane.addTab("Pakketten", pakketPanel);
        tabbedPane.addTab("Klanten & Koeriers", contactPanel);
        tabbedPane.addTab("Uitbetalingsverzoeken", panel4);
        this.add(tabbedPane);
        setVisible(true);
        

    }

}
