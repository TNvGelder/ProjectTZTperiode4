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
public class Bezorging {
    
    private LocalDateTime afhaalTijdstip;
    private LocalDateTime afleverTijdstip;
    private Contact koerier;
    
    
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