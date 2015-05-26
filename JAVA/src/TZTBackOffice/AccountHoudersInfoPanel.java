/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Richard
 */
public class AccountHoudersInfoPanel extends JPanel implements ActionListener {

    protected JLabel jlHead, jlTelnummer, jlNaam, jlAchternaam, jlEmailBeschrijving, jlAccountIDBeschrijving, jlWoonplaats, jlPostcode, jlHuisnummer, jlAccountID, jlStraat, jlEmail;
    protected JTextField jtfNaam, jtfTelnummer, jtfAchternaam, jtfWoonplaats, jtfPostcode, jtfHuisnummer, jtfStraat;
    protected JButton jbAanpassen, jbGoedkeuren;
    private AccountHouder a;
    private DatabaseManager databasemanager;
    private BufferedImage imageID;
    private BufferedImage imageOV;

    public AccountHoudersInfoPanel(AccountHouder accountHouder, DatabaseManager databasemanager) {
        this.databasemanager = databasemanager;
        this.setLayout(null);
        this.a = accountHouder;
        //add(jlHead);
        jbAanpassen = new JButton("Aanpassen");
        this.add(jbAanpassen);

        jbGoedkeuren = new JButton("Goedkeuren");
        this.add(jbGoedkeuren);

        jlHead = new JLabel("Accounthouder");
        jlHead.setForeground(Color.blue);
        jlHead.setFont(new Font("Roboto-Regular", Font.PLAIN, 22));

        jlNaam = new JLabel("Voornaam: ");
        jlTelnummer = new JLabel("Tel. Nummer: ");
        jlEmailBeschrijving = new JLabel("E-mail adres: ");
        jlAchternaam = new JLabel("Achternaam: ");
        jlWoonplaats = new JLabel("Woonplaats: ");
        jlAccountIDBeschrijving = new JLabel("Account ID: ");
        jlPostcode = new JLabel("Postcode: ");
        jlHuisnummer = new JLabel("Huisnummer: ");
        jlAccountID = new JLabel(accountHouder.getContactID() + "");
        jlStraat = new JLabel("Straat: ");
        jlEmail = new JLabel(accountHouder.getEmail());

        jtfNaam = new JTextField(accountHouder.getNaam());
        jtfTelnummer = new JTextField(accountHouder.getTelefoonnr());
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

        jlEmailBeschrijving.setBounds(80, 110, 200, 30);
        jlEmail.setBounds(180, 110, 200, 30);

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

        if (accountHouder.getLinkIDKaart() == null) {
            jbAanpassen.setBounds(228, 300, 150, 20);
            jbAanpassen.addActionListener(this);

            jbGoedkeuren.setBounds(600, 300, 150, 20);
            jbGoedkeuren.addActionListener(this);
        } else {
            jbAanpassen.setBounds(228, 490, 150, 20);
            jbAanpassen.addActionListener(this);

            jbGoedkeuren.setBounds(600, 490, 150, 20);
            jbGoedkeuren.addActionListener(this);
        }

        //Inhoud toevoegen
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

        add(jtfNaam);
        add(jtfTelnummer);

        add(jtfAchternaam);
        add(jtfWoonplaats);
        add(jlEmail);
        add(jtfPostcode);
        add(jtfHuisnummer);
        add(jtfStraat);

        try {
//            imageID = ImageIO.read(new File(accountHouder.getLinkIDKaart()));
            URL urlID = new URL(accountHouder.getLinkIDKaart());
            imageID = ImageIO.read(urlID);
            URL urlOV = new URL(accountHouder.getLinkOVKaart());
            imageOV = ImageIO.read(urlOV);

        } catch (IOException ex) {
            System.out.println(ex);
        }

//        add(new JButton(accountHouder.getNaam()));
//        Locatie locatie = accountHouder.getLocatie();
//
//        add(new JTextField(accountHouder.getNaam()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageID, 80, 300, 300, 150, null);
        g.drawImage(imageOV, 450, 300, 300, 150, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jbAanpassen) {
            System.out.println("ik ben geprint bij accounthoudersinfopanel");
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
            a.getLocatie().setPlaats(strWoonplaats);
            a.getLocatie().setPostcode(strPostcode);
            a.getLocatie().setStraat(strStraat);
            a.getLocatie().setHuisnummer(strHuisnummer);
            a.setType("1");

            databasemanager.updateLocatie(a);
            databasemanager.updateContact(a);
        }

        if (e.getSource() == jbGoedkeuren) {
            a.setType("2");

            databasemanager.updateContact(a);
        }

    }

}
