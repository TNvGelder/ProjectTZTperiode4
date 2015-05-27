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

/**
 *
 * @author Michiel
 */
public class Betalingscherm extends JFrame implements ActionListener {

    private int id;
    private String naam;
    private String achternaam;
    private LocalDateTime datum;

    private String uitbetaling;

//<<<<<<< HEAD
    public Betalingscherm() {
//=======
        //  public Betalingscherm() {
//>>>>>>> fc014ddb3b819da0e2875ca25534bc0bdb6de4c6
        this.uitbetaling = uitbetaling;
        setTitle("Overzicht pakketten");
        setSize(1920, 1000);
        setLayout(new GridLayout(6, 1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

//@Michiel, niet meer met ERRORS pullen A.U.B.
