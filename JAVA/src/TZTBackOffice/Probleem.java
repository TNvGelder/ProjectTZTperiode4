/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.sql.Timestamp;

/**
 *
 * @author Richard
 */
public class Probleem {
    
    private int probleemID;
    private String titel;
    private String beschrijving;
    private Timestamp datum;
    private boolean afgehandeld;
    
    public Probleem(int probleemID, String titel, String beschrijving, Timestamp datum, boolean afgehandeld) {
        this.probleemID = probleemID;
        this.titel = titel;
        this.beschrijving = beschrijving;
        this.datum = datum;
        this.afgehandeld = afgehandeld;
    }

    public int getProbleemID() {
        return probleemID;
    }
    
    public String getTitel() {
        return titel;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public Timestamp getDatum() {
        return datum;
    }

    public boolean isAfgehandeld() {
        return afgehandeld;
    }

    public void setAfgehandeld(boolean afgehandeld) {
        this.afgehandeld = afgehandeld;
    }

    @Override
    public String toString() {
        return "Probleem{" + "probleemID=" + probleemID + ", titel=" + titel + ", beschrijving=" + beschrijving + ", datum=" + datum + ", afgehandeld=" + afgehandeld + '}';
    }
    
    
    
}
