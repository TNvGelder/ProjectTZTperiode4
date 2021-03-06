/*
 * Gemaakt door: Twan
 * Aangepast door: -
 * Functie: Laat de gegevens zien van uitbetalen
 */
package TZTBackOffice;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UitbetalingsPanel extends JPanel implements ItemListener {
    
    JPanel cards;
    private JPanel categoriePanel;
    private JComboBox cb;
    private JFrame hoofdscherm;
    DatabaseManager databaseManager;
    
    public UitbetalingsPanel(DatabaseManager databasemanager, JFrame hoofdscherm) {
        this.databaseManager = databasemanager;
        setLayout(new BorderLayout());
//        comboBoxPane.add(cb);

        //Create the "cards".
        refresh();
        
        setVisible(true);
    }
    
    public void maakCategorie(String categorieNaam) {
        ArrayList<Pakket> pakketArray;
        PakketTabelPanel card;
//        if (!categorieNaam.equals("Alle Pakketten")){
//            card = new PakketTabelPanel(hoofdscherm, pakketten);
//        }else {
//            card = new PakketTabelPanel(hoofdscherm);
//        }

        cb.addItem(categorieNaam);
        //cards.add(card, categorieNaam);
    }
    
    public void verzoekAfgehandeld(UitbetalingsVerzoek verzoek) {
        databaseManager.updateUitbetalingsVerzoek(verzoek);
        databaseManager.updateContact(verzoek.getKoerier());
        refresh();
    }
    
    public void refresh() {
        this.removeAll();
        ArrayList<UitbetalingsVerzoek> verzoeken = databaseManager.getUitbetalingsVerzoeken();
        categoriePanel = new JPanel();
        add(categoriePanel, BorderLayout.NORTH);
        cards = new JPanel(new CardLayout());
        
        cb = new JComboBox();
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
        String categorie1 = "Niet Afgehandeld";
        String categorie2 = "Afgehandeld";
        maakCategorie(categorie1);
        maakCategorie(categorie2);
        categoriePanel.add(cb);
        add(cards);
        
        UitbetalingsTabelPanel tabelPanelAfgehandeld = new UitbetalingsTabelPanel(hoofdscherm, false, this);
        UitbetalingsTabelPanel tabelPanelNietAfgehandeld = new UitbetalingsTabelPanel(hoofdscherm, true, this);
        for (UitbetalingsVerzoek verzoek : verzoeken) {
            boolean afgehandeld = verzoek.isAfgehandeld();
            if (afgehandeld) {
                tabelPanelAfgehandeld.voegVerzoekToe(verzoek);
            } else {
                tabelPanelNietAfgehandeld.voegVerzoekToe(verzoek);
            }
        }
        
        cards.add(tabelPanelNietAfgehandeld, categorie1);
        cards.add(tabelPanelAfgehandeld, categorie2);
        
    }
    
    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }
    
}
