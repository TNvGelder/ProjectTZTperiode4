/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.time.LocalDateTime;

/**
 *
 * @author Twan
 */
public class Klacht extends Probleem {
    private Pakket pakket;

    
    public Klacht(Pakket pakket, String titel, String beschrijving, LocalDateTime datum) {
        super(titel, beschrijving, datum);
        this.pakket = pakket;
    }

    
    
    public Pakket getPakket() {
        return pakket;
    }
    
    
}
