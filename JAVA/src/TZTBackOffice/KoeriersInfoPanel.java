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
public class KoeriersInfoPanel extends JPanel implements ActionListener {

    private JLabel jlHead, jlTelnummer, jlNaam, jlEmail, jlStartTarief, jlWaardeOmslag, jlPrijsPerKm;
    private JTextField jtfNaam, jtfTelnummer, jtfEmail, jtfStartTarief, jtfWaardeOmslag, jtfPrijsPerKm;
    private JTextArea jtaTarieven;
    private JButton jbAanpassen;

    private DatabaseManager databasemanager;
    private KoeriersDienst k;

    public KoeriersInfoPanel(KoeriersDienst koeriersdienst) {
//        super(koeriersdienst, databasemanager);
//        this.databasemanager = databasemanager;
        this.setLayout(null);
        this.k = koeriersdienst;

        setLayout(null);
        jbAanpassen = new JButton("Aanpassen");
        this.add(jbAanpassen);

        //Inhoud scherm
        jlHead = new JLabel("Koeriers tonen");
        jlHead.setForeground(Color.blue);
        jlHead.setFont(new Font("Roboto-Regular", Font.PLAIN, 22));

        jlNaam = new JLabel("Naam: ");
        jlTelnummer = new JLabel("Tel. Nummer: ");
        jlEmail = new JLabel("E-mail adres: ");
        jlStartTarief = new JLabel("Start Tarief:");
        jlWaardeOmslag = new JLabel("Waarde van omslag:");
        jlPrijsPerKm = new JLabel("Prijs per km:");
//        jlTarieven = new JLabel("Tarieven: ");
//        jlNaamError = new JLabel("");
//        jlNaamError.setForeground(Color.red);
//        jlNaamError.setFont(new Font("Serif", Font.BOLD, 20));
//
//        jlEmailError = new JLabel("");
//        jlEmailError.setForeground(Color.red);
//        jlEmailError.setFont(new Font("Serif", Font.BOLD, 20));

        jtfNaam = new JTextField(k.getNaam());
        jtfTelnummer = new JTextField(k.getTelefoonnr());
        jtfEmail = new JTextField(k.getEmail());
        jtfStartTarief = new JTextField();
        jtfWaardeOmslag = new JTextField();
        jtfPrijsPerKm = new JTextField();

//        jtaTarieven = new JTextArea(5, 30);
        //btn2 = new JButton("Voeg tekst in");
//        event e = new event();
//        btn2.addActionListener(e);
        //btn1.addActionListener(this);
        jlHead.setBounds(80, 30, 400, 30);
        jlNaam.setBounds(80, 70, 200, 30);
        jlTelnummer.setBounds(80, 110, 200, 30);
        jlEmail.setBounds(80, 150, 200, 30);
        jlStartTarief.setBounds(80, 190, 200, 30);
        jlWaardeOmslag.setBounds(80, 230, 200, 30);
        jlPrijsPerKm.setBounds(80, 270, 200, 30);
//        jlTarieven.setBounds(80, 190, 200, 30);
//        jtfNaam.setBounds(180, 70, 200, 30);
//        jtfTelnummer.setBounds(180, 110, 200, 30);
//        jtfEmail.setBounds(180, 150, 200, 30);
        jtfNaam.setBounds(240, 70, 200, 30);
        jtfTelnummer.setBounds(240, 110, 200, 30);
        jtfEmail.setBounds(240, 150, 200, 30);
        jtfStartTarief.setBounds(240, 190, 200, 30);
        jtfWaardeOmslag.setBounds(240, 230, 200, 30);
        jtfPrijsPerKm.setBounds(240, 270, 200, 30);

//        jtaTarieven.setBounds(180, 190, 200, 120);
        jbAanpassen.setBounds(290, 315, 150, 20);

        //Inhoud toevoegen
        add(jlHead);
        add(jlNaam);
        add(jlTelnummer);
        add(jlEmail);
//        add(jlTarieven);

        add(jtfNaam);
        add(jtfTelnummer);
        add(jtfEmail);

        add(jlStartTarief);
        add(jlWaardeOmslag);
        add(jlPrijsPerKm);
        add(jtfStartTarief);
        add(jtfWaardeOmslag);
        add(jtfPrijsPerKm);
//        add(jtaTarieven);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}
