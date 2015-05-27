/*
 * Gemaakt door: Twan
 * Aangepast door: -
 * Functie: Het aanmaken, wijzigen en verkrijgen van koeriersdienst gegevens
 */
package TZTBackOffice;

import java.util.ArrayList;

public class KoeriersDienst extends Contact {

    private ArrayList<Tarief> tarieven;

    public KoeriersDienst(String naam, String type, String email, String telefoonnr, int contactID) {
        super(naam, type, email, telefoonnr, contactID);
        tarieven = new ArrayList();
    }

    public void voegTariefToe(Tarief tarief) {
        tarieven.add(tarief);
    }

    public ArrayList<Tarief> getTarieven() {
        return tarieven;
    }

}
