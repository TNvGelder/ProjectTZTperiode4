/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Twan
 */
//De <> zijn generics, hieraan kan je meegeven wat voor type object er wordt gebruikt in de klasse.
public abstract class Base<Type> {

    private ArrayList<Type> lijst = new ArrayList<>();

    public Base() {
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://karsbarendrecht.nl:3306/karsbaj97_tzt";
            String username = "karsbaj97_tzt", password = "wtj01";
            System.out.println("Maak verbinding");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("connectie gemaakt");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM stakeholder");
            System.out.println("query uitgevoerd");
            while (rs.next()) {
                int id = rs.getInt(1); 	         // 1e kolom
                String naam = rs.getString("naam");  // kolom ‘Naam’
                String ww = rs.getString(3); 	   // 3e kolom

                System.out.println(id + " " + naam + " " + ww);
            }

            statement.close(); 
            connection.close();
            
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void voegToe(Type obj) {
        lijst.add(obj);
    }

    //Deze methode moet de objecten uit de database halen en moet de lijst vullen.
    public abstract void haalDataOp();

}
