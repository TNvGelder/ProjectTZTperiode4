/*
 * Gemaakt door: Twan
 * Aangepast door: -
 * Functie: Het aanmaken, wijzigen en verkrijgen van klachten
 */
package TZTBackOffice;

import java.sql.Timestamp;

public class Klacht extends Probleem {

    private Pakket pakket;

    public Klacht(int probleemID, String titel, String beschrijving, Timestamp datum, boolean afgehandeld) {
        super(probleemID, titel, beschrijving, datum, afgehandeld);
    }

    public Pakket getPakket() {
        return pakket;
    }

    public void setPakket(Pakket pakket) {
        this.pakket = pakket;
    }

}
