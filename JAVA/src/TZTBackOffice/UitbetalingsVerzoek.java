/*
 * Gemaakt door: Twan
 * Aangepast door: -
 * Functie: Deze class geeft een representatie van een uitbetalingsverzoek uit de database
 */
package TZTBackOffice;

import java.sql.Timestamp;

public class UitbetalingsVerzoek {

    private Timestamp datum;
    private double bedrag;
    private boolean afgehandeld;
    private TreinKoerier koerier;
    private boolean goedgekeurd;

    public UitbetalingsVerzoek(Timestamp datum, double bedrag, boolean afgehandeld, TreinKoerier koerier, boolean isGoedgekeurd) {
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

    public TreinKoerier getKoerier() {
        return koerier;
    }

    public boolean isGoedgekeurd() {
        return goedgekeurd;
    }

    public void setGoedgekeurd(boolean bool) {
        goedgekeurd = bool;
        if (!bool){
            koerier.setKrediet(koerier.getKrediet() + bedrag);
        }
    }

    @Override
    public String toString() {
        return "UitbetalingsVerzoek{" + "datum=" + datum + ", bedrag=" + bedrag + ", afgehandeld=" + afgehandeld + ", koerier=" + koerier + ", goedgekeurd=" + goedgekeurd + '}';
    }

}
