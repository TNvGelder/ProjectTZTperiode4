package TZTBackOffice;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 * @author Michiel
 */
public class pakketinfo extends JDialog {

    private int pakketid = 21241;
    private double gewicht = 476;
    private String formaat = "10x10x10";
    private VerzendOrder order;

    private String aanmeldtijd = "10:32";
    private String aflevertijd = "14:32";
    private boolean betaald = true;
    private String koerier1 = "Fietskoerier BV";
    private String koerier2 = "Fietskoerier BV";
    private String treinkoerier = "Bob de Bouwer";
    private String beschrijving = "Beschrijving bij Pakket";
    private JButton jbTerug;
    private JButton jbHerbereken;

    public pakketinfo() {
        setTitle("Pakket " + pakketid);
        setSize(1920, 1000);
        setLayout(new FlowLayout());
    }
}
