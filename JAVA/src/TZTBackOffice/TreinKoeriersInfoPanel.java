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
 * @author Twan
 */
public class TreinKoeriersInfoPanel extends JPanel implements ActionListener{
    
    
    private JLabel jlHead, jlTelnummer, jlNaam, jlEmail, jlTarieven;
    private JTextField jtfNaam, jtfTelnummer, jtfEmail;
    private JTextArea jtaTarieven;
    private JButton jbAanpassen;

public TreinKoeriersInfoPanel(TreinKoerier treinKoerier){
        
       this.setLayout(null); 
        
        //add(jlHead);

        jbAanpassen = new JButton("Aanpassen");
        this.add(jbAanpassen);
        event e = new event();
        jbAanpassen.addActionListener(e);
        
        jlHead = new JLabel("Treinkoerier");
        jlHead.setForeground(Color.blue);
        jlHead.setFont(new Font("Roboto-Regular", Font.PLAIN, 22));

        jlNaam = new JLabel("Naam: ");
        jlTelnummer = new JLabel("Tel. Nummer: ");
        jlEmail = new JLabel("E-mail adres: ");
        jlTarieven = new JLabel("Tarieven:");


        jtfNaam = new JTextField(treinKoerier.getNaam());
        jtfTelnummer = new JTextField(treinKoerier.getTelefoonnr());
        jtfEmail = new JTextField(treinKoerier.getEmail());

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
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public class event implements ActionListener {
    public void actionPerformed(ActionEvent ae) {
    //if (e.getSource == jbAanpassen){
//                String strNaam = jtfNaam.getText();
//                String strTelnummer = jtfTelnummer.getText();
//                String strEmail = jtfEmail.getText();
//                String strTarieven = jtaTarieven.getText();
                
    //}    
     
        
    }
    }
}
