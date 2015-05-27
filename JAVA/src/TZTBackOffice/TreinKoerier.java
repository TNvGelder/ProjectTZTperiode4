/*
 * Gemaakt door: Twan
 * Aangepast door: Jasper
 * Functie: Het verkrijgen en wijzigen van treinkoerier gegevens
 */
package TZTBackOffice;

public class TreinKoerier extends AccountHouder {

    private double krediet;
    private String rekeningnr;

    public TreinKoerier(double krediet, String rekeningnr, String voornaam, String type, String email, String telefoonnr, int contactID, String achternaam, Locatie locatie) {
        super(voornaam, type, email, telefoonnr, contactID, achternaam, locatie, null, null);
        this.krediet = krediet;
        this.rekeningnr = rekeningnr;
    }

    public double getKrediet() {
        return krediet;
    }

    public String getRekeningnr() {
        return rekeningnr;
    }

    public void setKrediet(double krediet) {
        this.krediet = krediet;
    }

    public void setRekeningnr(String rekeningnr) {
        this.rekeningnr = rekeningnr;
    }
}
