/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.sql.Timestamp;
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
    private HashMap<Integer, AccountHouder> accountHouders;
    private HashMap<Integer, Locatie> locaties;
    private String url;
    private String username, password;

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
        accountHouders = new HashMap();
        locaties = new HashMap();
        haalDataOp();

    }

    public Contact getKoeriersDienst(int id) {
        return koeriersDiensten.get(id);
    }

    public AccountHouder getAccountHouder(int id) {
        return accountHouders.get(id);
    }

    //Haalt pakketten op uit de database en vult de array pakket objecten;
    private void haalDataOp() {
        Connection connection = null;
        Statement statement;
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT locatienr, straat, huisnummer, plaats, postcode FROM locatie");
            while (rs.next()) {
                int id = rs.getInt(1); 	         // 1e kolom
                String straat = rs.getString(2);  // kolom ‘Naam’
                String huisnummer = rs.getString(3); 	   // 3e kolom
                String plaats = rs.getString(4);
                String postcode = rs.getString(5);
                Locatie locatie = new Locatie(id, straat, huisnummer, plaats, postcode);
                locaties.put(id, locatie);
                System.out.println(locatie);
            }

            rs = statement.executeQuery("SELECT stakeholderID, (SELECT typenaam FROM stakeholdertype ty WHERE ty.typeID = s.type) typenaam ,naam, achternaam, emailadres, telefoonnr, idkaart, ovkaart, krediet\n"
                    + ", filiaalnr, locatie, rekeningnr, o.orderID, aanmeldtijd, pakketID, p.probleemID, beschrijving, p.datum, titel, p.afgehandeld\n"
                    + ", k.datum, bedrag, k.isafgehandeld, k.type, beginlocatie, eindlocatie, km, prijs, extraprijs   FROM stakeholder s\n"
                    + "LEFT OUTER JOIN tarief t ON stakeholderID = koeriersID\n"
                    + "LEFT OUTER JOIN probleem p ON stakeholderID = klantnr\n"
                    + "LEFT OUTER JOIN verzendorder o ON stakeholderID = klantID\n"
                    + "LEFT OUTER JOIN kredietomzetting k ON stakeholderID = treinkoerier\n"
                    + "LEFT OUTER JOIN reis v ON stakeholderID = v.koerier \n"
                    + "LEFT OUTER JOIN pakket pa ON o.orderID = pa.orderID ORDER BY stakeholderID DESC, p.probleemID DESC, pakketID DESC;");
            while (rs.next()) {
                int id = rs.getInt(1); 	         // 1e kolom
                String naam = rs.getString("naam");  // kolom ‘Naam’
                String achternaam = rs.getString("achternaam"); 	   // 3e kolom
                String email = rs.getString("emailadres");
                String telefoonnr = rs.getString("telefoonnr");
                String idkaart = rs.getString("idkaart");
                String ovkaart = rs.getString("ovkaart");
                Double krediet = rs.getDouble("krediet");
                int filiaalnr = rs.getInt("filiaalnr");
                int locatie = rs.getInt("locatie");
                String rekeningnr = rs.getString("rekeningnr");

                System.out.println(id + " " + naam + " " + achternaam + " " + email + " " + telefoonnr);
            }

            rs = statement.executeQuery("SELECT * FROM verzendorder");
            while (rs.next()) {
                int id = rs.getInt(1); 	         // 1e kolom
                int klantID = rs.getInt(2);  // kolom ‘Naam’
                Timestamp aanmeldTijd = rs.getTimestamp(3); 	   // 3e kolom
                AccountHouder klant = getAccountHouder(id);
                if (klant != null) {

                }
                Statement statement2 = connection.createStatement();
                ResultSet rs2;

                System.out.println(id + " " + klantID + " " + aanmeldTijd);
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

}
