package TZTBackOffice;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Michiel
 */
public class PakketInfoDialoog extends JDialog {

    private PakketInfo pakketinfo;

    public PakketInfoDialoog(Pakket p){
        JFrame scherm = new JFrame();
        scherm.setVisible(true);
        scherm.setTitle("Pakket " /* + pakketid*/);
        scherm.setSize(1920, 1000);
        FlowLayout layout = new FlowLayout();
        scherm.setLayout(layout);
        scherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel pakket = new JLabel("Pakket");
        JLabel aanmeldtijd = new JLabel("Aanmeldtijd");
        JLabel aflevertijd = new JLabel("Aflevertijd");
        JLabel datum = new JLabel("Datum");
        JLabel afzender = new JLabel("Afzender");
        JLabel formaat = new JLabel("Formaat");
        JLabel gewicht = new JLabel("Gewicht");
        JLabel betaald = new JLabel("Betaald");
        JLabel koerier1 = new JLabel("Koerier 1");
        JLabel koerier2 = new JLabel("Koerier 2");
        JLabel treinkoerier = new JLabel("Treinkoerier");
        JLabel beschrijving = new JLabel("Beschrijving");

        PakketInfo pakketInfo = new PakketInfo();
        //pakketInfo.getKl pakket
        //.setText("Pakket ");
        pakket.setFont(pakket.getFont().deriveFont(32.0f));
        aanmeldtijd.setText("Aanmeldtijd: ");
        aanmeldtijd.setFont(aanmeldtijd.getFont().deriveFont(20.0f));
        aflevertijd.setText("Aflevertijd: ");
        aflevertijd.setFont(aflevertijd.getFont().deriveFont(20.0f));
        datum.setText("Datum: ");
        datum.setFont(datum.getFont().deriveFont(20.0f));
        afzender.setText("Afzender: ");
        afzender.setFont(afzender.getFont().deriveFont(20.0f));
        formaat.setText("Formaat: ");
        formaat.setFont(formaat.getFont().deriveFont(20.0f));
        gewicht.setText("Gewicht: ");
        gewicht.setFont(gewicht.getFont().deriveFont(20.0f));
        betaald.setText("Betaald: ");
        betaald.setFont(betaald.getFont().deriveFont(20.0f));
        koerier1.setText("Koerier 1: ");
        koerier1.setFont(koerier1.getFont().deriveFont(20.0f));
        koerier2.setText("Koerier 2: ");
        koerier2.setFont(koerier2.getFont().deriveFont(20.0f));
        treinkoerier.setText("Treinkoerier: ");
        treinkoerier.setFont(treinkoerier.getFont().deriveFont(20.0f));
        beschrijving.setText("Beschrijving: ");
        beschrijving.setFont(beschrijving.getFont().deriveFont(20.0f));

        scherm.add(pakket);
        scherm.add(aanmeldtijd);
        scherm.add(aflevertijd);
        scherm.add(datum);
        scherm.add(afzender);
        scherm.add(formaat);
        scherm.add(gewicht);
        scherm.add(betaald);
        scherm.add(koerier1);
        scherm.add(koerier2);
        scherm.add(treinkoerier);
        scherm.add(beschrijving);

    }

}
