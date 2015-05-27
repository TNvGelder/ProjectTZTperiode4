/*
 * Gemaakt door: Jasper
 * Aangepast door: Twan
 * Functie: Laat de pakketten in een tabel zien
 */
package TZTBackOffice;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PakketOverzichtPanel extends JPanel implements ItemListener {

    JPanel cards;
    private JPanel categoriePanel;
    private HashMap<String, PakketTabelPanel> sorteerCategorieën;
    private JComboBox cb;
    private JFrame hoofdscherm;
    DatabaseManager databaseManager = new DatabaseManager();
    ArrayList<Pakket> pakketten = databaseManager.getPakketten();

    public PakketOverzichtPanel(DatabaseManager databasemanager, JFrame hoofdscherm) {

        setLayout(new BorderLayout());
//        comboBoxPane.add(cb);

        //Create the "cards".
        refresh();

        setVisible(true);
    }

    public void maakCategorie(String categorieNaam) {
        ArrayList<Pakket> pakketArray;
        PakketTabelPanel card;
        if (!categorieNaam.equals("Alle Pakketten")) {
            card = new PakketTabelPanel(hoofdscherm, pakketten);
        } else {
            card = new PakketTabelPanel(hoofdscherm);
        }

        sorteerCategorieën.put(categorieNaam, card);
        cb.addItem(categorieNaam);
        cards.add(card, categorieNaam);
    }

    public void refresh() {
        //Refresh de gegevens
        this.removeAll();
        categoriePanel = new JPanel();
        add(categoriePanel, BorderLayout.NORTH);
        sorteerCategorieën = new HashMap();
        cards = new JPanel(new CardLayout());

        cb = new JComboBox();
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
        maakCategorie("Alle Pakketten");
        categoriePanel.add(cb);
        add(cards);

        for (Pakket pakket : pakketten) {
            //Bekijk status van pakket

            String strStatus = pakket.getStatus();
            System.out.println("status: " + strStatus);
            if (!sorteerCategorieën.containsKey(strStatus)) {
                maakCategorie(strStatus);
            }

            PakketTabelPanel pakketTabel = sorteerCategorieën.get(strStatus);
            pakketTabel.voegPakketToe(pakket);
            PakketTabelPanel pakketTabel2 = sorteerCategorieën.get("Alle Pakketten");
            pakketTabel2.voegPakketToe(pakket);
            String strBetaald = null;

        }

    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }

}
