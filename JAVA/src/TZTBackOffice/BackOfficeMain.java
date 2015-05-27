/*
 * Gemaakt door: Twan
 * Aangepast door: -
 * Functie: Aanmaken van het HoofdScherm in Main
 */
package TZTBackOffice;

import javax.swing.JFrame;

/**
 *
 * @author Twan
 */
public class BackOfficeMain {

    public static void main(String[] args) {
        //Maak hoofdscherm aan
        HoofdScherm hoofdScherm = new HoofdScherm();
        hoofdScherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
