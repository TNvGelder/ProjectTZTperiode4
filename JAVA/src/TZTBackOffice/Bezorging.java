/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.time.LocalDate;

/**
 *
 * @author Richard
 */
public class Bezorging {
    
    private LocalDate afhaalTijdstip;
    private LocalDate afleverTijdstip;
    private Contact koerier;
    
    
    public LocalDate getAfhaalTijdstip() {
        return afhaalTijdstip;
    }

    public LocalDate getAfleverTijdstip() {
        return afleverTijdstip;
    }

    public Contact getKoerier() {
        return koerier;
    }
    
        
}
