package TZTBackOffice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Twan & Michiel
 */
public class KlachtInfoPanel extends Probleem {

    private Pakket pakket;
    private JLabel onderwerp, klantnaam, probleemid, datums;
    private JButton reageer, handelaf;
    private JTextArea klachtbeschrijving;

    public KlachtInfoPanel(int probleemID, String titel, String beschrijving, Timestamp datum, boolean afgehandeld) {

        super(probleemID, titel, beschrijving, datum, afgehandeld);
        this.setLayout(null);
        event e = new event();

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

        add(onderwerp);

    }

    public Pakket getPakket() {
        return pakket;
    }

    public void setPakket(Pakket pakket) {
        this.pakket = pakket;
    }

    private void setLayout(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class event implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
