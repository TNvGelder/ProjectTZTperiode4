/*
 * Gemaakt door: Richard
 * Aangepast door: Jasper
 * Functie: Maakt een dialoog om een nieuwe koeriersdienst in toe te voegen
 */
package TZTBackOffice;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KoerierToevoegenDialoog extends JDialog implements ActionListener {

    JTextArea textarea;
    JButton button;
    JLabel label;

    private JLabel jlHead, jlNaam, jlTelnummer, jlEmail, jlNaamError, jlEmailError;
    private JTextField jtfNaam, jtfTelnummer, jtfEmail;
    private JButton jbToevoegen, btn2;
//    private JTextArea jtaTarieven;
    private DatabaseManager databasemanager;
    private ContactOverzichtPanel contactOverzicht;

    //start tarief, waarde omslag, prijs per km
    public KoerierToevoegenDialoog(DatabaseManager databasemanager, ContactOverzichtPanel contactOverzicht) {
        this.databasemanager = databasemanager;
        this.contactOverzicht = contactOverzicht;

        //Opmaak van JDialoog
        setTitle("Toevoegen koeriersdienst");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //---> geeft een foutmelding bij in gebruik neming

        //Inhoud scherm
        jlHead = new JLabel("Registratie formulier");
        jlHead.setForeground(Color.blue);
        jlHead.setFont(new Font("Roboto-Regular", Font.PLAIN, 22));

        jlNaam = new JLabel("Naam:");
        jlTelnummer = new JLabel("Tel. Nummer:");
        jlEmail = new JLabel("E-mail adres:");
        jlNaamError = new JLabel("");
        jlNaamError.setForeground(Color.red);
        jlNaamError.setFont(new Font("Roboto-Regular", Font.PLAIN, 20));

        jlEmailError = new JLabel("");
        jlEmailError.setForeground(Color.red);
        jlEmailError.setFont(new Font("Serif", Font.BOLD, 20));

        jtfNaam = new JTextField();
        jtfTelnummer = new JTextField();
        jtfEmail = new JTextField();
        jbToevoegen = new JButton("Toevoegen");
        btn2 = new JButton("Voeg tekst in");

        jlHead.setBounds(80, 30, 400, 30);
        jlNaam.setBounds(80, 70, 200, 30);
        jlTelnummer.setBounds(80, 110, 200, 30);
        jlEmail.setBounds(80, 150, 200, 30);
        jlNaamError.setBounds(240, 70, 500, 30);
        jlEmailError.setBounds(240, 70, 500, 30);
        jtfNaam.setBounds(240, 70, 200, 30);
        jtfTelnummer.setBounds(240, 110, 200, 30);
        jtfEmail.setBounds(240, 150, 200, 30);
        jbToevoegen.setBounds(290, 210, 150, 20);

        //Inhoud toevoegen
        add(jlHead);
        add(jlNaam);
        add(jlTelnummer);
        add(jlEmail);
//        add(jlTarieven);
        add(jlNaamError);
        add(jtfNaam);
        add(jtfTelnummer);
        add(jtfEmail);
        add(jlEmailError);

        add(jbToevoegen);
        add(btn2);

//        add(jtaTarieven);
        event e = new event();
        jbToevoegen.addActionListener(e);

        //setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class event implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //Actionperformed voor Toevoegen knop
            if (e.getSource() == jbToevoegen) {
                //Zet JTextField data om in Strings
                String strNaam = jtfNaam.getText();
                String strTelnummer = jtfTelnummer.getText();
                String strEmail = jtfEmail.getText();

                String strType = "4";

                //Check of Naam en Email zijn ingevuld
                if (jtfNaam.getText().isEmpty()) {
                    jlNaamError.setText("Vul naam in!");
                    System.out.println("%naam invullen%");
                } else if (jtfEmail.getText().isEmpty()) {
                    jlEmailError.setText("Vul Email in!");
                    System.out.println("%email invullen%");
                } else {
                    //Maak contact en koerier aan
                    ArrayList<Contact> contacten = databasemanager.getContacten();
                    int nieuweContactID = 1;
                    if (contacten.size() > 0) {
                        nieuweContactID = contacten.get(0).getContactID() + 1;
                    }
                    KoeriersDienst koeriersdienst1 = new KoeriersDienst(strNaam, strType, strEmail, strTelnummer, nieuweContactID);
                    databasemanager.voegKoeriersdienstToe(koeriersdienst1);
                    contactOverzicht.refresh();
                    dispose();
                }

            }
        }
    }
}
