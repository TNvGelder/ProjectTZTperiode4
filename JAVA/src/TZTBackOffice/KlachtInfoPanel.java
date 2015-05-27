/*
 * Gemaakt door: Twan, Michiel
 * Aangepast door: -
 * Functie: Laat klacht gegevens zien in panel
 */
package TZTBackOffice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class KlachtInfoPanel {

    private Pakket pakket;
    private JLabel onderwerp, klantnaam, probleemid, datums;
    private JButton reageer, handelaf;
    private JTextArea klachtbeschrijving;

    public KlachtInfoPanel(Klacht klacht) {

        this.setLayout(null);
        event e = new event();

        //Maak inhoud voor in Panel
        JLabel onderwerp = new JLabel("Onderwerp");
        JLabel klantnaam = new JLabel();
        JLabel probleemid = new JLabel();
        JLabel datums = new JLabel();

        JButton reageer = new JButton();
        JButton handelaf = new JButton();

        JTextArea klachtbeschrijving = new JTextArea();

        onderwerp.setFont(onderwerp.getFont().deriveFont(32.0f));
        klantnaam.setFont(klantnaam.getFont().deriveFont(20.0f));
        probleemid.setFont(probleemid.getFont().deriveFont(20.0f));
        datums.setFont(datums.getFont().deriveFont(20.0f));

    }

    private void setLayout(Object object) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class event implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
