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
class Locatie {

    private int locatieID;
    private String straat;
    private String huisnummer;
    private String plaats;
    private String postcode;

    public Locatie(int locatieID, String straat, String huisnummer, String plaats, String postcode) {
        this.locatieID = locatieID;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.plaats = plaats;
        this.postcode = postcode;
    }

    public int getLocatieID() {
        return locatieID;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public String getPlaats() {
        return plaats;
    }

    public String getPostcode() {
        return postcode;
    }

    @Override
    public String toString() {
        return straat + " " + huisnummer;
    }

    public void setLocatieID(int locatieID) {
        this.locatieID = locatieID;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

}
