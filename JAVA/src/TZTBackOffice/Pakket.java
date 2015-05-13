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
public class Pakket {
    private int pakketID;
    private double gewicht;
    private String formaat;
    private VerzendOrder order;

    public Pakket(int pakketID, double gewicht, String formaat, VerzendOrder order) {
        this.pakketID = pakketID;
        this.gewicht = gewicht;
        this.formaat = formaat;
        this.order = order;
    }
    
        
    @Override
    public String toString(){
        return "Pakket";
    }

    public int getPakketID() {
        return pakketID;
    }

    public double getGewicht() {
        return gewicht;
    }

    public String getFormaat() {
        return formaat;
    }

    public VerzendOrder getOrder() {
        return order;
    }
    
    
    
    
}
