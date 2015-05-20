/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Richard
 */
public class AccountHoudersInfoPanel extends JPanel {

    private JLabel jlHead, jlTelnummer, jlNaam, jlEmail, jlTarieven;
    private JTextField jtfNaam, jtfTelnummer, jtfEmail;
    private JTextArea jtaTarieven;
    //private JButton jbAanpassen;

    public AccountHoudersInfoPanel(AccountHouder accountHouder) {
        
       this.setLayout(null); 
        
        //add(jlHead);

        jlHead = new JLabel("Accounthouder");
        jlHead.setForeground(Color.blue);
        jlHead.setFont(new Font("Serif", Font.BOLD, 20));

        jlNaam = new JLabel("Naam: " + accountHouder.getNaam());
        jlTelnummer = new JLabel("Tel. Nummer: " + accountHouder.getTelefoonnr());
        jlEmail = new JLabel("E-mail adres: " + accountHouder.getEmail());
        jlTarieven = new JLabel("Tarieven:");


        jtfNaam = new JTextField(30);
        jtfTelnummer = new JTextField(15);
        jtfEmail = new JTextField(25);

        jtaTarieven = new JTextArea (15, 30);

        jlHead.setBounds(80, 30, 400, 30);
        jlNaam.setBounds(80, 70, 200, 30);
        jlTelnummer.setBounds(80, 110, 200, 30);
        jlEmail.setBounds(80, 150, 200, 30);
        jlTarieven.setBounds(80, 190, 200, 30);
        jtfNaam.setBounds(180, 70, 200, 30);
        jtfTelnummer.setBounds(180, 110, 200, 30);
        jtfEmail.setBounds(180, 150, 200, 30);

        jtaTarieven.setBounds(180, 190, 200, 120);

   

        //Inhoud toevoegen
        add(jlHead);
        add(jlNaam);
        add(jlTelnummer);
        add(jlEmail);
        add(jlTarieven);
        
        add(jtfNaam);
        add(jtfTelnummer);
        add(jtfEmail);
        
        add(jtaTarieven);
        
        
        
        
        
        
//        add(new JButton(accountHouder.getNaam()));
//        Locatie locatie = accountHouder.getLocatie();
//
//        add(new JTextField(accountHouder.getNaam()));

    }

}
