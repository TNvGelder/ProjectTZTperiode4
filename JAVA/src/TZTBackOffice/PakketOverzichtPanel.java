/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jasper
 */
public class PakketOverzichtPanel extends JPanel implements ActionListener {

    private PakketTonen pakkettonen;
    private JButton jbTerug;
    private JTable jt;
    private Object dataType;
//    private String[][] dataAangemeld;
//
//    private String[][] dataVerzonden = {{"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
//    {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
//    {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
//    {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
//    {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
//    {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
//    {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
//    {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
//    {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
//    {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
//    {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
//    {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"}};

    public PakketOverzichtPanel() {
        //Layout scherm
        setSize(700, 600);
        setLayout(new FlowLayout());

        //Aanmaken Combobox met naamgeving en link naar actionlistener
        String[] pakketSoorten = {"Aangemelde pakketten", "Verzonden pakketten", "Gearriveerde pakketten"};
        JComboBox jComboPakketSoorten = new JComboBox(pakketSoorten);
        jComboPakketSoorten.setSelectedIndex(0);
        jComboPakketSoorten.addActionListener(this);
        add(jComboPakketSoorten);

        //Terug knop aanmaken
        jbTerug = new JButton("Terug");
        add(jbTerug);
        jbTerug.addActionListener(this);

        //Naamgeving kolommen van de tabel
        String[] columns = {"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", ""};

        //De 3 soorten data als array voor in de tabel, dit is dummy data, dit wordt een query
        String[][] dataAangemeld = {{"33333", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"}};

        String[][] dataVerzonden = {{"55555", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"}};

        String[][] dataGearriveerd = {{"77777", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"66987", "8:22 AM", "18:47 PM", "11/7/15", "Bedrijf BV", "80x700x50", "8000 g", "-"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"},
        {"43254", "16:44 PM", "20:04 PM", "24/4/15", "Esyst BV", "30x40x10", "476 g", "Betaald"}};

        //Laat de data van data verzonden zien, dit is als tett
        dataType = dataVerzonden;
        System.out.println(dataType);

        //Creeër tabel model met de hierboven naamgegeven kolommen en data volgens de veriabele dataType
        TableModel model = new DefaultTableModel((Object[][]) dataType, columns) {
            //Zorg dat de tabel niet te bewerken is
            @Override
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };
        //Creeër tabel met model
        JTable table = new JTable(model) {
            //Specifieke opmaak tabel voor kleuren
            @Override
            public Component prepareRenderer(TableCellRenderer r, int data, int columns) {
                Component c = super.prepareRenderer(r, data, columns);
                //Maak een kolom om en om grijs
                if (columns % 2 == 0) {
                    c.setBackground(Color.WHITE);
                } else {
                    c.setBackground(Color.LIGHT_GRAY);
                }
                //Wanneer rij geselecteerd, maak rij oranje
                if (isCellSelected(data, columns)) {
                    c.setBackground(Color.ORANGE);
                }

                return c;
            }
        };

        //Sorteren voor in de tabel
        RowSorter<TableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        this.add(new JScrollPane(table));
        //Scroll mogelijkheid en dimensies van tabel
        table.setPreferredScrollableViewportSize(new Dimension(450, 140));
        table.setFillsViewportHeight(true);

    }

    //Actionperformed voor acties

    @Override
    public void actionPerformed(ActionEvent e) {
        //defineer combobox
        JComboBox cb = (JComboBox) e.getSource();
        String msg = (String) cb.getSelectedItem();
        //Doe actie als er een combobox geselecteerd is
        switch (msg) {
            case "Aangemelde pakketten":
                System.out.println("aangemelde");
                break;
            case "Verzonden pakketten":
                System.out.println("verzonden");
//                dataType = dataVerzonden;
//                System.out.println(dataVerzonden);
//
//                String[] columns = {"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", ""};
//
//                TableModel model = new DefaultTableModel((Object[][]) dataType, columns) {
//                    @Override
//                    public boolean isCellEditable(int data, int columns) {
//                        return false;
//                    }
//                };
//                JTable table = new JTable(model) {
//
//                    @Override
//                    public Component prepareRenderer(TableCellRenderer r, int data, int columns) {
//                        Component c = super.prepareRenderer(r, data, columns);
//
//                        if (columns % 2 == 0) {
//                            c.setBackground(Color.WHITE);
//                        } else {
//                            c.setBackground(Color.LIGHT_GRAY);
//                        }
//
//                        if (isCellSelected(data, columns)) {
//                            c.setBackground(Color.ORANGE);
//
//                        }
//
//                        return c;
//                    }
//                };
//
//                RowSorter<TableModel> sorter = new TableRowSorter<>(model);
//                table.setRowSorter(sorter);
//                getContentPane().add(new JScrollPane(table));
//
//                table.setPreferredScrollableViewportSize(new Dimension(450, 140));
//                table.setFillsViewportHeight(true);
//
//                setVisible(true);

                break;
            case "Gearriveerde pakketten":
                System.out.println("gearriveerd");
                break;
            default:
                System.out.println("something went wrong");
        }
        //Update scherm voor veranderingen zichtbaar maken
        setVisible(true);
    }

}
