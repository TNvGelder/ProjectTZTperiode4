/*
 * Gemaakt door: Richard
 * Aangepast door: Jasper
 * Functie: Maakt een dialoog om een nieuwe koeriersdienst in toe te voegen
 */
package TZTBackOffice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KoerierToevoegenDialoog extends JDialog{

    JTextArea textarea;
    JButton button;
    JLabel label;

    private JLabel jlHead, jlNaam, jlTelnummer, jlEmail, jlNaamError, jlEmailError;
    private JTextField jtfNaam, jtfTelnummer, jtfEmail;
    private JButton jbToevoegen, btn2;
//    private JTextArea jtaTarieven;
    private DatabaseManager databasemanager;
    private ContactOverzichtPanel contactOverzicht;

    //Koeriersinfodialoog laad een koeriersinfopanel in een dialoog zodat iemand 
    public KoerierToevoegenDialoog(DatabaseManager databasemanager, ContactOverzichtPanel contactOverzicht) {
        this.databasemanager = databasemanager;
        this.contactOverzicht = contactOverzicht;

        //Opmaak van JDialoog
        setTitle("Toevoegen koeriersdienst");
        setSize(600, 400);
        setLayout(new GridLayout(1, 1));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //---> geeft een foutmelding bij in gebruik neming

        KoeriersInfoPanel panel = new KoeriersInfoPanel(null, databasemanager, contactOverzicht, true);
        panel.addDialoog(this);
        add(panel);
    }
}
