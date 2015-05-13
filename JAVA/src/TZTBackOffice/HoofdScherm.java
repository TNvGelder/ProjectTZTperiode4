/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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

        setSize(1280, 680);

        JTabbedPane tabbedPane = new JTabbedPane();
        ContactOverzichtPanel contactPanel = new ContactOverzichtPanel();
        PakketOverzichtPanel pakketPanel = new PakketOverzichtPanel();
        UitbetalingsPanel uitbetalingPanel = new UitbetalingsPanel();
        JComponent panel1 = new JPanel();

        JButton jbRefresh = new JButton("Refresh");
        add(jbRefresh);
        jbRefresh.addActionListener(this);

        tabbedPane.addTab("Problemen", panel1);
        tabbedPane.addTab("Pakketten", pakketPanel);
        tabbedPane.addTab("Klanten & Koeriers", contactPanel);
        tabbedPane.addTab("Uitbetalingsverzoeken", uitbetalingPanel);

        this.add(tabbedPane);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
