package TZTBackOffice;

import java.sql.Timestamp;


/**
 *
 * @author Michiel
 */
public class UitbetalingsVerzoek {

    private Timestamp datum;
    private double bedrag;
    private boolean afgehandeld;
    private AccountHouder koerier;
    private boolean goedgekeurd;

    public UitbetalingsVerzoek(Timestamp datum, double bedrag, boolean afgehandeld, AccountHouder koerier, boolean isGoedgekeurd) {
        this.datum = datum;
        this.bedrag = bedrag;
        this.afgehandeld = afgehandeld;
        this.koerier = koerier;
        this.goedgekeurd = isGoedgekeurd;
    }

    public void handelAf() {
        afgehandeld = true;
    }

    public Timestamp getDatum() {
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

    public boolean isGoedgekeurd() {
        return goedgekeurd;
    }
    
}
