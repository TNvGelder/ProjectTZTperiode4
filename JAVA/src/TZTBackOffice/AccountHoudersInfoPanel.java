package TZTBackOffice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Gemaakt door: Twan, Richard, Jasper
 * Functie: Laat de gegevens zien van accounthouders in het ContactOverzichtPanel
 */
public class AccountHoudersInfoPanel extends JPanel implements ActionListener {

    protected JLabel jlHead, jlTelnummer, jlNaam, jlAchternaam, jlEmailBeschrijving, jlAccountIDBeschrijving,
            jlWoonplaats, jlPostcode, jlHuisnummer, jlAccountID, jlStraat, jlEmail, jlVerplicht, jlFoutmelding, jlRekeningnr;
    protected JTextField jtfNaam, jtfTelnummer, jtfAchternaam, jtfWoonplaats, jtfPostcode, jtfHuisnummer, jtfStraat;
    protected JButton jbAanpassen, jbGoedkeuren;
    private AccountHouder a;
    private DatabaseManager databasemanager;
    private BufferedImage imageID;
    private BufferedImage imageOV;
    protected ArrayList<JTextField> verplichteVelden;
    protected ContactOverzichtPanel overzicht;

    public AccountHoudersInfoPanel(AccountHouder accountHouder, DatabaseManager databasemanager, ContactOverzichtPanel overzicht) {
        this.databasemanager = databasemanager;
        this.setLayout(null);
        this.a = accountHouder;
        this.overzicht = overzicht;
        this.verplichteVelden = new ArrayList();
        //Maak de inhoud aan
        jbAanpassen = new JButton("Aanpassen");
        jbGoedkeuren = new JButton("Goedkeuren");

        jlHead = new JLabel("Accounthouder");
        jlHead.setForeground(Color.blue);
        jlHead.setFont(new Font("Roboto-Regular", Font.PLAIN, 22));
        jlVerplicht = new JLabel("De velden met * zijn verplicht");
        jlNaam = new JLabel("Voornaam:* ");
        jlTelnummer = new JLabel("Tel. Nummer:* ");
        jlEmailBeschrijving = new JLabel("E-mail adres: ");
        jlAchternaam = new JLabel("Achternaam:* ");
        jlWoonplaats = new JLabel("Woonplaats:* ");
        jlAccountIDBeschrijving = new JLabel("Account ID: ");
        jlPostcode = new JLabel("Postcode:* ");
        jlHuisnummer = new JLabel("Huisnummer:* ");
        jlAccountID = new JLabel(accountHouder.getContactID() + "");
        jlStraat = new JLabel("Straat:* ");
        jlEmail = new JLabel(accountHouder.getEmail());
        jlRekeningnr = new JLabel("");
        jlFoutmelding = new JLabel("");
        jlFoutmelding.setForeground(Color.red);
        jlFoutmelding.setFont(new Font("Roboto-Regular", Font.PLAIN, 20));

        String rekeningnr = accountHouder.getRekeningnr();

        jtfNaam = new JTextField(accountHouder.getNaam());
        jtfTelnummer = new JTextField(accountHouder.getTelefoonnr());
        jtfAchternaam = new JTextField(accountHouder.getAchternaam());
        jtfWoonplaats = new JTextField(accountHouder.getLocatie().getPlaats());
        jtfPostcode = new JTextField(accountHouder.getLocatie().getPostcode());
        jtfHuisnummer = new JTextField(accountHouder.getLocatie().getHuisnummer());
        jtfStraat = new JTextField(accountHouder.getLocatie().getStraat());

        //Maak de velden verplicht
        verplichteVelden.add(jtfNaam);
        verplichteVelden.add(jtfTelnummer);
        verplichteVelden.add(jtfAchternaam);
        verplichteVelden.add(jtfWoonplaats);
        verplichteVelden.add(jtfPostcode);
        verplichteVelden.add(jtfHuisnummer);
        verplichteVelden.add(jtfStraat);
        //Zet de locatie van de labels, buttons en textfields
        jlHead.setBounds(80, 30, 400, 30);

        jlVerplicht.setBounds(350, 35, 200, 30);
        jlFoutmelding.setBounds(80, 70, 400, 30);
        jlNaam.setBounds(80, 110, 200, 30);
        jtfNaam.setBounds(180, 110, 200, 30);

        jlAchternaam.setBounds(450, 110, 200, 30);
        jtfAchternaam.setBounds(550, 110, 200, 30);

        jlEmailBeschrijving.setBounds(80, 150, 200, 30);
        jlEmail.setBounds(180, 150, 200, 30);

        jlTelnummer.setBounds(450, 150, 200, 30);
        jtfTelnummer.setBounds(550, 150, 200, 30);

        jlAccountIDBeschrijving.setBounds(80, 190, 200, 30);
        jlAccountID.setBounds(180, 190, 200, 30);
        jlRekeningnr.setBounds(450, 190, 200, 30);
        if (!(rekeningnr == null || rekeningnr.equals(""))) {
            jlRekeningnr.setText("Rekeningnr:           " + rekeningnr);
            jlRekeningnr.setBounds(450, 190, 400, 30);
        }

        jlWoonplaats.setBounds(80, 230, 200, 30);
        jtfWoonplaats.setBounds(180, 230, 200, 30);

        jlPostcode.setBounds(450, 230, 200, 30);
        jtfPostcode.setBounds(550, 230, 200, 30);

        jlStraat.setBounds(80, 270, 200, 30);
        jtfStraat.setBounds(180, 270, 200, 30);

        jlHuisnummer.setBounds(450, 270, 200, 30);
        jtfHuisnummer.setBounds(550, 270, 200, 30);

        //Als een accounthouder geen IDkaart en OVkaart heeft, zullen de knoppen hoger op de pagina staan
        String idKaart = accountHouder.getIdkaart();
        if ((idKaart == null || idKaart.equals(""))) {
            jbAanpassen.setBounds(228, 340, 150, 20);
            jbAanpassen.addActionListener(this);
        } else {
            jbAanpassen.setBounds(228, 530, 150, 20);
            jbAanpassen.addActionListener(this);

            jbGoedkeuren.setBounds(600, 530, 150, 20);
            jbGoedkeuren.addActionListener(this);
            add(jbGoedkeuren);
        }

        //Voeg de inhoud toe aan het panel
        add(jlHead);
        add(jlNaam);
        add(jlTelnummer);
        add(jlEmailBeschrijving);

        add(jlAchternaam);
        add(jlWoonplaats);
        add(jlAccountIDBeschrijving);
        add(jlPostcode);
        add(jlHuisnummer);
        add(jlAccountID);
        add(jlStraat);
        add(jlRekeningnr);
        add(jlVerplicht);
        add(jlFoutmelding);

        add(jtfNaam);
        add(jtfTelnummer);

        add(jtfAchternaam);
        add(jtfWoonplaats);
        add(jlEmail);
        add(jtfPostcode);
        add(jtfHuisnummer);
        add(jtfStraat);
        add(jbAanpassen);

        try {
            URL urlID = new URL(accountHouder.getIdkaart());
            imageID = ImageIO.read(urlID);
            URL urlOV = new URL(accountHouder.getOvkaart());
            imageOV = ImageIO.read(urlOV);

        } catch (IOException ex) {

        }

    }

