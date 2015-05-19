/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Twan
 */
public class TreinKoeriersInfoPanel extends JPanel{
    
    public TreinKoeriersInfoPanel( TreinKoerier treinKoerier){
        
        add(new JButton(treinKoerier.getNaam()));
    }
}
