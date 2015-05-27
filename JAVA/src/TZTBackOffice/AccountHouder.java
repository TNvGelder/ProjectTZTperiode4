/*
 * Gemaakt door: Twan
 * Aangepast door: Jasper
 * Functie: Het aanmaken, wijzigen en verkrijgen van accounthouders
 */
package TZTBackOffice;

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
