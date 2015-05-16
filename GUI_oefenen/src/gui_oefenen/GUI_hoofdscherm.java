package gui_oefenen;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JDialog;

/**
 *
 * @author Richard
 */
public class GUI_hoofdscherm extends JFrame implements ActionListener {

    private JButton jb1;

    public GUI_hoofdscherm() {
        
        setTitle("Hoofdscherm");
        setSize(400, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jb1 = new JButton("Toevoegen");
        jb1.addActionListener(this);
        jb1.setBounds(100, 50, 200, 30);
        add(jb1);
       
        setVisible (true);
    }
    
    public static void main(String[] args) {
        GUI_hoofdscherm gh = new GUI_hoofdscherm();
        gh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        // code voor afhandeling knop

        GUI_dialoog dialoog = new GUI_dialoog();
        dialoog.setVisible(true);

    }

    
}
