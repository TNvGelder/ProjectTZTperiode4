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
public class KoeriersDienst extends Contact {

    private ArrayList<Tarief> tarieven;

    public KoeriersDienst(String naam, String type, String email, String telefoonnr, int contactID) {
        super(naam, type, email, telefoonnr, contactID, null, null);
        tarieven = new ArrayList();
    }

    public void voegTariefToe(Tarief tarief) {
        tarieven.add(tarief);
    }

    public ArrayList<Tarief> getTarieven() {
        return tarieven;
    }

}
