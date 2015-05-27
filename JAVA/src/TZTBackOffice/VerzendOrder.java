/*
 * Gemaakt door: Twan
 * Aangepast door: -
 * Functie: Het verkrijgen van verzendorder gegevens
 */
package TZTBackOffice;

import java.sql.Timestamp;

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

    @Override
    public String toString() {
        return "VerzendOrder{" + "klant=" + klant.getContactID() + ", aanmeldTijd=" + aanmeldTijd + ", orderID=" + orderID + ", beginLocatie=" + beginLocatie + ", eindLocatie=" + eindLocatie + '}';
    }

}
