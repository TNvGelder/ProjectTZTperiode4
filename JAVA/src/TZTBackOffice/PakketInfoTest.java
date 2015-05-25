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
        DatabaseManager databaseManager = new DatabaseManager();
        ArrayList<Pakket> pakketten = databaseManager.getPakketten();
        Pakket pakket = databaseManager.getPakket(23);
        System.out.println("\n" + pakket);

        
        JFrame testScherm = new JFrame();
        testScherm.setVisible(true);
        PakketInfoDialoog pakketInfo = new PakketInfoDialoog(pakket, testScherm);
        pakketInfo.setVisible(true);

        testScherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
