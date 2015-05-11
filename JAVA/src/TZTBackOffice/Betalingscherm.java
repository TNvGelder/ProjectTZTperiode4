package TZTBackOffice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Michiel
 */
public class Betalingscherm extends JFrame implements ActionListener {

    private int id;
    private String naam;
    private String achternaam;
    private DateTime datum;

    private String uitbetaling;

    public Betalingscherm()
        ) {
        this.uitbetaling = uitbetaling;
        setTitle("Overzicht pakketten");
        setSize(1920, 1000);
        setLayout(new GridLayout(6, 1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
