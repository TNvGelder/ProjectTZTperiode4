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
    private int definitief;

    public VerzendOrder(int orderID, AccountHouder klant, Timestamp aanmeldTijd) {
        this.orderID = orderID;
        this.klant = klant;
        this.aanmeldTijd = aanmeldTijd;
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

    public int getDefinitief() {
        return definitief;
    }

}
