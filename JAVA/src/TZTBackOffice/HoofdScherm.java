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
public class HoofdScherm extends JFrame implements ActionListener {

    public HoofdScherm() {
        super("BackOffice Applicatie");
        setSize(800, 300);

        JTabbedPane tabbedPane = new JTabbedPane();
        ContactOverzichtPanel contactPanel = new ContactOverzichtPanel();
        JComponent panel1 = new JPanel();
        JComponent panel2 = new JPanel();
        JComponent panel4 = new JPanel();
        tabbedPane.addTab("Problemen", panel1);
        tabbedPane.addTab("Pakketen", panel2);
        tabbedPane.addTab("Klanten & Koeriers", contactPanel);
        tabbedPane.addTab("Uitbetalingsverzoeken", panel4);
        this.add(tabbedPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
