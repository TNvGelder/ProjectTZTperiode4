/*
 * Gemaakt door: Twan
 * Aangepast door: -
 * Functie: Het aanmaken, wijzigen en verkrijgen van pakket gegevens
 */
package TZTBackOffice;

import java.util.ArrayList;

public class Pakket {

    private int pakketID;
    private double gewicht;
    private String formaat;
    private VerzendOrder order;
    private String opmerking;
    private String status;
    private ArrayList<Traject> trajecten;
    private boolean gesorteerd;

    public Pakket(int pakketID, double gewicht, String formaat, VerzendOrder order, String opmerking, String status) {
        this.pakketID = pakketID;
        this.gewicht = gewicht;
        this.formaat = formaat;
        this.order = order;
        this.opmerking = opmerking;
        this.status = status;
        this.gesorteerd = false;
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

    //deze functie is hier omdat jasper m nog gebruikt
    public Boolean getDefinitief() {
        return true;
    }

    public ArrayList<Traject> getTrajecten() {
        if (!gesorteerd) {
            sorteerTrajecten();
        }
        return trajecten;
    }

    public void setTrajecten(ArrayList<Traject> trajecten) {

        this.trajecten = trajecten;
    }

    //Sorteert de traject array zodat het van begin naar eindlocatie gesorteerd is.
    public void sorteerTrajecten() {
        ArrayList<Traject> gesorteerdeTrajectArray = new ArrayList();
        Locatie beginLocatie = order.getBeginLocatie();
        while (beginLocatie != null) {
            Traject volgendeTraject = null;
            for (int i = 0; i < trajecten.size(); i++) {
                Traject traject = trajecten.get(i);
                if (traject.getBeginLocatie().getLocatieID() == beginLocatie.getLocatieID()) {
                    trajecten.remove(i);
                    volgendeTraject = traject;
                }
            }
            if (volgendeTraject != null) {
                beginLocatie = volgendeTraject.getEindLocatie();
                gesorteerdeTrajectArray.add(volgendeTraject);
            } else {
                beginLocatie = null;
            }
        }
        setTrajecten(gesorteerdeTrajectArray);
    }

    public void voegTrajectToe(Traject traject) {
        trajecten.add(traject);
    }

    @Override
    public String toString() {
        return "Pakket{" + "pakketID=" + pakketID + ", gewicht=" + gewicht + ", formaat=" + formaat + ", order=" + order + ", opmerking=" + opmerking + ", status=" + status + '}';
    }

}
