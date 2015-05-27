/*
 * Gemaakt door: Richard
 * Aangepast door: Jasper
 * Functie: Laat de koeriersdienst gegevens zien in een JPanel
 */
package TZTBackOffice;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KoeriersInfoPanel extends JPanel implements ActionListener {

    private JLabel jlHead, jlNaam, jlTelnummer, jlEmail, jlFoutmelding;
    private JTextField jtfNaam, jtfTelnummer, jtfEmail;
    private JButton jbVerwijder, jbBevestig, btn2;
    private DatabaseManager databasemanager;
    private ContactOverzichtPanel contactOverzicht;
    private int koeriersID;
    private boolean isToevoeg;
    private KoeriersDienst koeriersDienst;
    private KoerierToevoegenDialoog dialoog;
    
    public KoeriersInfoPanel(KoeriersDienst koeriersdienst, DatabaseManager databasemanager, ContactOverzichtPanel contactOverzicht, boolean isToevoeg) {
        this.koeriersDienst = koeriersdienst;
        this.databasemanager = databasemanager;
        this.contactOverzicht = contactOverzicht;
        this.isToevoeg = isToevoeg;
        setLayout(null);

        //Inhoud scherm
        if (isToevoeg) {
            jlHead = new JLabel("Toevoegen koeriersdienst");
            jbBevestig = new JButton("Toevoegen");
        } else {
            jlHead = new JLabel("Wijzigen koeriersdienst");
            jbVerwijder = new JButton("Verwijderen");
            jbVerwijder.addActionListener(this);
            jbVerwijder.setBounds(80, 250, 150, 20);
            jbBevestig = new JButton("Wijzigen");
            add(jbVerwijder);
        }

        jlHead.setForeground(Color.blue);
        jlHead.setFont(new Font("Roboto-Regular", Font.PLAIN, 22));

        jlNaam = new JLabel("Naam:");
        jlTelnummer = new JLabel("Tel. Nummer:");
        jlEmail = new JLabel("Email: ");
        jlFoutmelding = new JLabel("");
        jlFoutmelding.setForeground(Color.red);
        jlFoutmelding.setFont(new Font("Roboto-Regular", Font.PLAIN, 20));

        jtfNaam = new JTextField();
        jtfTelnummer = new JTextField();
        jtfEmail = new JTextField();
        

        btn2 = new JButton("Voeg tekst in");

        jlHead.setBounds(80, 30, 400, 30);
        jlNaam.setBounds(80, 110, 200, 30);
        jlTelnummer.setBounds(80, 150, 200, 30);
        jlFoutmelding.setBounds(80, 70, 500, 30);
        jtfNaam.setBounds(240, 110, 200, 30);
        jtfTelnummer.setBounds(240, 150, 200, 30);
        jtfEmail.setBounds(240, 190, 200, 30);
        jlEmail.setBounds(80, 190, 200, 30);
        jbBevestig.setBounds(290, 250, 150, 20);

        if (koeriersDienst != null) {
            koeriersID = koeriersDienst.getContactID();
            String naam = koeriersDienst.getNaam();
            String telefoon = koeriersDienst.getTelefoonnr();
            String email = koeriersDienst.getEmail();
            jtfNaam.setText(naam);
            jtfTelnummer.setText(telefoon);
            jtfEmail.setText(email);

        } else {
            ArrayList<Contact> contacten = databasemanager.getContacten();
            koeriersID = 0;
            if (contacten.size() > 0) {
                koeriersID = contacten.get(0).getContactID() + 1;
            }
        }

        //Inhoud toevoegen
        add(jlHead);
        add(jlNaam);
        add(jlTelnummer);
        add(jlEmail);
        add(jlFoutmelding);
        add(jtfNaam);
        add(jtfTelnummer);
        add(jtfEmail);

        add(jbBevestig);
        add(btn2);

        jbBevestig.addActionListener(this);
    }

    public void addDialoog(KoerierToevoegenDialoog dialoog){
        this.dialoog = dialoog;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jbBevestig) {
            //Zet JTextField data om in Strings
            String strNaam = jtfNaam.getText();
            String strTelnummer = jtfTelnummer.getText();
            String strEmail = jtfEmail.getText();

            String strType = "koeriersdienst";

            //Check of Naam en Email zijn ingevuld
            if (jtfNaam.getText().isEmpty() || jtfEmail.getText().isEmpty() || jtfTelnummer.getText().isEmpty()) {
                jlFoutmelding.setText("Een van de velden is niet ingevuld!");
                return;
            } else {
                jlFoutmelding.setText("");
                if (isToevoeg) {
                    //Maak de koerier aa nen voeg hem toe aan de database.
                    KoeriersDienst koeriersdienst1 = new KoeriersDienst(strNaam, strType, strEmail, strTelnummer, koeriersID);
                    databasemanager.voegKoeriersdienstToe(koeriersdienst1);
                    if (dialoog != null){
                        dialoog.dispose();
                    }
                } else{
                    koeriersDienst.setEmail(strEmail);
                    koeriersDienst.setTelefoonnr(strTelnummer);
                    koeriersDienst.setNaam(strNaam);
                    databasemanager.updateContact(koeriersDienst);
                }
            }
        }else if (e.getSource() == jbVerwijder){
             databasemanager.verwijderContact(koeriersDienst);
        }
        contactOverzicht.refresh();

    }
}
