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

//De <> zijn generics, hieraan kan je meegeven wat voor type object er wordt gebruikt in de klasse.
public abstract class Base<Type> {
    
    private ArrayList<Type> lijst = new ArrayList<>();
    
    public Base(){
        
    }
    
    public void voegToe(Type obj){
        lijst.add(obj);
    }
    
    //Deze methode moet de objecten uit de database halen en moet de lijst vullen.
    public abstract void haalDataOp();
    
}
