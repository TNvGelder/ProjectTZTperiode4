/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 *
 * @author Richard
 */
class VerzendOrder {
    
    private AccountHouder klant;
    private Timestamp aanmeldTijd;

    public VerzendOrder(AccountHouder klant, Timestamp aanmeldTijd) {
        this.klant = klant;
        this.aanmeldTijd = aanmeldTijd;
    }

    public AccountHouder getKlant() {
        return klant;
    }

    public Timestamp getAanmeldTijd() {
        return aanmeldTijd;
    }

    
   
   
    
    
    
}
