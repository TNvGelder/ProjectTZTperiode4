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
    private String rekeningnr;

    public AccountHouder(String voornaam, String type, String email, String telefoonnr, int contactID, String achternaam, Locatie locatie, String ovkaart, String idkaart, String rekeningnr) {
        super(voornaam, type, email, telefoonnr, contactID, ovkaart, idkaart);
        this.achternaam = achternaam;
        this.locatie = locatie;
        this.rekeningnr = rekeningnr;
        this.idkaart = idkaart;
        this.ovkaart = ovkaart;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public String getOvkaart() {
        return ovkaart;
    }

    public String getIdkaart() {
        return idkaart;
    }

    public String getRekeningnr() {
        return rekeningnr;
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
