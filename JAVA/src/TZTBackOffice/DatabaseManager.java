/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Twan
 */
public class DatabaseManager {

    private ContactManager contactManager;
    private PakketManager pakketManager;
    private UitbetalingsManager uitbetalingsManager;
    private ProbleemManager probleemManager;
    private ArrayList<HashMap> contacten;
    private ArrayList<HashMap> pakketten;
    private ArrayList<HashMap> problemen;
    private ArrayList<HashMap> uitbetalingen;
    private HashMap<Integer, Contact> koeriersDiensten;
    private HashMap<Integer, Locatie> locaties;
    private String url;
    private String username, password;

    private Statement statement;
    private Connection connection;
    // Aangemeld, verzonden, gearriveerd

    public DatabaseManager() {
        url = "jdbc:mysql://karsbarendrecht.nl:3306/karsbaj97_tzt";
        username = "karsbaj97_tzt";
        password = "wtj01";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        contactManager = new ContactManager();
        pakketManager = new PakketManager();
        uitbetalingsManager = new UitbetalingsManager();
        probleemManager = new ProbleemManager();
        pakketten = new ArrayList();
        haalDataOp();

    }

    public Contact getKoeriersDienst(int id){
        return koeriersDiensten.get(id);
    }
    
    //Haalt pakketten op uit de database en vult de array pakket objecten;
    private void haalDataOp() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM locatie");
            while (rs.next()) {
                int id = rs.getInt(1); 	         // 1e kolom
                String klantID = rs.getString(2);  // kolom ‘Naam’
                String ww = rs.getString(3); 	   // 3e kolom
                

                System.out.println(id + " " + klantID + " " + ww);
            }
            
            rs = statement.executeQuery("SELECT * FROM verzendorder");
            while (rs.next()) {
                int id = rs.getInt(1); 	         // 1e kolom
                int klantID = rs.getInt(2);  // kolom ‘Naam’
                String ww = rs.getString(3); 	   // 3e kolom
                

                System.out.println(id + " " + klantID + " " + ww);
            }
            
            
            rs = statement.executeQuery("SELECT pakketID, gewicht, formaat, opmerking, kosten, orderID FROM pakket");
            while (rs.next()) {
                int id = rs.getInt(1); 	         // 1e kolom
                String naam = rs.getString("opmerking");  // kolom ‘Naam’
                String ww = rs.getString(3); 	   // 3e kolom

                System.out.println(id + " " + naam + " " + ww);
            }

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void haalContactenOp() {

    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
