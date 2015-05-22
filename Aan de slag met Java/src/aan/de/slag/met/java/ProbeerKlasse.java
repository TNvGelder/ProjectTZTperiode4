package aan.de.slag.met.java;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ProbeerKlasse extends JFrame {

  //dit is de methode main()
    public static void main(String[] args) { //body begint
        
        //aangemaakt object 'frame'
        JFrame frame = new JFrame();
        
        //scherm instellingen
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Mijn zelfgemaakte applicatie");
        JPanel paneel = new Paneel();
        frame.setContentPane(paneel);
        frame.setVisible(true);
    
    } //body eindigt
    
}
