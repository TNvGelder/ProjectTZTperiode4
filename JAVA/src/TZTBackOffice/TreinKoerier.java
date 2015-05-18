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
    private String rekeningnr;
    private String idKaart;
    private String ovKaart;

    public TreinKoerier(double krediet, String rekeningnr, String idKaart, String ovKaart, String voornaam, String type, String email, String telefoonnr, int contactID, String achternaam, Locatie locatie) {
        super(voornaam, type, email, telefoonnr, contactID, achternaam, locatie);
        this.krediet = krediet;
        this.rekeningnr = rekeningnr;
        this.idKaart = idKaart;
        this.ovKaart = ovKaart;
    }

    public double getKrediet() {
        return krediet;
    }

    public String getRekeningnr() {
        return rekeningnr;
    }

    public String getIdKaart() {
        return idKaart;
    }

    public String getOvKaart() {
        return ovKaart;
    }

    @Override
    public String toString() {
        return "TreinKoerier{" + super.toString()  + "krediet=" + krediet + ", rekeningnr=" + rekeningnr + ", idKaart=" + idKaart + ", ovKaart=" + ovKaart + '}';
    }
    
    
}
