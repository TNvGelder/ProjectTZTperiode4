/*
 * Gemaakt door: Twan
 * Aangepast door: -
 * Functie: Laat de uitbetaling zien
 */
package TZTBackOffice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.JFrame;

public class Betalingscherm extends JFrame implements ActionListener {

    private int id;
    private String naam;
    private String achternaam;
    private LocalDateTime datum;
    private String uitbetaling;

    public Betalingscherm() {
        setTitle("Overzicht pakketten");
        setSize(1920, 1000);
        setLayout(new GridLayout(6, 1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
