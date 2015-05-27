/*
 * Gemaakt door: Twan
 * Aangepast door: Jasper
 * Functie: DatabaseManager zorgt voor de communicatie met de server. Dit zorgt ervoor dat er buiten de databasemanger niet met queries gewerkt hoeft te worden.
 * De databasemanger zet data om naar java objecten en kan ook een rij in de database updaten aan de hand van bepaalde objecten.
 */
package TZTBackOffice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager {

    private HashMap<Integer, Locatie> locaties;
    private String url;
    private String username, password;
    private HashMap<Integer, Contact> contactHashmap;
    private HashMap<Integer, Probleem> problemen;
    private ArrayList<UitbetalingsVerzoek> uitbetalingsVerzoeken;
    private ArrayList<TrajectProbleem> bezorgProblemen;
    private ArrayList<Klacht> klachten;
    private ArrayList<Pakket> pakketten;
    private ArrayList<Contact> contactArray;
    private Traject vorigTraject;

    // Aangemeld, verzonden, gearriveerd
    public DatabaseManager() {

        url = "jdbc:mysql://localhost:3307/mydb";
        username = "root";
        password = "usbw";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger("").log(Level.SEVERE, null, ex);
        }

        haalDataOp();

    }

    public ArrayList<Contact> getContacten() {
        return contactArray;
    }

    public ArrayList<UitbetalingsVerzoek> getUitbetalingsVerzoeken() {
        return uitbetalingsVerzoeken;
    }

    public ArrayList<TrajectProbleem> getBezorgProblemen() {
        return bezorgProblemen;
    }

    public ArrayList<Klacht> getKlachten() {
        return klachten;
    }

    public Pakket getPakket(int pakketID) {
        for (Pakket pakket : pakketten) {
            if (pakket.getPakketID() == pakketID) {
                return pakket;
            }
        }
        return null;
    }

    //Geeft een array van alle pakketten.
    public ArrayList<Pakket> getPakketten() {
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
            contactArray.add(0, contact1);
            contactHashmap.put(contact1.getContactID(), contact1);
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
        boolean geclaimd = r.getBoolean("geclaimd");
        if (trajectID != 0 && geclaimd) {
            int koerierID = r.getInt("r.koerierID");
            if (vorigTraject == null || vorigTraject.getTrajectID() != trajectID) {
                Timestamp afhaaltijd = r.getTimestamp("afhaaltijd");
                Timestamp aflevertijd = r.getTimestamp("aflevertijd");
                Locatie beginLocatie = locaties.get(r.getInt("r.beginlocatie"));
                Locatie eindLocatie = locaties.get(r.getInt("r.eindlocatie"));
                Contact koerier = contactHashmap.get(r.getInt("r.koerierID"));
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

    public void voegTariefToe(Tarief tarief1) {

        Connection connection = null;
        Statement statement;
        //Probeer de statement uit te voeren
        try {
            //Maak connectie met DB
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            //Insert statement maken
            String query = " INSERT INTO tarief (koeriersID, km, prijs, extraprijs)" + " values (?, ?, ?, ?)";

            //Preparedstatement maken
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.setInt(1, tarief1.getKoeriersDienst().getContactID());
            preparedStmt.setInt(2, tarief1.getKm());
            preparedStmt.setDouble(3, tarief1.getPrijs());
            preparedStmt.setDouble(4, tarief1.getExtraPrijs());

            //Voer preparedstatement uit
            preparedStmt.execute();
            System.out.println("tarief aangemaakt");

            //Sluit connectie
            connection.close();
        } catch (Exception e) {
            //Als de connectie of statement een error opleverd
            System.out.println("Er is iets misgegaan met de functie voegTariefToe");
            System.out.println(e);
        }
    }

    public void updateContact(Contact c) {

        Connection connection = null;
        Statement statement;
        //Probeer de statement uit te voeren
        try {
            //Maak connectie met DB
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            //Update statement maken
            String query = " UPDATE stakeholder SET naam = ?, telefoonnr = ?, type = ? WHERE stakeholderID = ?";
            //Preparedstatement maken
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.setString(1, c.getNaam());
            preparedStmt.setString(2, c.getTelefoonnr());
            preparedStmt.setString(3, c.getType());

            preparedStmt.setInt(4, c.getContactID());

            //Voer preparedstatement uit
            preparedStmt.executeUpdate();
            System.out.println("accounthouder geupdate");

            //Sluit connectie
            connection.close();
        } catch (Exception e) {
            //Als de connectie of statement een error opleverd
            System.out.println("Er is iets misgegaan met de functie updateContact");
            System.out.println(e);
        }
    }

    public void updateUitbetalingsVerzoek(UitbetalingsVerzoek verzoek) {
        Connection connection = null;
        Statement statement;
        //Probeer de statement uit te voeren
        try {
            //Maak connectie met DB
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            boolean afgehandeld = verzoek.isAfgehandeld();
            boolean goedgekeurd = verzoek.isGoedgekeurd();
            int treinkoeriersID = verzoek.getKoerier().getContactID();
            Timestamp datum = verzoek.getDatum();
            //Update statement maken
            String query = " UPDATE kredietomzetting SET isafgehandeld = ?, isgoedgekeurd = ? WHERE treinkoerier = ? AND datum = ? ";
            //Preparedstatement maken
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.setBoolean(1, afgehandeld);
            preparedStmt.setBoolean(2, goedgekeurd);
            preparedStmt.setInt(3, treinkoeriersID);

            preparedStmt.setTimestamp(4, datum);

            //Voer preparedstatement uit
            preparedStmt.executeUpdate();

            //Sluit connectie
            connection.close();
        } catch (Exception e) {
            //Als de connectie of statement een error opleverd
            System.out.println("Er is iets misgegaan met de functie updateUitbetalingsVerzoek");
            System.out.println(e);
        }
    }

    public void updateLocatie(AccountHouder a) {

        Connection connection = null;
        Statement statement;
        //Probeer de statement uit te voeren
        try {
            //Maak connectie met DB
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            //Dit moet allemaal geupdate worden
//            a.setNaam(strNaam);
//            a.setAchternaam(strAchternaam);
//            a.setTelefoonnr(strTelefoonnummer);
//            a.getLocatie().setPlaats(strWoonplaats);
//            a.getLocatie().setPostcode(strPostcode);
//            a.getLocatie().setStraat(strStraat);
//            a.getLocatie().setHuisnummer(strHuisnummer);
//            type
            //Update statement maken
            String query = " UPDATE locatie SET straat = ?, huisnummer = ?, plaats = ?, postcode = ? WHERE locatienr = ?";

            //Preparedstatement maken
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.setString(1, a.getLocatie().getStraat());
            preparedStmt.setString(2, a.getLocatie().getHuisnummer());
            preparedStmt.setString(3, a.getLocatie().getPlaats());
            preparedStmt.setString(4, a.getLocatie().getPostcode());

            preparedStmt.setInt(5, a.getLocatie().getLocatieID());

            //Voer preparedstatement uit
            preparedStmt.executeUpdate();
            System.out.println("locatie geupdate");

            //Sluit connectie
            connection.close();
        } catch (Exception e) {
            //Als de connectie of statement een error opleverd
            System.out.println("Er is iets misgegaan met de functie updateLocatie");
            System.out.println(e);
        }
    }

    public void deleteKoeriersdienst(TreinKoerier t) {

        Connection connection = null;
        Statement statement;
        //Probeer de statement uit te voeren
        try {
            //Maak connectie met DB
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            //Update statement maken
            String query = " DELETE FROM stakeholder WHERE stakeholderID = ?";

            //Preparedstatement maken
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.setInt(1, t.getContactID());

            //Voer preparedstatement uit
            preparedStmt.executeUpdate();
            System.out.println("Treinkoerier verwijderd");

            //Sluit connectie
            connection.close();
        } catch (Exception e) {
            //Als de connectie of statement een error opleverd
            System.out.println("Er is iets misgegaan met de functie deleteKoeriersdienst");
            System.out.println(e);
        }
    }

    //Maakt nieuwe pakketten aan met behulp van gegevens uit de order en resultset.
    //Bijbehorende trajecten worden ook aangemaakt.
    private void maakPakket(VerzendOrder order, ResultSet r) throws SQLException {

        int pakketID = r.getInt("p.pakketID");
        if (pakketID == 0) {
            return;
        }
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

        int probleemID = r.getInt("pr2.probleemID");
        if (probleemID != 0) {
            Klacht klacht = (Klacht) problemen.get(probleemID);
            klacht.setPakket(pakket);
        }
    }

    public void maakTarief(KoeriersDienst koeriersDienst, ResultSet rs) throws SQLException {
        int km = rs.getInt("km");
        Double prijs = rs.getDouble("prijs");
        if (prijs == 0) {
            return;
        }
        Double extraPrijs = rs.getDouble("extraPrijs");
        Tarief tarief = new Tarief(koeriersDienst, km, prijs, extraPrijs);
        koeriersDienst.voegTariefToe(tarief);
    }

    //Haalt pakketten op uit de database en vult de array pakket objecten;
    public void haalDataOp() {

        Connection connection = null;
        Statement statement;
        vorigTraject = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            if (username.equals("root")) {
                url = "jdbc:mysql://karsbarendrecht.nl:3306/karsbaj97_tzt";
                username = "karsbaj97_tzt";
                password = "wtj01";
                System.out.println("Kan geen verbinding maken met USBwebserver. In plaats daarvan wordt er nu geprobeerd om verbinding te maken met de live database op karsbarendrecht.nl");
                haalDataOp();
            } else {
                Logger.getLogger("").log(Level.SEVERE, null, ex);
            }
            return;
        }

        pakketten = new ArrayList();
        bezorgProblemen = new ArrayList();
        uitbetalingsVerzoeken = new ArrayList();
        contactArray = new ArrayList();
        klachten = new ArrayList();
        contactHashmap = new HashMap();
        locaties = new HashMap();
        problemen = new HashMap();
        //Indien er een werkende connectie is worden de queries uitgevoerd en worden er objecten aangemaakt.
        try {
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
                if (trajectID == 0) {
                    Klacht klacht = new Klacht(probleemID, titel, beschrijving, datum, afgehandeld);
                    klachten.add(klacht);
                    probleem = klacht;
                } else {
                    TrajectProbleem bezorgprobleem = new TrajectProbleem(probleemID, titel, beschrijving, datum, afgehandeld);
                    bezorgProblemen.add(bezorgprobleem);
                    probleem = bezorgprobleem;
                }
                System.out.println(probleem);
                problemen.put(probleemID, probleem);
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

                            Double krediet = rs.getDouble("krediet");
                            String rekeningnr = rs.getString("rekeningnr");
                            TreinKoerier koerier = new TreinKoerier(krediet, rekeningnr, naam, typenaam, email, telefoonnr, contactID, achternaam, locatie);
                            klant = koerier;
                        } else {
                            String ovkaart = rs.getString("ovkaart");
                            String idkaart = rs.getString("idkaart");
                            klant = new AccountHouder(naam, typenaam, email, telefoonnr, contactID, achternaam, locatie, ovkaart, idkaart);
                        }
                        contact = klant;

                    } else {
                        KoeriersDienst koeriersDienst = new KoeriersDienst(naam, typenaam, email, telefoonnr, contactID);
                        maakTarief(koeriersDienst, rs);
                        System.out.println(typenaam + " " + koeriersDienst);
                        contact = koeriersDienst;
                    }
                    contactHashmap.put(contact.getContactID(), contact);
                    contactArray.add(contact);
                } else if (!"gebruiker".equals(typenaam) || "geverifieerd".equals(typenaam)) {
                    try {
                        KoeriersDienst koeriersDienst = (KoeriersDienst) contactArray.get(contactArray.size() - 1);
                        maakTarief(koeriersDienst, rs);
                    } catch (ClassCastException ex) {

                    }

                }

            }

            rs = statement.executeQuery("SELECT v.orderID, v.klantID, definitief, aanmeldtijd, v.beginlocatie, v.eindlocatie, p.pakketID, gewicht, formaat, opmerking, status\n"
                    + ", t.trajectID, afhaaltijd, aflevertijd, geclaimd, r.beginlocatie, r.eindlocatie, r.koerierID, pr1.probleemID, pr2.probleemID FROM verzendorder v\n"
                    + "LEFT OUTER JOIN pakket p ON v.orderID = p.orderID\n"
                    + "LEFT OUTER JOIN traject t ON  p.pakketID = t.pakketID\n"
                    + "LEFT OUTER JOIN reis r ON t.reisID = r.reisID\n"
                    + "LEFT OUTER JOIN probleem pr1 ON pr1.trajectID = t.trajectID\n"
                    + "LEFT OUTER JOIN probleem pr2 ON pr2.pakketID = p.pakketID ORDER BY v.orderID DESC, pakketID DESC, trajectID ASC;");
            while (rs.next()) {
                int orderID = rs.getInt("v.orderID");
                boolean definitief = rs.getBoolean("definitief");
                System.out.println(orderID);
                //Check of er een definitieve order is die nog niet is toegevoegd.
                if (definitief) {
                    if (pakketten.isEmpty() || (orderID != pakketten.get(pakketten.size() - 1).getOrder().getOrderID())) {
                        int klantID = rs.getInt("v.klantID");
                        AccountHouder klant = (AccountHouder) contactHashmap.get(klantID);
                        Timestamp aanmeldTijd = rs.getTimestamp("aanmeldtijd");
                        System.out.println(rs.getInt("v.beginlocatie"));
                        Locatie beginLocatie = locaties.get(rs.getInt("v.beginlocatie"));
                        Locatie eindLocatie = locaties.get(rs.getInt("v.eindlocatie"));
                        VerzendOrder order = new VerzendOrder(klant, aanmeldTijd, orderID, beginLocatie, eindLocatie);
                        System.out.println(order);
                        maakPakket(order, rs);
                    } else {
                        VerzendOrder order = pakketten.get(pakketten.size() - 1).getOrder();
                        maakPakket(order, rs);
                    }
                }
            }

            rs = statement.executeQuery("SELECT treinkoerier, datum, bedrag, isafgehandeld, goedgekeurd FROM kredietomzetting ORDER BY datum DESC");
            while (rs.next()) {
                TreinKoerier treinKoerier = (TreinKoerier) contactHashmap.get(rs.getInt("treinkoerier"));
                Timestamp datum = rs.getTimestamp("datum");
                Double bedrag = rs.getDouble("bedrag");
                Boolean isafgehandeld = rs.getBoolean("isafgehandeld");
                Boolean goedgekeurd = rs.getBoolean("goedgekeurd");
                UitbetalingsVerzoek verzoek = new UitbetalingsVerzoek(datum, bedrag, isafgehandeld, treinKoerier, goedgekeurd);
                System.out.println(verzoek);
                uitbetalingsVerzoeken.add(verzoek);
            }

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger("").log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger("").log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
