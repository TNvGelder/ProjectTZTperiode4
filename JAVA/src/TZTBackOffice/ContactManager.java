/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.sql.SQLException;

/**
 *
 * @author Twan
 */
public class ContactManager extends Base<Contact>{

    
    public ContactManager(){
        super();
        
    }

    
    //Update het contact in de database, zodat het overeenkomt met de gegevens van Contact c.
    public void wijzigContact(Contact c){
        
    }
    
    //deze vult de arrays op met data uit de db
    @Override
    public void haalDataOp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //query
        //
    }
    
    public static void main(String[] args) throws SQLException {
        ContactManager c = new ContactManager();
    }
    
}
