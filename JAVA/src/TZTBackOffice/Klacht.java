/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.sql.Timestamp;

/**
 *
 * @author Twan
 */
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
