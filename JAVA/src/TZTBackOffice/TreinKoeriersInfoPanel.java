/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Twan
 */
public class TreinKoeriersInfoPanel extends AccountHoudersInfoPanel implements ActionListener {

    private JTextArea jtaTarieven;
    private JButton jbAanpassen;

    public TreinKoeriersInfoPanel(TreinKoerier treinKoerier, DatabaseManager databasemanager) {
        super(treinKoerier, databasemanager);

        this.setLayout(null);

        //add(jlHead);
        jbAanpassen = new JButton("Aanpassen");
        this.add(jbAanpassen);
        event e = new event();
        jbAanpassen.addActionListener(e);

        jlHead.setText("Treinkoerier");

        //Inhoud toevoegen
        add(jlHead);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class event implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
    //if (e.getSource == jbAanpassen){
//                String strNaam = jtfNaam.getText();
//                String strTelnummer = jtfTelnummer.getText();
//                String strEmail = jtfEmail.getText();
//                String strTarieven = jtaTarieven.getText();

            //}
        }
    }
}
