package TZTBackOffice;

import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Michiel
 */
public class PakketInfoTest {

    public static void main(String[] args) {
        Locatie locatie = new Locatie(1, "PieterStraat", "3B", "PieterStad", "1234 PP");
        AccountHouder klant = new AccountHouder("Piet", "gebruiker", "Piet@gmail.com", "03342023423", 1, "Pietersen", locatie);
        LocalDate localDateTime = LocalDate.now();
        VerzendOrder verzendOrder = new VerzendOrder(1, klant, new Timestamp(1));
        //Pakket p = new Pakket(1, 200, "30x20x15", verzendOrder, "breekbaar", "onderweg");
        DatabaseManager databaseManager = new DatabaseManager();
        ArrayList<Pakket> pakketten = databaseManager.getPakketten();
        Pakket pakket = pakketten.get(1);
        System.out.println("\n"+ pakket);
        
        
        PakketInfoDialoog pakketInfo = new PakketInfoDialoog(pakket);
        JFrame testScherm = new JFrame();
        
        
        
        testScherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
