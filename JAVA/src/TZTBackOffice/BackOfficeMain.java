/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import javax.swing.JFrame;

/**
 *
 * @author Twan
 */
public class BackOfficeMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();
        
        
        HoofdScherm hoofdScherm = new HoofdScherm(); 
        hoofdScherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
