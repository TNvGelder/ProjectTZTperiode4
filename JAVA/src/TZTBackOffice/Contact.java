/*
 * Gemaakt door: Twan
 * Aangepast door: Jasper
 * Functie: Het aanmaken, wijzigen en verkrijgen van contact gegevens
 */
package TZTBackOffice;

public class Contact {

    private String naam;
    private String email;
    private String telefoonnr;
    private String type;
    private int contactID;

    public Contact(String naam, String type, String email, String telefoonnr, int contactID) {
        this.naam = naam;
        this.email = email;
        this.telefoonnr = telefoonnr;
        this.contactID = contactID;
        this.type = type;
    }

    public String getNaam() {
        return naam;
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefoonnr() {
        return telefoonnr;
    }

    public int getContactID() {
        return contactID;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefoonnr(String telefoonnr) {
        this.telefoonnr = telefoonnr;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    @Override
    public String toString() {
        return naam;
    }

}
