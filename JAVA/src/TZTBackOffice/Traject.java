/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.sql.Timestamp;

/**
 *
 * @author Richard
 */
public class Traject {
    
    private Timestamp afhaalTijdstip;
    private Timestamp afleverTijdstip;
    private Contact koerier;
    private int trajectID;
    private Locatie beginLocatie;
    private Locatie eindLocatie;

    public Traject(int trajectID, Timestamp afhaalTijdstip, Timestamp afleverTijdstip, Contact koerier, Locatie beginLocatie, Locatie eindLocatie) {
        this.afhaalTijdstip = afhaalTijdstip;
        this.afleverTijdstip = afleverTijdstip;
        this.koerier = koerier;
        this.trajectID = trajectID;
    }

    public int getTrajectID() {
        return trajectID;
    }
    
    public Timestamp getAfhaalTijdstip() {
        return afhaalTijdstip;
    }

    public Timestamp getAfleverTijdstip() {
        return afleverTijdstip;
    }

    public Contact getKoerier() {
        return koerier;
    }

    public Locatie getBeginLocatie() {
        return beginLocatie;
    }

    public Locatie getEindLocatie() {
        return eindLocatie;
    }
    
    @Override
    public String toString() {
        return "Traject{" + "afhaalTijdstip=" + afhaalTijdstip + ", afleverTijdstip=" + afleverTijdstip + ", koerier=" + koerier + ", trajectID=" + trajectID + ", beginLocatie=" + beginLocatie + ", eindLocatie=" + eindLocatie + '}';
    }
        
}
