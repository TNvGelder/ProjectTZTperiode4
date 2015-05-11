package TZTBackOffice;

import java.time.LocalDateTime;

/**
 *
 * @author Michiel
 */
public class Uitbetalingsverzoek {

    private LocalDateTime datum;
    private double bedrag;
    private boolean afgehandeld;
    private Accounthouder koerier;

    public handelAf() {
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

    public Accounthouder getKoerier() {
        return koerier;
    }
}
