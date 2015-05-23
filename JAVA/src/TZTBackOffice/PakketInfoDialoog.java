package TZTBackOffice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Michiel
 */
public class PakketInfoDialoog extends JDialog {

    private PakketInfoTest pakketinfo;
    private JLabel pakket, aanmeldtijd, aflevertijd, afzender, formaat, gewicht, koerier1, koerier2, treinkoerier, beschrijving, route, locatie1, station1, station2, locatie2;
    private JButton herbereken;
    private JTextArea beschrijvingsveld;
    private JPanel knop;
    private String afleveren;

    private final static String newline = "\n";

    public PakketInfoDialoog(Pakket p) {

        //Haal de orderinfo van het pakket uit de database op
        VerzendOrder order = p.getOrder();
        AccountHouder accounthouder = order.getKlant();
        ArrayList<Traject> trajectlijst = p.getTrajecten();

        

        //Maak het scherm
        JFrame scherm = new JFrame();
        scherm.setVisible(true);
        scherm.setTitle("Pakket " + p.getPakketID());
        scherm.setSize(1280, 720);
        scherm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //J-dingen maken
        JPanel knop = new JPanel();
        knop.setLayout(null);

        pakket = new JLabel("Pakket " + p.getPakketID());

        aanmeldtijd = new JLabel("Aangemeld: " + order.getAanmeldTijd());
        aflevertijd = new JLabel("Afgeleverd: ");
        afzender = new JLabel("Afzender: " + accounthouder.getNaam() + " " + accounthouder.getAchternaam());
        formaat = new JLabel("Formaat: " + p.getFormaat());
        gewicht = new JLabel("Gewicht: " + p.getGewicht() + "g");

        koerier1 = new JLabel("Koerier 1: " );
        koerier2 = new JLabel("Koerier 2: " );
        treinkoerier = new JLabel("Treinkoerier: ");
        beschrijving = new JLabel("Beschrijving: ");

        JPanel routePanel = new JPanel(new BorderLayout());
        
        for (Traject traject : trajectlijst) {
            System.out.println(traject);
        }
        
        JScrollPane routeScrollPane = new JScrollPane(routePanel);
        routeScrollPane.setBounds(700, 115, 550, 100);
        
        route = new JLabel("Route");

        //Kijken naar trajecten en begin en eindlocatie opzoeken + kleur goed krijgen + koerier opzoeken
        //Groen als de huidige tijd later is dan de aflevertijd
        //Oranje als de tijd later is dan de verzendtijd maar er nog geen aflevertijd is. Er komt ook '(onderweg)' achter de locatienaam.
        //Rood als de tijd eerder is dan de verzendtijd
        locatie1 = new JLabel();
        station1 = new JLabel();
        station2 = new JLabel();
        locatie2 = new JLabel();

        beschrijvingsveld = new JTextArea(p.getOpmerking());
        beschrijvingsveld.setEditable(false);
        beschrijvingsveld.setLineWrap(true);
        //Zorgt dat de knop 'herbereken' het hele scherm overneemt. Misschien omdat de X van beschrijvingsveld die van 'herbereken' zou raken als hij niet gewrapt zou zijn?

        //Actionlistener
        event e = new event();
        herbereken = new JButton("Herbereken Route");
        herbereken.addActionListener(e);

        knop.add(route);
        knop.add(locatie1);
        knop.add(station1);
        knop.add(station2);
        knop.add(locatie2);
        knop.add(herbereken);

        //Dingen uit database halen
        PakketInfoTest pakketInfo = new PakketInfoTest();

        //pakketInfo.getKl pakket
        //.setText("Pakket ");
        //Font setten
        pakket.setFont(pakket.getFont().deriveFont(32.0f));

        aanmeldtijd.setFont(aanmeldtijd.getFont().deriveFont(20.0f));
        aflevertijd.setFont(aflevertijd.getFont().deriveFont(20.0f));
        afzender.setFont(afzender.getFont().deriveFont(20.0f));
        formaat.setFont(formaat.getFont().deriveFont(20.0f));
        gewicht.setFont(gewicht.getFont().deriveFont(20.0f));

        koerier1.setFont(koerier1.getFont().deriveFont(20.0f));
        koerier2.setFont(koerier2.getFont().deriveFont(20.0f));
        treinkoerier.setFont(treinkoerier.getFont().deriveFont(20.0f));
        beschrijving.setFont(beschrijving.getFont().deriveFont(20.0f));

        route.setFont(route.getFont().deriveFont(32.0f));

        locatie1.setFont(locatie1.getFont().deriveFont(20.0f));
        station1.setFont(station1.getFont().deriveFont(20.0f));
        station2.setFont(station2.getFont().deriveFont(20.0f));
        locatie2.setFont(locatie2.getFont().deriveFont(20.0f));

        //Locaties voor routeberekening
        //Haalt hij nu de eerste 3 locaties op of de juiste bijbehorende locaties?
        //locatie1.setText(trajectlijst.get(0).getBeginLocatie().getStraat() + " " + trajectlijst.get(0).getBeginLocatie().getHuisnummer());
        //station1.setText(trajectlijst.get(0).getEindLocatie().getStraat() + " " + trajectlijst.get(0).getEindLocatie().getHuisnummer());
        //station2.setText(trajectlijst.get(1).getEindLocatie().getStraat() + " " + trajectlijst.get(1).getEindLocatie().getHuisnummer());
        //locatie2.setText(trajectlijst.get(2).getEindLocatie().getStraat() + " " + trajectlijst.get(2).getEindLocatie().getHuisnummer());

//        if (trajectlijst.get(0).getAfhaalTijdstip() != null) {
//            locatie1.setForeground(Color.GREEN);
//            if (trajectlijst.get(0).getAfleverTijdstip() != null) {
//                station1.setForeground(Color.GREEN);
//                if (trajectlijst.get(1).getAfleverTijdstip() != null) {
//                    station2.setForeground(Color.GREEN);
//                    if (trajectlijst.get(2).getAfleverTijdstip() != null) {
//                        locatie2.setForeground(Color.GREEN);
//                    } else {
//                        locatie2.setForeground(Color.ORANGE);
//                    }
//                } else {
//                    station2.setForeground(Color.ORANGE);
//                    locatie2.setForeground(Color.RED);
//                }
//            } else {
//                station1.setForeground(Color.ORANGE);
//                station2.setForeground(Color.RED);
//                locatie2.setForeground(Color.RED);
//            }
//        } else {
//            locatie1.setForeground(Color.ORANGE);
//            station1.setForeground(Color.RED);
//            station2.setForeground(Color.RED);
//            locatie2.setForeground(Color.RED);
//        }

        scherm.add(pakket);
        pakket.setBounds(575, 20, 1000, 30);

        scherm.add(aanmeldtijd);
        aanmeldtijd.setBounds(50, 80, 600, 30);
        scherm.add(aflevertijd);
        aflevertijd.setBounds(50, 105, 600, 30);
        scherm.add(afzender);
        afzender.setBounds(50, 130, 600, 30);
        scherm.add(formaat);
        formaat.setBounds(50, 155, 600, 30);
        scherm.add(gewicht);
        gewicht.setBounds(50, 180, 600, 30);

        scherm.add(koerier1);
        koerier1.setBounds(50, 220, 600, 30);
        scherm.add(koerier2);
        koerier2.setBounds(50, 245, 600, 30);
        scherm.add(treinkoerier);
        treinkoerier.setBounds(50, 270, 600, 30);
        scherm.add(beschrijving);
        beschrijving.setBounds(50, 295, 600, 30);
        scherm.add(beschrijvingsveld);
        beschrijvingsveld.setBounds(50, 330, 450, 325);

        knop.setBounds(300, 200, 100, 30);
        knop.setLocation(300, 200);
        knop.setPreferredSize(new Dimension(300, 300));
        scherm.add(knop);

        route.setBounds(700, 80, 400, 30);
        locatie1.setBounds(700, 115, 550, 30);
        station1.setBounds(700, 140, 550, 30);
        station2.setBounds(700, 165, 550, 30);
        locatie2.setBounds(700, 190, 550, 30);
        herbereken.setBounds(700, 220, 175, 30);

    }

    public class event implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
