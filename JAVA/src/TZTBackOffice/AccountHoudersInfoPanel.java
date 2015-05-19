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
 * @author Richard
 */
public class AccountHoudersInfoPanel extends JPanel {
    
    public AccountHoudersInfoPanel(AccountHouder accountHouder){
    
        
        add(new JButton(accountHouder.getNaam()));
        Locatie locatie = accountHouder.getLocatie();
        
    
    
    
    }
    
}
