package TZTBackOffice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Michiel
 */
public class PakketInfoDialoog extends JDialog {

    private PakketInfoTest pakketinfo;
    private JLabel pakket, aanmeldtijd, aflevertijd, datum, afzender, formaat, gewicht, betaald, koerier1, koerier2, treinkoerier, beschrijving, route, locatie1, station1, station2, locatie2;
    private JButton herbereken;
    private JTextArea beschrijvingsveld;

    private final static String newline = "\n";

    public PakketInfoDialoog(Pakket p) {
        JFrame scherm = new JFrame();
        scherm.setVisible(true);
        scherm.setTitle("Pakket " /* + pakketid*/);
        scherm.setSize(1280, 720);
        scherm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pakket = new JLabel("Pakket: ");

        aanmeldtijd = new JLabel("Aanmeldtijd: ");
        aflevertijd = new JLabel("Aflevertijd: ");
        datum = new JLabel("Datum: ");
        afzender = new JLabel("Afzender: ");
        formaat = new JLabel("Formaat: ");
        gewicht = new JLabel("Gewicht: ");
        betaald = new JLabel("Betaald: ");

        koerier1 = new JLabel("Koerier 1: ");
        koerier2 = new JLabel("Koerier 2: ");
        treinkoerier = new JLabel("Treinkoerier: ");
        beschrijving = new JLabel("Beschrijving: ");

        route = new JLabel("Route");

        locatie1 = new JLabel();
        station1 = new JLabel();
        station2 = new JLabel();
        locatie2 = new JLabel();

        beschrijvingsveld = new JTextArea();
        beschrijvingsveld.setColumns(20);
        beschrijvingsveld.setRows(10);
        beschrijvingsveld.setEditable(false);
        beschrijvingsveld.append("Test" + newline + "Enzo" + newline);

        event e = new event();
        herbereken = new JButton("Herbereken Route");
        herbereken.addActionListener(e);

        PakketInfoTest pakketInfo = new PakketInfoTest();

        //pakketInfo.getKl pakket
        //.setText("Pakket ");
        pakket.setFont(pakket.getFont().deriveFont(32.0f));

        aanmeldtijd.setFont(aanmeldtijd.getFont().deriveFont(20.0f));
        aflevertijd.setFont(aflevertijd.getFont().deriveFont(20.0f));
        datum.setFont(datum.getFont().deriveFont(20.0f));
        afzender.setFont(afzender.getFont().deriveFont(20.0f));
        formaat.setFont(formaat.getFont().deriveFont(20.0f));
        gewicht.setFont(gewicht.getFont().deriveFont(20.0f));
        betaald.setFont(betaald.getFont().deriveFont(20.0f));

        koerier1.setFont(koerier1.getFont().deriveFont(20.0f));
        koerier2.setFont(koerier2.getFont().deriveFont(20.0f));
        treinkoerier.setFont(treinkoerier.getFont().deriveFont(20.0f));
        beschrijving.setFont(beschrijving.getFont().deriveFont(20.0f));

        route.setFont(route.getFont().deriveFont(32.0f));

        locatie1.setFont(locatie1.getFont().deriveFont(20.0f));
        station1.setFont(station1.getFont().deriveFont(20.0f));
        station2.setFont(station2.getFont().deriveFont(20.0f));
        locatie2.setFont(locatie2.getFont().deriveFont(20.0f));

        locatie1.setText("Diestraat 14" + "");
        station1.setText("Station " + "Zwolle" + "");
        station2.setText("Station " + "Deventer" + " (Onderweg)");
        locatie2.setText("Dieanderestraat 58" + "");

        locatie1.setForeground(Color.GREEN);
        station1.setForeground(Color.GREEN);
        station2.setForeground(Color.ORANGE);
        locatie2.setForeground(Color.RED);

        scherm.add(pakket);
        pakket.setBounds(575, 20, 1000, 30);

        scherm.add(aanmeldtijd);
        aanmeldtijd.setBounds(50, 80, 400, 30);
        scherm.add(aflevertijd);
        aflevertijd.setBounds(50, 105, 400, 30);
        scherm.add(datum);
        datum.setBounds(50, 130, 400, 30);
        scherm.add(afzender);
        afzender.setBounds(50, 155, 400, 30);
        scherm.add(formaat);
        formaat.setBounds(50, 180, 400, 30);
        scherm.add(gewicht);
        gewicht.setBounds(50, 205, 400, 30);
        scherm.add(betaald);
        betaald.setBounds(50, 230, 400, 30);

        scherm.add(koerier1);
        koerier1.setBounds(50, 270, 400, 30);
        scherm.add(koerier2);
        koerier2.setBounds(50, 295, 400, 30);
        scherm.add(treinkoerier);
        treinkoerier.setBounds(50, 320, 400, 30);
        scherm.add(beschrijving);
        beschrijving.setBounds(50, 345, 400, 30);
        scherm.add(beschrijvingsveld);
        beschrijvingsveld.setBounds(50, 380, 450, 275);

        scherm.add(route);
        route.setBounds(700, 80, 400, 30);

        scherm.add(locatie1);
        locatie1.setBounds(700, 115, 400, 30);
        scherm.add(station1);
        station1.setBounds(700, 140, 400, 30);
        scherm.add(station2);
        station2.setBounds(700, 165, 400, 30);
        scherm.add(locatie2);
        locatie2.setBounds(700, 190, 400, 30);
        scherm.add(herbereken);
        herbereken.setBounds(700, 225, 175, 30);

    }

    public class event implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
