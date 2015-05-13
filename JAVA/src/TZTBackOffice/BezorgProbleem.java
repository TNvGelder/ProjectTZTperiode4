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
public class BezorgProbleem extends Probleem {

    private Bezorging bezorging;

    public BezorgProbleem(Bezorging bezorging, String titel, String beschrijving, LocalDateTime datum) {
        super(titel, beschrijving, datum);
        this.bezorging = bezorging;
    }

    public Bezorging getBezorging() {
        return bezorging;
    }

}
