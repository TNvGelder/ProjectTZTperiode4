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
    private String ovkaart;
    private String idkaart;

    public AccountHouder(String voornaam, String type, String email, String telefoonnr, int contactID, String achternaam, Locatie locatie, String ovkaart, String idkaart) {
        super(voornaam, type, email, telefoonnr, contactID, ovkaart, idkaart);
        this.achternaam = achternaam;
        this.locatie = locatie;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }

    @Override
    public String toString() {
        return getNaam() + " " + achternaam;
    }

}
