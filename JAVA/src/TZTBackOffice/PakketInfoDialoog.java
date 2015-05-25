package TZTBackOffice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Michiel
 */
public class PakketInfoDialoog extends JDialog {

    private PakketInfoTest pakketinfo;
    private JLabel idLabel, aanmeldtijd, aflevertijd, afzender, formaat, gewicht, koerier1, koerier2, treinkoerier, beschrijvingsLabel, routeLabel, locatie1, station1, station2, locatie2;
    private JButton herbereken;
    private JTextArea beschrijvingsveld;
    private JPanel knop;
    private String afleveren;

    private final static String newline = "\n";

    public PakketInfoDialoog(Pakket pakket, JFrame scherm) {
        super(scherm);
        //Haal de orderinfo van het pakket uit de database op
        VerzendOrder order = pakket.getOrder();
        AccountHouder accounthouder = order.getKlant();
        ArrayList<Traject> trajectlijst = pakket.getTrajecten();

        

        //Maak het scherm
        this.setTitle("Pakket " + pakket.getPakketID());
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //J-dingen maken
        JPanel panel = new JPanel();
        panel.setLayout(null);

        idLabel = new JLabel("Pakket " + pakket.getPakketID());

        aanmeldtijd = new JLabel("Aangemeld: " + order.getAanmeldTijd());
        aflevertijd = new JLabel("Status: " + pakket.getStatus());
        afzender = new JLabel("Afzender: " + accounthouder.getNaam() + " " + accounthouder.getAchternaam());
        formaat = new JLabel("Formaat: " + pakket.getFormaat());
        gewicht = new JLabel("Gewicht: " + pakket.getGewicht() + "g");
        beschrijvingsLabel = new JLabel("Beschrijving: ");

        int routePanelX = 450;
        int trajectPanelY = 110;
        JPanel routePanel = new JPanel(new GridLayout(trajectlijst.size(),1));
        Dimension routePanelSize = new Dimension(routePanelX - 50, (trajectlijst.size() * trajectPanelY));
        routePanel.setPreferredSize(routePanelSize);
        
        
        boolean isEerste = true;
        Color kleur = Color.WHITE;
        //Maakt de JLabels aan met informatie over het traject
        for (Traject traject : trajectlijst) {
            Locatie beginLocatie = traject.getBeginLocatie();
            int trajectID1 = traject.getTrajectID();
            Contact koerier = traject.getKoerier();
            Locatie eindLocatie = traject.getEindLocatie();
            int koeriersID = koerier.getContactID();
            String status = traject.getStatus();
            JLabel trajectInfo = new JLabel( "<html> <p STYLE=\"padding-left: 25px;\">"
                    + "Trajectnummer: "+traject.getTrajectID()+ "<br>"
                    + "Van "+ beginLocatie + " naar "+ eindLocatie +" <br>"
                    + "Koerier: "+ koerier + "<br>Koeriersnummer: " + koeriersID +" <br>"
                    + status +"</p></html>");
            trajectInfo.setBackground(kleur);
            trajectInfo.setOpaque(true);
            trajectInfo.setPreferredSize(new Dimension(routePanelX,trajectPanelY));
            
            routePanel.add(trajectInfo);
            if (kleur == Color.WHITE){
                kleur = Color.LIGHT_GRAY;
            }else{
                kleur = Color.WHITE;
            }
        }
        
        JScrollPane routeScrollPane = new JScrollPane(routePanel);
        
        
        routeLabel = new JLabel("Route");

        //Kijken naar trajecten en begin en eindlocatie opzoeken + kleur goed krijgen + koerier opzoeken
        //Groen als de huidige tijd later is dan de aflevertijd
        //Oranje als de tijd later is dan de verzendtijd maar er nog geen aflevertijd is. Er komt ook '(onderweg)' achter de locatienaam.
        //Rood als de tijd eerder is dan de verzendtijd
        locatie1 = new JLabel();
        station1 = new JLabel();
        station2 = new JLabel();
        locatie2 = new JLabel();

        beschrijvingsveld = new JTextArea(pakket.getOpmerking());
        beschrijvingsveld.setEditable(false);
        beschrijvingsveld.setLineWrap(true);
        //Zorgt dat de knop 'herbereken' het hele scherm overneemt. Misschien omdat de X van beschrijvingsveld die van 'herbereken' zou raken als hij niet gewrapt zou zijn?

        //Actionlistener
        event e = new event();
        herbereken = new JButton("Herbereken Route");
        herbereken.addActionListener(e);

        

        //Dingen uit database halen
        PakketInfoTest pakketInfo = new PakketInfoTest();

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
        station1.setFont(station1.getFont().deriveFont(20.0f));
        station2.setFont(station2.getFont().deriveFont(20.0f));
        locatie2.setFont(locatie2.getFont().deriveFont(20.0f));

        int routeScrollPaneY = 500;
        if (routePanelSize.getHeight() < routeScrollPaneY - 50){
            routeScrollPaneY = (int) routePanelSize.getHeight();
        }
        routeScrollPane.setBounds(700, 115, routePanelX, routeScrollPaneY+3);
        
        this.add(idLabel);
        idLabel.setBounds(575, 20, 1000, 30);

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
        beschrijvingsLabel.setBounds(50, 295, 600, 30);
        this.add(beschrijvingsveld);
        beschrijvingsveld.setBounds(50, 330, 450, 300);

        routeLabel.setBounds(700, 80, 400, 30);
        locatie1.setBounds(700, 115, 550, 30);
        station1.setBounds(700, 140, 550, 30);
        station2.setBounds(700, 165, 550, 30);
        locatie2.setBounds(700, 190, 550, 30);
        
        
        panel.setBounds(300, 200, 100, 30);
        panel.setLocation(300, 200);
        panel.setPreferredSize(new Dimension(300, 300));
        panel.add(routeLabel);
        panel.add(locatie1);
        panel.add(station1);
        panel.add(station2);
        panel.add(locatie2);
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
