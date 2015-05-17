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

    private HashMap<Integer, Locatie> locaties;
    private String url;
    private String username, password;
    private HashMap<Integer, Contact> contacten;
    private HashMap<Integer, Probleem> problemen;
    private ArrayList<KoeriersDienst> koeriersDiensten;
    private ArrayList<TreinKoerier> treinKoeriers;
    private ArrayList<AccountHouder> accountHouders;
    private ArrayList<UitbetalingsVerzoek> uitbetalingsVerzoeken;
    private ArrayList<BezorgProbleem> bezorgProblemen;
    private ArrayList<Klacht> klachten;
    private ArrayList<Pakket> pakketten;

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

        pakketten = new ArrayList();
        treinKoeriers = new ArrayList();
        accountHouders = new ArrayList();
        koeriersDiensten = new ArrayList();
        contacten = new HashMap();
        locaties = new HashMap();
        haalDataOp();

    }

    public ArrayList<KoeriersDienst> getKoeriersDiensten() {
        return koeriersDiensten;
    }

    public ArrayList<TreinKoerier> getTreinKoeriers() {
        return treinKoeriers;
    }

    public ArrayList<AccountHouder> getAccountHouders() {
        return accountHouders;
    }

    public ArrayList<UitbetalingsVerzoek> getUitbetalingsVerzoeken() {
        return uitbetalingsVerzoeken;
    }

    public ArrayList<BezorgProbleem> getBezorgProblemen() {
        return bezorgProblemen;
    }

    public ArrayList<Klacht> getKlachten() {
        return klachten;
    }

    public ArrayList<Pakket> getPakketten() {
        return pakketten;
    }

    private void maakUitbetalingsVerzoek(TreinKoerier koerier, ResultSet r) {

    }

    private void maakPakket(VerzendOrder order, ResultSet r) throws SQLException {
        int pakketID = r.getInt("p.pakketID");
        Double gewicht = r.getDouble("gewicht");
        String formaat = r.getString("formaat");
        String opmerking = r.getString("opmerking");
        String status = r.getString("status");
        Pakket pakket = new Pakket(pakketID, gewicht, formaat, order, opmerking, status);
        pakketten.add(pakket);
        System.out.println(pakket);
    }

    public void maakTarief(KoeriersDienst koeriersDienst, ResultSet rs) throws SQLException {
        int km = rs.getInt("km");
        Double prijs = rs.getDouble("prijs");
        Double extraPrijs = rs.getDouble("extraPrijs");
        Tarief tarief = new Tarief(koeriersDienst, km, prijs, extraPrijs);
        koeriersDienst.voegTariefToe(tarief);
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
                    + ", locatie, rekeningnr,  km, prijs, extraprijs   FROM stakeholder s\n"
                    + "LEFT OUTER JOIN tarief t ON stakeholderID = koeriersID\n"
                    + "ORDER BY stakeholderID DESC;");

            int contactID = 0;
            while (rs.next()) {
                int newContactID = rs.getInt(1);
                String typenaam = rs.getString("typenaam");
                if (newContactID != contactID) {
                    Contact contact;
                    contactID = newContactID;
                    String naam = rs.getString("naam");
                    String email = rs.getString("emailadres");
                    String telefoonnr = rs.getString("telefoonnr");
                    if ("gebruiker".equals(typenaam) || "geverifieerd".equals(typenaam)) {
                        String achternaam = rs.getString("achternaam");
                        Locatie locatie = locaties.get(rs.getInt("locatie"));
                        AccountHouder klant;
                        if ("geverifieerd".equals(typenaam)) {
                            String ovkaart = rs.getString("ovkaart");
                            Double krediet = rs.getDouble("krediet");
                            String idkaart = rs.getString("idkaart");
                            String rekeningnr = rs.getString("rekeningnr");
                            TreinKoerier koerier = new TreinKoerier(krediet, rekeningnr, idkaart, ovkaart, naam, typenaam, email, telefoonnr, contactID, achternaam, locatie);
                            treinKoeriers.add(koerier);
                            accountHouders.add(koerier);
                            klant = koerier;
                            System.out.println(typenaam + " " + koerier);
                        } else {
                            klant = new AccountHouder(naam, typenaam, email, telefoonnr, contactID, achternaam, locatie);
                            accountHouders.add(klant);
                            System.out.println(typenaam + " " + klant);
                        }
                        contact = klant;

                    } else {
                        KoeriersDienst koeriersDienst = new KoeriersDienst(naam, typenaam, email, telefoonnr, contactID);
                        koeriersDiensten.add(koeriersDienst);
                        maakTarief(koeriersDienst, rs);
                        System.out.println(typenaam + " " + koeriersDienst);
                        contact = koeriersDienst;
                    }
                    contacten.put(contact.getContactID(), contact);
                } else if (!"gebruiker".equals(typenaam) || "geverifieerd".equals(typenaam)) {
                    KoeriersDienst koeriersDienst = koeriersDiensten.get(koeriersDiensten.size() - 1);
                    maakTarief(koeriersDienst, rs);
                }

            }

            
            
            rs = statement.executeQuery("SELECT v.orderID, v.klantID, definitief, aanmeldtijd, pakketID, gewicht, formaat, opmerking, status FROM verzendorder v\n"
                    + "JOIN pakket p ON v.orderID = p.orderID ORDER BY pakketID DESC;");
            while (rs.next()) {
                int orderID = rs.getInt("v.orderID");
                boolean definitief = rs.getBoolean("definitief");
                //Check of er een definitieve order is die nog niet is toegevoegd.
                if (definitief) {
                    if (pakketten.isEmpty() || (orderID == pakketten.get(pakketten.size() - 1).getOrder().getOrderID())) {
                        int klantID = rs.getInt("v.klantID");
                        AccountHouder klant = (AccountHouder) contacten.get(klantID);
                        Timestamp aanmeldTijd = rs.getTimestamp("aanmeldtijd");
                        VerzendOrder order = new VerzendOrder(orderID, klant, aanmeldTijd);
                        maakPakket(order, rs);
                    } else {
                        VerzendOrder order = pakketten.get(pakketten.size() - 1).getOrder();
                        maakPakket(order, rs);
                    }
                }
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
