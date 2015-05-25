/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
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
 * Gemaakt door Twan van Gelder
 * Op het scherm dat opgebouwd wordt in deze klasse kunnen overzichtspanels getoond worden met behulp van tabs.
 * Ook is er een refresh knop die ervoor zorgt dat de UI weer up to date is met de database.
 */
public class HoofdScherm extends JFrame implements ActionListener {

    private ContactOverzichtPanel contactPanel;
    private JTabbedPane tabbedPane;
    private JButton jbRefresh;
    private DatabaseManager databaseManager;

    public HoofdScherm() {
        super("BackOffice Applicatie");
        setLayout(new BorderLayout());
        
        setSize(1280, 680);
        databaseManager = new DatabaseManager();
        tabbedPane = new JTabbedPane();
        contactPanel = new ContactOverzichtPanel(databaseManager);
        PakketOverzichtPanel pakketPanel = new PakketOverzichtPanel(databaseManager);
        UitbetalingsPanel uitbetalingPanel = new UitbetalingsPanel();
        //JComponent probleemPanel = new ProbleemPanel();
        //tabbedPane.addTab("Problemen", probleemPanel);
        tabbedPane.addTab("Pakketten", pakketPanel);
        tabbedPane.addTab("Klanten & Koeriers", contactPanel);
        tabbedPane.addTab("Uitbetalingsverzoeken", uitbetalingPanel);
        jbRefresh = new JButton("Ververs gegevens");
        jbRefresh.addActionListener(this);
        jbRefresh.setBounds(0,0,jbRefresh.getPreferredSize().width,30);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(30,30));
        panel.add(jbRefresh);
        this.add(panel, BorderLayout.NORTH);
        this.add(tabbedPane);

        
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbRefresh) {
            databaseManager.haalDataOp();
            contactPanel.refresh();

            System.out.println("refresh");
        }
    }

}
