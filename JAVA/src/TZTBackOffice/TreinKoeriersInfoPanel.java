/*
 * Gemaakt door: Richard, Twan
 * Aangepast door: Jasper
 * Functie: Laat de treinkoerier gegevens zien in een panel
 */
package TZTBackOffice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class TreinKoeriersInfoPanel extends AccountHoudersInfoPanel implements ActionListener {

    private DatabaseManager databasemanager;
    private JTextField jtfRekening;
    
    
    public TreinKoeriersInfoPanel(TreinKoerier treinKoerier, DatabaseManager databasemanager, ContactOverzichtPanel overzicht) {
        
        super(treinKoerier, databasemanager, overzicht);
        this.databasemanager = databasemanager;
        this.setLayout(null);

        jlHead.setText("Treinkoerier");
        jlRekeningnr.setText("Rekeningnr*: ");
        jtfRekening = new JTextField(treinKoerier.getRekeningnr());
        jtfRekening.setBounds(550, 190, 200, 30);
        this.verplichteVelden.add(jtfRekening);
        add(jtfRekening);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
        if (e.getSource() == jbAanpassen) {
            if (!isIngevuld()) {
                jlFoutmelding.setText("Een van de verplichte velden is niet ingevuld!");
                return;
            } else {
                jlFoutmelding.setText("");
            }
            veranderAccGegevens();
            String rekening = jtfRekening.getText();
            TreinKoerier koerier = (TreinKoerier) account;
            koerier.setRekeningnr(rekening);
            databasemanager.updateContact(koerier);
            overzicht.refresh();
        }
    }
}
