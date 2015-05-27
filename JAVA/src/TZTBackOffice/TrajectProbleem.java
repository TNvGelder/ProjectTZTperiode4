/*
 * Gemaakt door: Twan
 * Aangepast door: -
 * Functie: Het verkrijgen en wijzigen van trajectproblemen
 */
package TZTBackOffice;

import java.sql.Timestamp;

public class TrajectProbleem extends Probleem {

    private Traject bezorging;

    public TrajectProbleem(int probleemID, String titel, String beschrijving, Timestamp datum, boolean afgehandeld) {
        super(probleemID, titel, beschrijving, datum, afgehandeld);
    }

    public Traject getBezorging() {
        return bezorging;
    }

    public void setBezorging(Traject bezorging) {
        this.bezorging = bezorging;
    }

}
