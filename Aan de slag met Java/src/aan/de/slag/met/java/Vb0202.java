
package aan.de.slag.met.java;

import javax.swing.*;
import java.awt.event.*;


public class Vb0202 extends JPanel {
    
//dit is de methode main()
    public static void main(String[] args) { //body begint
        
        //aangemaakt object 'frame'
        JFrame frame = new JFrame();
        
        //scherm instellingen
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Mijn zelfgemaakte applicatie");
        JPanel paneel = new Paneel();//de constructor van de klasse Paneel word aangeroepen
        frame.setContentPane(paneel);
        frame.setVisible(true);
    
    } //body eindigt
    
    

    
    
    
}
