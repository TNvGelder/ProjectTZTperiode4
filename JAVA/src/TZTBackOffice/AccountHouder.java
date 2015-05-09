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
    private String huisnr;
    private String plaats;
    private String postcode;
    private String wachtwoord;
    private String straat;

    public AccountHouder(String voornaam, String email, String telefoonnr, int contactID, String achternaam, String huisnr, String plaats, String postcode, String wachtwoord, String straat) {
        super(voornaam, email, telefoonnr, contactID);
        this.achternaam = achternaam;
        this.huisnr = huisnr;
        this.plaats = plaats;
        this.postcode = postcode;
        this.wachtwoord = wachtwoord;
        this.straat = straat;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getHuisnr() {
        return huisnr;
    }

    public String getPlaats() {
        return plaats;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public String getStraat() {
        return straat;
    }
    
    
    
}
