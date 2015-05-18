/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Richard
 */
public class KoerierToevoegenDialoog extends JDialog implements ActionListener {
    
    private JLabel l1, l2, l3, l4, l5, l6;
    private JTextField tf1, tf2, tf3, tf4;
    private JButton btn1, btn2;
    private JTextArea ta1;
   
    
    public KoerierToevoegenDialoog(){
        
        setTitle("Toevoegen Professionele treinkoerier");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //---> geeft een foutmelding bij in gebruik neming
        
        
        l1 = new JLabel("Registratie formulier");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Naam:");
        l3 = new JLabel("Tel. Nummer:");
        l4 = new JLabel("E-mail adres:");
        l5 = new JLabel("Tarieven:");
        l6 = new JLabel("");
        

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        
        ta1 = new JTextArea(5, 30);

        btn1 = new JButton("Toevoegen");
        btn2 = new JButton("Voeg tekst in");
        
        event e = new event();
        btn2.addActionListener(e);
        
        btn1.addActionListener(this);
        l1.setBounds(80, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        tf1.setBounds(180, 70, 200, 30);
        tf2.setBounds(180, 110, 200, 30);
        tf3.setBounds(180, 150, 200, 30);
        
        ta1.setBounds(180, 190, 200, 30);
        
        btn1.setBounds(228, 230, 150, 20);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(tf1);
        add(tf2);
        add(tf3);
       
        add(btn1);
        add(btn2);
        
        add(ta1);

        setVisible(true);
        
    }
    
    //boolean isOk;

    KoerierToevoegenDialoog (ContactOverzichtPanel ae) {
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
   public class event implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String text = ta1.getText();
        l1.setText(text);
        
        
//        if (e.getSource() == btn1) {
//            isOk = true;
//        } else {
//            isOk = false;
//        }
//        setVisible(false);
//    }
//   }
//    public boolean getIsOk() {
//        return isOk;
    }
    

    
    
    
    
    
    
    
   }
}
