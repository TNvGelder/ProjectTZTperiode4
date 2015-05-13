package TZTBackOffice;

import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 * @author Michiel
 */
public class PakketInfo extends JDialog {

    public int pakketid = 21241;
    public double gewicht = 476;
    public String formaat = "10x10x10";
    public VerzendOrder order;

    public String aanmeldtijd = "10:32";
    public String aflevertijd = "14:32";
    public boolean betaald = true;
    public String koerier1 = "Fietskoerier BV";
    public String koerier2 = "Fietskoerier BV";
    public String treinkoerier = "Bob de Bouwer";
    public String beschrijving = "Beschrijving bij Pakket";
    public JButton jbTerug;
    public JButton jbHerbereken;

    //public String getPakketID() {
    //return pakketid;
    //}
}
