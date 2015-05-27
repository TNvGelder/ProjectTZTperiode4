/*
 * Gemaakt door: Michiel
 * Aangepast door: Twan
 * Functie: Laat specifieke pakket gegevens zien in een dialoog. Dit dialoog wordt aangeroepen nadat er op een knop is gedrukt in de tabel met pakketten
 */
package TZTBackOffice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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

public class PakketInfoDialoog extends JDialog {

    private JLabel idLabel, aanmeldtijd, aflevertijd, afzender, formaat, gewicht, koerier1, koerier2, treinkoerier, beschrijvingsLabel, routeLabel, locatie1, locatie2, locatie3, locatie4;
    private JButton herbereken;
    private JTextArea beschrijvingsveld;

    public PakketInfoDialoog(Pakket pakket, JFrame scherm) {
        super(scherm);
        this.setTitle("Pakket " + pakket.getPakketID());
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int routePanelX = 450;
        int trajectPanelY = 110;

        VerzendOrder order = pakket.getOrder();
        AccountHouder accounthouder = order.getKlant();
        ArrayList<Traject> trajectlijst = pakket.getTrajecten();

        idLabel = new JLabel("Pakket " + pakket.getPakketID());
        aanmeldtijd = new JLabel("Aangemeld: " + order.getAanmeldTijd());
        aflevertijd = new JLabel("Status: " + pakket.getStatus());
        afzender = new JLabel("Afzender: " + accounthouder.toString());
        formaat = new JLabel("Formaat: " + pakket.getFormaat());
        gewicht = new JLabel("Gewicht: " + pakket.getGewicht() + "g");
        beschrijvingsLabel = new JLabel("Beschrijving: ");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JPanel routePanel = new JPanel(new GridLayout(trajectlijst.size(), 1));
        Dimension routePanelSize = new Dimension(routePanelX - 50, (trajectlijst.size() * trajectPanelY));
        routePanel.setPreferredSize(routePanelSize);

        //Maakt de JLabels aan met informatie over het traject
        //De JLabels worden in routePanel gestopt en dit wrodt vervolgens in een ScrollPane gestopt.
        //Doordat het in een scrollpane zit maakt het niet uit hoeveel trajecten er getoond moeten worden.
        boolean isEerste = true;
        Color kleur = Color.WHITE;
        for (Traject traject : trajectlijst) {
            Locatie beginLocatie = traject.getBeginLocatie();
            int trajectID1 = traject.getTrajectID();
            Contact koerier = traject.getKoerier();
            Locatie eindLocatie = traject.getEindLocatie();
            int koeriersID = koerier.getContactID();
            String status = traject.getStatus();
            JLabel trajectInfo = new JLabel("<html> <p STYLE=\"padding-left: 25px;\">"
                    + "Trajectnummer: " + traject.getTrajectID() + "<br>"
                    + "Van " + beginLocatie + " naar " + eindLocatie + " <br>"
                    + "Koerier: " + koerier + "<br>Koeriersnummer: " + koeriersID + " <br>"
                    + status + "</p></html>");
            trajectInfo.setBackground(kleur);
            trajectInfo.setOpaque(true);
            trajectInfo.setPreferredSize(new Dimension(routePanelX, trajectPanelY));

            routePanel.add(trajectInfo);
            if (kleur == Color.WHITE) {
                kleur = Color.LIGHT_GRAY;
            } else {
                kleur = Color.WHITE;
            }
        }
        //Maak JScrollPane
        JScrollPane routeScrollPane = new JScrollPane(routePanel);

        //Opmaak van Dialoog
        routeLabel = new JLabel("Route");

        locatie1 = new JLabel();
        locatie2 = new JLabel();
        locatie3 = new JLabel();
        locatie4 = new JLabel();

        beschrijvingsveld = new JTextArea(pakket.getOpmerking());
        beschrijvingsveld.setEditable(false);
        beschrijvingsveld.setLineWrap(true);
        //Zorgt dat de knop 'herbereken' het hele scherm overneemt. Misschien omdat de X van beschrijvingsveld die van 'herbereken' zou raken als hij niet gewrapt zou zijn?

        //Actionlistener
        event e = new event();
        herbereken = new JButton("Herbereken Route");
        herbereken.addActionListener(e);

        //pakketInfo.getKl pakket
        //.setText("Pakket ");
        //Font setten
        idLabel.setFont(idLabel.getFont().deriveFont(32.0f));

        aanmeldtijd.setFont(aanmeldtijd.getFont().deriveFont(20.0f));
        aflevertijd.setFont(aflevertijd.getFont().deriveFont(20.0f));
        afzender.setFont(afzender.getFont().deriveFont(20.0f));
        formaat.setFont(formaat.getFont().deriveFont(20.0f));
        gewicht.setFont(gewicht.getFont().deriveFont(20.0f));

        beschrijvingsLabel.setFont(beschrijvingsLabel.getFont().deriveFont(20.0f));

        routeLabel.setFont(routeLabel.getFont().deriveFont(32.0f));

        locatie1.setFont(locatie1.getFont().deriveFont(20.0f));
        locatie2.setFont(locatie2.getFont().deriveFont(20.0f));
        locatie3.setFont(locatie3.getFont().deriveFont(20.0f));
        locatie4.setFont(locatie4.getFont().deriveFont(20.0f));

        int routeScrollPaneY = 500;
        if (routePanelSize.getHeight() < routeScrollPaneY - 50) {
            routeScrollPaneY = (int) routePanelSize.getHeight();
        }
        routeScrollPane.setBounds(700, 115, routePanelX, routeScrollPaneY + 3);

        this.add(idLabel);
        idLabel.setBounds(525, 20, 1000, 30);

        this.add(aanmeldtijd);
        aanmeldtijd.setBounds(50, 80, 600, 30);
        this.add(aflevertijd);
        aflevertijd.setBounds(50, 105, 600, 30);
        this.add(afzender);
        afzender.setBounds(50, 130, 600, 30);
        this.add(formaat);
        formaat.setBounds(50, 155, 600, 30);
        this.add(gewicht);
        gewicht.setBounds(50, 180, 600, 30);

        this.add(beschrijvingsLabel);
        beschrijvingsLabel.setBounds(50, 215, 600, 30);
        this.add(beschrijvingsveld);
        beschrijvingsveld.setBounds(50, 245, 450, 310);

        routeLabel.setBounds(700, 80, 400, 30);
        locatie1.setBounds(700, 115, 550, 30);
        locatie2.setBounds(700, 140, 550, 30);
        locatie3.setBounds(700, 165, 550, 30);
        locatie4.setBounds(700, 190, 550, 30);

        panel.setBounds(300, 200, 100, 30);
        panel.setLocation(300, 200);
        panel.setPreferredSize(new Dimension(300, 300));
        panel.add(routeLabel);
        panel.add(locatie1);
        panel.add(locatie2);
        panel.add(locatie3);
        panel.add(locatie4);
        herbereken.setBounds(974, 80, 175, 30);
        //panel.add(herbereken);

        panel.add(routeScrollPane);

        this.add(panel);

    }

    public class event implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
