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
    private int orderID;
    private Locatie beginLocatie;
    private Locatie eindLocatie;

    public VerzendOrder(AccountHouder klant, Timestamp aanmeldTijd, int orderID, Locatie beginLocatie, Locatie eindlocatie) {
        this.klant = klant;
        this.aanmeldTijd = aanmeldTijd;
        this.orderID = orderID;
        this.beginLocatie = beginLocatie;
        this.eindLocatie = eindlocatie;
    }
        
    public int getOrderID() {
        return orderID;
    }

    public AccountHouder getKlant() {
        return klant;
    }

    public Timestamp getAanmeldTijd() {
        return aanmeldTijd;
    }
    
    public Locatie getBeginLocatie() {
        return beginLocatie;
    }

    public Locatie getEindLocatie() {
        return eindLocatie;
    }
    
}
