/*
 * Gemaakt door: Twan
 * Aangepast door: -
 * Functie: Maakt de knop in UitbetalingsPanel tabel werkend en opent een dialoog wanneer er op een knop gedrukt is
 */
package TZTBackOffice;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class VerzoekButtonEditor extends DefaultCellEditor {

    private ArrayList<UitbetalingsVerzoek> verzoeken;
    private JFrame hoofdscherm;
    private UitbetalingsPanel overzicht;

    public VerzoekButtonEditor(JCheckBox checkBox, JFrame hoofdscherm, ArrayList<UitbetalingsVerzoek> verzoeken, UitbetalingsPanel overzicht) {
        super(checkBox);
        this.verzoeken = verzoeken;
        this.overzicht = overzicht;
        this.hoofdscherm = hoofdscherm;
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
//

        UitbetalingsVerzoek verzoek = verzoeken.get(row);
        int keuze = JOptionPane.showOptionDialog(hoofdscherm, "Weet u zeker dat u dit uitbetalingsverzoek wil afhandelen?", "Afhandelen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[]{"Keur uitbetaling goed", "Keur uitbetaling af", "Annuleer"}, "default");
        if (keuze != JOptionPane.YES_OPTION && keuze != JOptionPane.NO_OPTION) {
            return null;
        }
        verzoek.handelAf();
        TreinKoerier koerier = verzoek.getKoerier();
        verzoek.setGoedgekeurd(keuze == JOptionPane.YES_OPTION);
        overzicht.verzoekAfgehandeld(verzoek);
        return null;
    }

}
