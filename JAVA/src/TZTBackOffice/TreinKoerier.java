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
public class TreinKoerier extends AccountHouder{
    
    private double krediet;
    private int rekeningnr;
    private String idKaart;
    private String ovKaart;

    public TreinKoerier(double krediet, int rekeningnr, String idKaart, String ovKaart, String voornaam, String email, String telefoonnr, int contactID, String achternaam, String huisnr, String plaats, String postcode, String wachtwoord, String straat) {
        super(voornaam, email, telefoonnr, contactID, achternaam, huisnr, plaats, postcode, wachtwoord, straat);
        this.krediet = krediet;
        this.rekeningnr = rekeningnr;
        this.idKaart = idKaart;
        this.ovKaart = ovKaart;
    }

    public double getKrediet() {
        return krediet;
    }

    public int getRekeningnr() {
        return rekeningnr;
    }

    public String getIdKaart() {
        return idKaart;
    }

    public String getOvKaart() {
        return ovKaart;
    }
    
    
}