    protected boolean isIngevuld() {
        for (JTextField veld : verplichteVelden) {
            if (veld.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Laat de afbeeldingen zien in panel
        g.drawImage(imageID, 80, 340, 300, 150, null);
        g.drawImage(imageOV, 450, 340, 300, 150, null);
    }

    protected void veranderAccGegevens() {
        String strNaam = jtfNaam.getText();
        String strAchternaam = jtfAchternaam.getText();
        String strTelefoonnummer = jtfTelnummer.getText();
        String strWoonplaats = jtfWoonplaats.getText();
        String strPostcode = jtfPostcode.getText();
        String strStraat = jtfStraat.getText();
        String strHuisnummer = jtfHuisnummer.getText();

        a.setNaam(strNaam);
        a.setAchternaam(strAchternaam);
        a.setTelefoonnr(strTelefoonnummer);
        Locatie locatie = a.getLocatie();
        locatie.setPlaats(strWoonplaats);
        locatie.setPostcode(strPostcode);
        locatie.setStraat(strStraat);
        locatie.setHuisnummer(strHuisnummer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Accounthouder aanpassen met de ingevuld gegevens
        if (e.getSource() == jbAanpassen) {
            if (!isIngevuld()) {
                jlFoutmelding.setText("Een van de verplichte velden is niet ingevuld!");
                return;
            } else {
                jlFoutmelding.setText("");
            }
            veranderAccGegevens();

            databasemanager.updateLocatie(a);
            databasemanager.updateContact(a);
        } //Accounthouder omzetten naar Treinkoerier
        else if (e.getSource() == jbGoedkeuren) {
            a.setType("geverifieerd");

            databasemanager.updateContact(a);
            TreinKoerier koerier = new TreinKoerier(0, a.getRekeningnr(), a.getNaam(), a.getType(), a.getEmail(), a.getTelefoonnr(), a.getContactID(), a.getAchternaam(), a.getLocatie());
            ArrayList<Contact> contacten = databasemanager.getContacten();
            int i = contacten.indexOf(a);
            contacten.remove(i);
            contacten.add(i, koerier);
            databasemanager.getContactMap().put(i, koerier);
            
        }
        overzicht.refresh();

    }

}
