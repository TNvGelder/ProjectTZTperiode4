/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.util.ArrayList;

/**
 *
 * @author Twan
 */
public class Pakket {
    private int pakketID;
    private double gewicht;
    private String formaat;
    private VerzendOrder order;
    private String opmerking;
    private String status;
    private ArrayList<Traject> trajecten;

    public Pakket(int pakketID, double gewicht, String formaat, VerzendOrder order, String opmerking, String status) {
        this.pakketID = pakketID;
        this.gewicht = gewicht;
        this.formaat = formaat;
        this.order = order;
        this.opmerking = opmerking;
        this.status = status;
        trajecten = new ArrayList();
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

    public String getOpmerking() {
        return opmerking;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Traject> getTrajecten() {
        return trajecten;
    }
    
    public void voegTrajectToe(Traject traject){
        trajecten.add(traject);
    }

    @Override
    public String toString() {
        return "Pakket{" + "pakketID=" + pakketID + ", gewicht=" + gewicht + ", formaat=" + formaat + ", order=" + order + ", opmerking=" + opmerking + ", status=" + status + '}';
    }
    
    
    
    
    
}
