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
        Pakket pakket = pakketten.get(0);
        System.out.println("\n" + pakket);

        PakketInfoDialoog pakketInfo = new PakketInfoDialoog(pakket);
        JFrame testScherm = new JFrame();

        testScherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
