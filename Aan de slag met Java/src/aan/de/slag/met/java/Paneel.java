package aan.de.slag.met.java;

import javax.swing.*;
import java.awt.event.*;


public class Paneel extends JPanel{
    
    //declaratie (bekendmaking namen)
    private JButton knop, HerstelKnop;
    private JTextField tekstvak, tekstvak2;
    
    
    //constructor, groepje bij elkaar horende opdrachten (Wordt aangemaakt bij nieuw object "new")
    public Paneel(){
        
        knop = new JButton ("Klik");
        knop.addActionListener(new KnopHandler());
        
        HerstelKnop = new JButton("Herstel");
        
        
        
        
        VeegUit vu = new VeegUit();
        HerstelKnop.addActionListener(vu);
       
        tekstvak = new JTextField (10);
        tekstvak2 = new JTextField (20);
       
        
        add(knop);
        add(HerstelKnop);
        add(tekstvak);
        add(tekstvak2);
        
    }
    
    //interface
    public class KnopHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            tekstvak.setText("Je hebt geklikt");
            
        }
    }
    
    //tweede interface
    public class VeegUit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
          tekstvak.setText("");
        }
        
    }
    
    
    
}
