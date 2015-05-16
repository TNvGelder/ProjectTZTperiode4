/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

/**
 *
 * @author Twan
 */
public class AccountHouder extends Contact {
    private String achternaam;
    private Locatie locatie;

    public AccountHouder(String voornaam, String email, String telefoonnr, int contactID, String achternaam, Locatie locatie) {
        super(voornaam, email, telefoonnr, contactID);
        this.achternaam = achternaam;
        this.locatie = locatie;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public Locatie getLocatie(){
        return locatie;
    }

    @Override
    public String toString() {
        return "AccountHouder{" + super.toString() + "achternaam=" + achternaam + ", locatie=" + locatie + '}';
    }
    
    
}
