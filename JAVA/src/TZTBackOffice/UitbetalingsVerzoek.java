package TZTBackOffice;

import java.time.LocalDateTime;

/**
 *
 * @author Michiel
 */
public class UitbetalingsVerzoek {

    private LocalDateTime datum;
    private double bedrag;
    private boolean afgehandeld;
    private AccountHouder koerier;

    public void handelAf() {
        afgehandeld = true;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public double getBedrag() {
        return bedrag;
    }

    public boolean isAfgehandeld() {
        return afgehandeld;
    }

    public AccountHouder getKoerier() {
        return koerier;
    }
}