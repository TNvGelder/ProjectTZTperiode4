/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
    private ArrayList<UitbetalingsVerzoek> afgehandeldeVerzoeken;
    private ArrayList<UitbetalingsVerzoek> nietAfgehandeldeVerzoeken;
    private ArrayList<TrajectProbleem> bezorgProblemen;
    private ArrayList<KlachtInfoPanel> klachten;
    private ArrayList<Pakket> pakketten;

    private Traject vorigTraject;

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

    public ArrayList<UitbetalingsVerzoek> getAfgehandeldeUitbetalingsVerzoeken() {
        return afgehandeldeVerzoeken;
    }

    public ArrayList<UitbetalingsVerzoek> getNietAfgehandeldeVerzoeken() {
        return nietAfgehandeldeVerzoeken;
    }

    public ArrayList<TrajectProbleem> getBezorgProblemen() {
        return bezorgProblemen;
    }

    public ArrayList<KlachtInfoPanel> getKlachten() {
        return klachten;
    }

    public ArrayList<Pakket> getPakketten() {
        System.out.println(pakketten);
        return pakketten;
    }

    public void voegKoeriersdienstToe(Contact contact1) {

        Connection connection = null;
        Statement statement;
        //Probeer de statement uit te voeren
        try {
            //Maak connectie met DB
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            //Insert statement maken
            String query = " INSERT INTO stakeholder (stakeholderID, type, naam, achternaam, emailadres, telefoonnr, idkaart, ovkaart, krediet, wachtwoord, locatie, snelheid, rekeningnr)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //Preparedstatement maken
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.setNull(1, java.sql.Types.INTEGER);
            preparedStmt.setInt(2, 4);
            preparedStmt.setString(3, contact1.getNaam());
            preparedStmt.setNull(4, java.sql.Types.VARCHAR);
            preparedStmt.setString(5, contact1.getEmail());
            preparedStmt.setString(6, contact1.getTelefoonnr());
            preparedStmt.setNull(7, java.sql.Types.VARCHAR);
            preparedStmt.setNull(8, java.sql.Types.VARCHAR);
            preparedStmt.setNull(9, java.sql.Types.DOUBLE);
            preparedStmt.setNull(10, java.sql.Types.VARCHAR);
            preparedStmt.setNull(11, java.sql.Types.INTEGER);
            preparedStmt.setNull(12, java.sql.Types.DOUBLE);
            preparedStmt.setNull(13, java.sql.Types.VARCHAR);

            //Voer preparedstatement uit
            preparedStmt.execute();
            System.out.println("koerier aangemaakt");

            //Sluit connectie
            connection.close();
        } catch (Exception e) {
            //Als de connectie of statement een error opleverd
            System.out.println("Er is iets misgegaan met de functie voegKoeriersdienstToe");
            System.out.println(e);
        }
    }

    private void maakTraject(Pakket p, ResultSet r) throws SQLException {
        //t.trajectID, afhaaltijd, aflevertijd, r.beginlocatie, r.eindlocatie, r.koerierID, pr1.probleemID, pr2.probleemID
        int trajectID = r.getInt("t.trajectID");
        if (trajectID != 0) {
            int koerierID = r.getInt("r.koerierID");
            if (vorigTraject == null || vorigTraject.getTrajectID() != trajectID) {
                Timestamp afhaaltijd = r.getTimestamp("afhaaltijd");
                Timestamp aflevertijd = r.getTimestamp("aflevertijd");
                Locatie beginLocatie = locaties.get(r.getInt("beginlocatie"));
                Locatie eindLocatie = locaties.get(r.getInt("eindlocatie"));
                Contact koerier = contacten.get(r.getInt("r.koerierID"));
                vorigTraject = new Traject(trajectID, afhaaltijd, aflevertijd, koerier, beginLocatie, eindLocatie);
                p.voegTrajectToe(vorigTraject);
                System.out.println(vorigTraject);
            }
            int probleemID = r.getInt("pr1.probleemID");
            if (probleemID != 0) {
                TrajectProbleem trajectProbleem = (TrajectProbleem) problemen.get(probleemID);
                trajectProbleem.setBezorging(vorigTraject);
            }
        }

    }

    private void maakPakket(VerzendOrder order, ResultSet r) throws SQLException {

        int pakketID = r.getInt("p.pakketID");
        System.out.println("Pakket ID : " + pakketID);
        Pakket pakket;
        if (pakketten.isEmpty() || pakketten.get(pakketten.size() - 1).getPakketID() != pakketID) {
            Double gewicht = r.getDouble("gewicht");
            String formaat = r.getString("formaat");
            String opmerking = r.getString("opmerking");
            String status = r.getString("status");
            pakket = new Pakket(pakketID, gewicht, formaat, order, opmerking, status);
            pakketten.add(pakket);
            maakTraject(pakket, r);
            System.out.println(pakket);
        } else {
            pakket = pakketten.get(pakketten.size() - 1);
            maakTraject(pakket, r);
        }
        ArrayList<Traject> trajecten = pakket.getTrajecten();
        ArrayList<Traject> gesorteerdeTrajectArray = new ArrayList();
        Locatie beginLocatie = order.getBeginLocatie();
        while (beginLocatie != null){
            Traject volgendeTraject = null;
            for (int i = 0; i< trajecten.size(); i++) {
                Traject traject = trajecten.get(i);
                if (traject.getBeginLocatie().getLocatieID() == beginLocatie.getLocatieID()){
                    trajecten.remove(i);
                    volgendeTraject = traject;
                }
            }
            if (volgendeTraject != null){
                beginLocatie = volgendeTraject.getEindLocatie();
                gesorteerdeTrajectArray.add(vorigTraject);
            } else{
                beginLocatie = null;
            }
        }
        pakket.setTrajecten(gesorteerdeTrajectArray);
        
//        int probleemID = r.getInt("pr2.probleemID");
//        if (probleemID != 0) {
//            KlachtInfoPanel klacht = (KlachtInfoPanel) problemen.get(r.getInt(probleemID));
//            klacht.setPakket(pakket);
//        }
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
        vorigTraject = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT locatienr, straat, huisnummer, plaats, postcode FROM locatie");
            while (rs.next()) {
                int id = rs.getInt(1);
                String straat = rs.getString(2);
                String huisnummer = rs.getString(3);
                String plaats = rs.getString(4);
                String postcode = rs.getString(5);
                Locatie locatie = new Locatie(id, straat, huisnummer, plaats, postcode);
                locaties.put(id, locatie);
                System.out.println(locatie);
            }

            rs = statement.executeQuery("SELECT probleemID, beschrijving, datum, titel, afgehandeld, pakketID, trajectID FROM probleem");
            while (rs.next()) {
                int probleemID = rs.getInt("probleemID");
                String beschrijving = rs.getString("beschrijving");
                Timestamp datum = rs.getTimestamp("datum");
                String titel = rs.getString("titel");
                boolean afgehandeld = rs.getBoolean("afgehandeld");
                int trajectID = rs.getInt("trajectID");
                Probleem probleem;
//                if (trajectID != 0) {
//                    KlachtInfoPanel klacht = new KlachtInfoPanel(probleemID, titel, beschrijving, datum, afgehandeld);
//                    klachten.add(klacht);
//                    probleem = klacht;
//                } else {
//                    TrajectProbleem bezorgprobleem = new TrajectProbleem(probleemID, titel, beschrijving, datum, afgehandeld);
//                    bezorgProblemen.add(bezorgprobleem);
//                    probleem = bezorgprobleem;
//                }
//                System.out.println(probleem);
//                problemen.put(probleemID, probleem);
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

            rs = statement.executeQuery("SELECT v.orderID, v.klantID, definitief, aanmeldtijd, v.beginlocatie, v.eindlocatie, p.pakketID, gewicht, formaat, opmerking, status\n"
                    + ", t.trajectID, afhaaltijd, aflevertijd, r.beginlocatie, r.eindlocatie, r.koerierID, pr1.probleemID, pr2.probleemID FROM verzendorder v\n"
                    + "LEFT OUTER JOIN pakket p ON v.orderID = p.orderID\n"
                    + "LEFT OUTER JOIN traject t ON  p.pakketID = t.pakketID\n"
                    + "LEFT OUTER JOIN reis r ON t.reisID = r.reisID\n"
                    + "LEFT OUTER JOIN probleem pr1 ON pr1.trajectID = t.trajectID\n"
                    + "LEFT OUTER JOIN probleem pr2 ON pr2.pakketID = p.pakketID ORDER BY pakketID DESC, trajectID ASC;");
            while (rs.next()) {
                int orderID = rs.getInt("v.orderID");
                boolean definitief = rs.getBoolean("definitief");
                //Check of er een definitieve order is die nog niet is toegevoegd.
                if (definitief) {
                    if (pakketten.isEmpty() || (orderID == pakketten.get(pakketten.size() - 1).getOrder().getOrderID())) {
                        int klantID = rs.getInt("v.klantID");
                        AccountHouder klant = (AccountHouder) contacten.get(klantID);
                        Timestamp aanmeldTijd = rs.getTimestamp("aanmeldtijd");
                        Locatie beginLocatie = locaties.get(rs.getInt("v.beginlocatie"));
                        Locatie eindLocatie = locaties.get(rs.getInt("v.eindlocatie"));
                        VerzendOrder order = new VerzendOrder(klant, aanmeldTijd, orderID, beginLocatie, eindLocatie);
                        maakPakket(order, rs);
                    } else {
                        VerzendOrder order = pakketten.get(pakketten.size() - 1).getOrder();
                        maakPakket(order, rs);
                    }
                }
            }

            rs = statement.executeQuery("SELECT treinkoerier, datum, bedrag, isafgehandeld, goedgekeurd FROM kredietomzetting");
            while (rs.next()) {
                TreinKoerier treinKoerier = (TreinKoerier) contacten.get(rs.getInt("treinkoerier"));
                Timestamp datum = rs.getTimestamp("datum");
                Double bedrag = rs.getDouble("bedrag");
                Boolean isafgehandeld = rs.getBoolean("isafgehandeld");
                Boolean goedgekeurd = rs.getBoolean("goedgekoeurd");
                UitbetalingsVerzoek verzoek = new UitbetalingsVerzoek(datum, bedrag, isafgehandeld, treinKoerier, goedgekeurd);
                System.out.println(verzoek);
                if (verzoek.isAfgehandeld()) {
                    afgehandeldeVerzoeken.add(verzoek);
                } else {
                    nietAfgehandeldeVerzoeken.add(verzoek);
                }
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

}
