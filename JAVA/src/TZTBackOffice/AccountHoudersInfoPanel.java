/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Richard
 */
public class AccountHoudersInfoPanel extends JPanel implements ActionListener {

    protected JLabel jlHead, jlTelnummer, jlNaam, jlAchternaam, jlEmail, jlAccountIDBeschrijving, jlWoonplaats, jlPostcode, jlHuisnummer, jlAccountID, jlStraat;
    private JTextField jtfNaam, jtfTelnummer, jtfEmail, jtfAchternaam, jtfWoonplaats, jtfPostcode, jtfHuisnummer, jtfStraat;
    private JButton jbAanpassen;
    private AccountHouder a;
    private DatabaseManager databasemanager;

    public AccountHoudersInfoPanel(AccountHouder accountHouder, DatabaseManager databasemanager) {
        this.databasemanager = databasemanager;
        this.setLayout(null);
        this.a = accountHouder;
        //add(jlHead);
        jbAanpassen = new JButton("Aanpassen");
        this.add(jbAanpassen);

        jlHead = new JLabel("Accounthouder");
        jlHead.setForeground(Color.blue);
        jlHead.setFont(new Font("Roboto-Regular", Font.PLAIN, 22));

        jlNaam = new JLabel("Voornaam: ");
        jlTelnummer = new JLabel("Tel. Nummer: ");
        jlEmail = new JLabel("E-mail adres: ");
        jlAchternaam = new JLabel("Achternaam: ");
        jlWoonplaats = new JLabel("Woonplaats: ");
        jlAccountIDBeschrijving = new JLabel("Account ID: ");
        jlPostcode = new JLabel("Postcode: ");
        jlHuisnummer = new JLabel("Huisnummer: ");
        jlAccountID = new JLabel(accountHouder.getContactID() + "");
        jlStraat = new JLabel("Straat: ");

        jtfNaam = new JTextField(accountHouder.getNaam());
        jtfTelnummer = new JTextField(accountHouder.getTelefoonnr());
        jtfEmail = new JTextField(accountHouder.getEmail());
        jtfAchternaam = new JTextField(accountHouder.getAchternaam());
        jtfWoonplaats = new JTextField(accountHouder.getLocatie().getPlaats());
        jtfPostcode = new JTextField(accountHouder.getLocatie().getPostcode());
        jtfHuisnummer = new JTextField(accountHouder.getLocatie().getHuisnummer());
        jtfStraat = new JTextField(accountHouder.getLocatie().getStraat());

        //jtfAchternaam, jtfWoonplaats, jtfPostcode, jtfHuisnummer, jtfToevoeging
        jlHead.setBounds(80, 30, 400, 30);

        jlNaam.setBounds(80, 70, 200, 30);
        jtfNaam.setBounds(180, 70, 200, 30);

        jlAchternaam.setBounds(450, 70, 200, 30);
        jtfAchternaam.setBounds(550, 70, 200, 30);

        jlEmail.setBounds(80, 110, 200, 30);
        jtfEmail.setBounds(180, 110, 200, 30);

        jlTelnummer.setBounds(450, 110, 200, 30);
        jtfTelnummer.setBounds(550, 110, 200, 30);

        jlAccountIDBeschrijving.setBounds(80, 150, 200, 30);
        jlAccountID.setBounds(180, 150, 200, 30);

        jlWoonplaats.setBounds(80, 190, 200, 30);
        jtfWoonplaats.setBounds(180, 190, 200, 30);

        jlPostcode.setBounds(450, 190, 200, 30);
        jtfPostcode.setBounds(550, 190, 200, 30);

        jlStraat.setBounds(80, 230, 200, 30);
        jtfStraat.setBounds(180, 230, 200, 30);

        jlHuisnummer.setBounds(450, 230, 200, 30);
        jtfHuisnummer.setBounds(550, 230, 200, 30);

        jbAanpassen.setBounds(228, 315, 150, 20);
        jbAanpassen.addActionListener(this);

        //Inhoud toevoegen
        add(jlHead);
        add(jlNaam);
        add(jlTelnummer);
        add(jlEmail);

        add(jlAchternaam);
        add(jlWoonplaats);
        add(jlAccountIDBeschrijving);
        add(jlPostcode);
        add(jlHuisnummer);
        add(jlAccountID);
        add(jlStraat);

        add(jtfNaam);
        add(jtfTelnummer);
        add(jtfEmail);

        add(jtfAchternaam);
        add(jtfWoonplaats);
        add(jtfEmail);
        add(jtfPostcode);
        add(jtfHuisnummer);
        add(jtfStraat);

//        add(new JButton(accountHouder.getNaam()));
//        Locatie locatie = accountHouder.getLocatie();
//
//        add(new JTextField(accountHouder.getNaam()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jbAanpassen) {
            System.out.println("ik ben geprint bij accounthoudersinfopanel");
            String strNaam = jtfNaam.getText();
            String strTelefoonnummer = jtfTelnummer.getText();
            String strEmail = jtfEmail.getText();

            a.setNaam(strNaam);
            databasemanager.updateAccounthouder(a);
        }
    }

}
