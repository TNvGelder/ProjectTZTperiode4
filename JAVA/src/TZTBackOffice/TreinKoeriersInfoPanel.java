/*
 * Gemaakt door: Richard, Twan
 * Aangepast door: Jasper
 * Functie: Laat de treinkoerier gegevens zien in een panel
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

public class TreinKoeriersInfoPanel extends AccountHoudersInfoPanel implements ActionListener {

    private DatabaseManager databasemanager;
    private TreinKoerier t;

    public TreinKoeriersInfoPanel(TreinKoerier treinKoerier, DatabaseManager databasemanager) {
        super(treinKoerier, databasemanager);
        this.databasemanager = databasemanager;
        this.setLayout(null);
        this.t = treinKoerier;

        jlHead.setText("Treinkoerier");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("dit is buiten source");

        if (e.getSource() == jbAanpassen) {
            System.out.println("ik ben geprint bij TreinKoeriersInfoPanel");
            String strNaam = jtfNaam.getText();
            String strTelefoonnummer = jtfTelnummer.getText();

            t.setNaam(strNaam);
            t.setTelefoonnr(strTelefoonnummer);
            databasemanager.updateContact(t);
        }
    }
}
