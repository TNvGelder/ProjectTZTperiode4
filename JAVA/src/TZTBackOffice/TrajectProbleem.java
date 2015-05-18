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
public class TrajectProbleem extends Probleem {

    private Traject bezorging;

    public TrajectProbleem(int probleemID, String titel, String beschrijving, Timestamp datum, boolean afgehandeld) {
        super(probleemID, titel, beschrijving, datum, afgehandeld);
    }
    
    public Traject getBezorging() {
        return bezorging;
    }

    public void setBezorging(Traject bezorging) {
        this.bezorging = bezorging;
    }

}
