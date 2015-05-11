/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.time.LocalDateTime;

/**
 *
 * @author Richard
 */
public class Probleem {
    
    private String titel;
    private String beschrijving;
    private LocalDateTime datum;

    
    public Probleem(String titel, String beschrijving, LocalDateTime datum) {
        this.titel = titel;
        this.beschrijving = beschrijving;
        this.datum = datum;
    }
    
    
    public String getTitel() {
        return titel;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public LocalDateTime getDatum() {
        return datum;
    }
    
    
    
     
}
