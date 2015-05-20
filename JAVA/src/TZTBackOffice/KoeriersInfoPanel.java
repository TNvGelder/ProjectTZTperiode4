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
    
 private JLabel jlHead, jlTelnummer, jlNaam, jlEmail, jlTarieven;
 private JTextField jtfNaam, jtfTelnummer, jtfEmail;
 private JTextArea jtaTarieven;
 private JButton jbAanpassen;
 
    
    public KoeriersInfoPanel(KoeriersDienst k) {

        setLayout(null);
        jbAanpassen = new JButton("Aanpassen");
        this.add(jbAanpassen);
       
         //Inhoud scherm
        jlHead = new JLabel("Koeriers tonen");
        jlHead.setForeground(Color.blue);
        jlHead.setFont(new Font("Serif", Font.BOLD, 20));

        jlNaam = new JLabel("Naam:");
        jlTelnummer = new JLabel("Tel. Nummer:");
        jlEmail = new JLabel("E-mail adres:");
        jlTarieven = new JLabel("Tarieven:");
//        jlNaamError = new JLabel("");
//        jlNaamError.setForeground(Color.red);
//        jlNaamError.setFont(new Font("Serif", Font.BOLD, 20));
//
//        jlEmailError = new JLabel("");
//        jlEmailError.setForeground(Color.red);
//        jlEmailError.setFont(new Font("Serif", Font.BOLD, 20));

        jtfNaam = new JTextField(30);
        jtfTelnummer = new JTextField(15);
        jtfEmail = new JTextField(25);

        jtaTarieven = new JTextArea(5, 30);

        
        //btn2 = new JButton("Voeg tekst in");

//        event e = new event();
//        btn2.addActionListener(e);
        //btn1.addActionListener(this);
        jlHead.setBounds(80, 30, 400, 30);
        jlNaam.setBounds(80, 70, 200, 30);
        jlTelnummer.setBounds(80, 110, 200, 30);
        jlEmail.setBounds(80, 150, 200, 30);
        jlTarieven.setBounds(80, 190, 200, 30);
        jtfNaam.setBounds(180, 70, 200, 30);
        jtfTelnummer.setBounds(180, 110, 200, 30);
        jtfEmail.setBounds(180, 150, 200, 30);

        jtaTarieven.setBounds(180, 190, 200, 120);

        jbAanpassen.setBounds(228, 315, 150, 20);

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
        
        
        
   
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
}
