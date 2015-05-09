/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

/**
 *
 * @author Twan
 */
public class ContactBase extends Base<Contact>{

    
    public ContactBase(){
        super();
        
    }
    
    //Update het contact in de database, zodat het overeenkomt met de gegevens van Contact c.
    public void wijzigContact(Contact c){
        
    }
    
    @Override
    public void haalDataOp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
