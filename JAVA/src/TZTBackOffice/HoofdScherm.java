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
import javax.swing.SwingUtilities;

/**
 *
 * @author Twan
 */
public class HoofdScherm extends JFrame implements ActionListener {

    private ContactOverzichtPanel contactPanel;
    private JTabbedPane tabbedPane;

    public HoofdScherm() {
        super("BackOffice Applicatie");
        setLayout(new GridLayout());

        setSize(1280, 680);
        DatabaseManager databaseManager = new DatabaseManager();
        /*JTabbedPane*/ tabbedPane = new JTabbedPane();
        /*ContactOverzichtPanel */
        contactPanel = new ContactOverzichtPanel(databaseManager);
        PakketOverzichtPanel pakketPanel = new PakketOverzichtPanel(databaseManager);
        UitbetalingsPanel uitbetalingPanel = new UitbetalingsPanel();
        JComponent probleemPanel = new ProbleemPanel();
        tabbedPane.addTab("Problemen", probleemPanel);
        tabbedPane.addTab("Pakketten", pakketPanel);
        tabbedPane.addTab("Klanten & Koeriers", contactPanel);
        tabbedPane.addTab("Uitbetalingsverzoeken", uitbetalingPanel);
        this.add(tabbedPane);

        JButton jbRefresh = new JButton("Refresh");
        add(jbRefresh);
        jbRefresh.addActionListener(this);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SwingUtilities.updateComponentTreeUI(this.tabbedPane);
        tabbedPane.invalidate();
        tabbedPane.validate();
        tabbedPane.repaint();

        System.out.println("refresh");
    }

}
