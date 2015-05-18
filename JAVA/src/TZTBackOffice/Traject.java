/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.time.LocalDateTime;

/**
 *
 * @author Richard
 */
public class Traject {
    
    private LocalDateTime afhaalTijdstip;
    private LocalDateTime afleverTijdstip;
    private Contact koerier;
    private int trajectID;

    public Traject(int trajectID, LocalDateTime afhaalTijdstip, LocalDateTime afleverTijdstip, Contact koerier) {
        this.afhaalTijdstip = afhaalTijdstip;
        this.afleverTijdstip = afleverTijdstip;
        this.koerier = koerier;
        this.trajectID = trajectID;
    }

    public int getTrajectID() {
        return trajectID;
    }
    
    public LocalDateTime getAfhaalTijdstip() {
        return afhaalTijdstip;
    }

    public LocalDateTime getAfleverTijdstip() {
        return afleverTijdstip;
    }

    public Contact getKoerier() {
        return koerier;
    }
    
        
}
