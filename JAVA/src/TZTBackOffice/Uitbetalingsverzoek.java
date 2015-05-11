package TZTBackOffice;

import java.time.LocalDateTime;

/**
 *
 * @author Michiel
 */
public class Uitbetalingsverzoek {

    private LocalDateTime datum;
    private Double bedrag;
    private Boolean afgehandeld;
    private koerier Accounthouder;

    public handelAf() {

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

    public accounthouder getKoerier() {
        return koerier;
    }
}
