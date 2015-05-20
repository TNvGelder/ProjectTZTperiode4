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

    private JLabel jlHead, jlTelnummer, jlNaam, jlEmail, jlTarieven;
    private JTextField jtfNaam, jtfTelnummer, jtfEmail;
    private JTextArea jtaTarieven;
    private JButton jbAanpassen;

    public AccountHoudersInfoPanel(AccountHouder accountHouder) {
        
       this.setLayout(null); 
        
        //add(jlHead);
       
        jbAanpassen = new JButton("Aanpassen");
        this.add(jbAanpassen);

        jlHead = new JLabel("Accounthouder");
        jlHead.setForeground(Color.blue);
        jlHead.setFont(new Font("Roboto-Regular", Font.PLAIN, 22));

        jlNaam = new JLabel("Naam: ");
        jlTelnummer = new JLabel("Tel. Nummer: ");
        jlEmail = new JLabel("E-mail adres: ");
        jlTarieven = new JLabel("Tarieven:");


        jtfNaam = new JTextField(accountHouder.getNaam());
        jtfTelnummer = new JTextField(accountHouder.getTelefoonnr());
        jtfEmail = new JTextField(accountHouder.getEmail());

        jtaTarieven = new JTextArea (15, 30);

        jlHead.setBounds(80, 30, 400, 30);
        jlNaam.setBounds(80, 70, 200, 30);
        jlTelnummer.setBounds(80, 110, 200, 30);
        jlEmail.setBounds(80, 150, 200, 30);
        jlTarieven.setBounds(80, 190, 200, 30);
        jtfNaam.setBounds(180, 70, 200, 30);
        jtfTelnummer.setBounds(180, 110, 200, 30);
        jtfEmail.setBounds(180, 150, 200, 30);
        jbAanpassen.setBounds(228, 315, 150, 20);

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

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }

}
