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
public class Contact {
    private String naam;
    private String email;
    private String telefoonnr;
    private int contactID;

    public Contact(String naam, String email, String telefoonnr, int contactID) {
        this.naam = naam;
        this.email = email;
        this.telefoonnr = telefoonnr;
        this.contactID = contactID;
    }

    public String getNaam() {
        return naam;
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
    
    
}
