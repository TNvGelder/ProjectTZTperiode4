package TZTBackOffice;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Create a simple GUI window
public class KlachtenScherm extends JFrame {

    JTextArea textarea;
    JButton button;
    JLabel label;
    
    private JLabel labelHead, labelNaam, labelID, labelDatum;
    private JButton btnReageer;
    private JTextArea textOmschrijving;
    //private JScrollPane scrollpane;

    public KlachtenScherm() {
       
        setTitle("Klachten");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //---> geeft een foutmelding bij in gebruik neming
        
        
        labelHead = new JLabel("Laat");
        labelHead.setForeground(Color.blue);
        labelHead.setFont(new Font("Serif", Font.BOLD, 30));
        labelNaam = new JLabel("Naam: Rob");
        labelNaam.setFont(new Font("Serif", Font.BOLD, 18));
        labelID = new JLabel ("ProbleemID: 214");
        labelID.setFont (new Font ("Serif", Font.BOLD, 15));
        labelDatum = new JLabel ("Datum: 18/05/2015");
        labelDatum.setFont (new Font ("Serif", Font.BOLD, 15));
        
        //JScrollPane scrollPane = new JScrollPane(textOmschrijving);
        
        textOmschrijving = new JTextArea("Hier komt de omschrijving van de klacht");
        btnReageer = new JButton("Reageer");

        labelHead.setBounds(80, 30, 400, 30);
        labelNaam.setBounds(80, 70, 200, 30);
        labelID.setBounds (420, 30, 200, 30);
        labelDatum.setBounds (420, 70, 200, 30);
        textOmschrijving.setBounds(80, 120, 500, 300);
        btnReageer.setBounds(80, 425, 90, 20);
        

        add(labelHead);
        add(labelNaam);
        add(labelID);
        add(labelDatum);
        add(btnReageer);
        //add (scrollPane);
        add(textOmschrijving);
        
        event e = new event();
        btnReageer.addActionListener(e);

        //setVisible(true);
        
    }
      
    
    public class event implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String text = textOmschrijving.getText();
        if ("".equals(text)){
            textOmschrijving.setText("Vul wat in!");
        } else
        //textOmschrijving.setText(text);
            
        dispose();//tijdelijk
    }
    }
    
      public static void main(String[] args) {
        KlachtenScherm gui = new KlachtenScherm();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(800, 500);
        gui.setVisible(true);
    }
}
