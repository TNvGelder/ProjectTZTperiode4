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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Richard
 */
public class KoerierToevoegenDialoog extends JDialog implements ActionListener {

    JTextArea textarea;
    JButton button;
    JLabel label;

    private JLabel jlHead, jlNaam, jlTelnummer, jlEmail, jlTarieven, jlNaamError, jlEmailError;
    private JTextField jtfNaam, jtfTelnummer, jtfEmail, tf4;
    private JButton jbToevoegen, btn2;
    private JTextArea jtaTarieven;
    private DatabaseManager databasemanager;

    public KoerierToevoegenDialoog(DatabaseManager databasemanager) {
        this.databasemanager = databasemanager;

        //Opmaak van JDialoog
        setTitle("Toevoegen Professionele treinkoerier");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //---> geeft een foutmelding bij in gebruik neming

        System.out.println(databasemanager.getKoeriersDiensten());

        //Inhoud scherm
        jlHead = new JLabel("Registratie formulier");
        jlHead.setForeground(Color.blue);
        jlHead.setFont(new Font("Serif", Font.BOLD, 20));

        jlNaam = new JLabel("Naam:");
        jlTelnummer = new JLabel("Tel. Nummer:");
        jlEmail = new JLabel("E-mail adres:");
        jlTarieven = new JLabel("Tarieven:");
        jlNaamError = new JLabel("");
        jlNaamError.setForeground(Color.red);
        jlNaamError.setFont(new Font("Serif", Font.BOLD, 20));

        jlEmailError = new JLabel("");
        jlEmailError.setForeground(Color.red);
        jlEmailError.setFont(new Font("Serif", Font.BOLD, 20));

        jtfNaam = new JTextField();
        jtfTelnummer = new JTextField();
        jtfEmail = new JTextField();

        jtaTarieven = new JTextArea(5, 30);

        jbToevoegen = new JButton("Toevoegen");
        btn2 = new JButton("Voeg tekst in");

//        event e = new event();
//        btn2.addActionListener(e);
        //btn1.addActionListener(this);
        jlHead.setBounds(80, 30, 400, 30);
        jlNaam.setBounds(80, 70, 200, 30);
        jlTelnummer.setBounds(80, 110, 200, 30);
        jlEmail.setBounds(80, 150, 200, 30);
        jlTarieven.setBounds(80, 190, 200, 30);
        jlNaamError.setBounds(180, 70, 500, 30);
        jlEmailError.setBounds(180, 70, 500, 30);
        jtfNaam.setBounds(180, 70, 200, 30);
        jtfTelnummer.setBounds(180, 110, 200, 30);
        jtfEmail.setBounds(180, 150, 200, 30);

        jtaTarieven.setBounds(180, 190, 200, 120);

        jbToevoegen.setBounds(228, 315, 150, 20);

        //Inhoud toevoegen
        add(jlHead);
        add(jlNaam);
        add(jlTelnummer);
        add(jlEmail);
        add(jlTarieven);
        add(jlNaamError);
        add(jtfNaam);
        add(jtfTelnummer);
        add(jtfEmail);
        add(jlEmailError);

        add(jbToevoegen);
        add(btn2);

        add(jtaTarieven);

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
                String strTarieven = jtaTarieven.getText();
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
                    Contact contact1 = new Contact(strNaam, strType, strEmail, strTelnummer, 1);
                    KoeriersDienst koeriersdienst1 = new KoeriersDienst(strNaam, strType, strEmail, strTelnummer, 1);
                    contact1.setNaam(strNaam);
                    contact1.setEmail(strEmail);
                    contact1.setTelefoonnr(strTelnummer);

                    //Voeg de koerier toe in de DB
                    databasemanager.voegKoeriersdienstToe(koeriersdienst1);
                    dispose();
                }

            }
        }
    }

    public void main(String[] args) {
        KoerierToevoegenDialoog gui = new KoerierToevoegenDialoog(databasemanager);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(600, 400);
        gui.setVisible(true);
    }
}
