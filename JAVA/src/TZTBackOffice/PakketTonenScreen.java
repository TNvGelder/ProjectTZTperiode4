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
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class PakketTonenScreen extends JFrame implements ActionListener {

    private PakketTonen pakkettonen;
    private JComboBox jComboPakketSoorten;
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

    public PakketTonenScreen(PakketTonen PakketTonen) {
        this.pakkettonen = pakkettonen;
        setTitle("Overzicht pakketten");
        setSize(700, 600);
        setLayout(new GridLayout(6, 1));

        setLayout(new FlowLayout());
        String[] pakketSoorten = {"Aangemelde pakketten", "Verzonden pakketten", "Gearriveerde pakketten"};
        JComboBox jComboPakketSoorten = new JComboBox(pakketSoorten);
        jComboPakketSoorten.setSelectedIndex(0);
        jComboPakketSoorten.addActionListener(this);
        add(jComboPakketSoorten);

        jbTerug = new JButton("Terug");
        add(jbTerug);
        jbTerug.addActionListener(this);

        String[] columns = {"Pakket nr", "Aanmeldtijd", "Aflevertijd", "Datum", "Organisatie", "Formaat", "Gewicht", "Betaald", ""};

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

        dataType = dataVerzonden;
        System.out.println(dataType);

        TableModel model = new DefaultTableModel((Object[][]) dataType, columns) {
            @Override
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };
        JTable table = new JTable(model) {

            @Override
            public Component prepareRenderer(TableCellRenderer r, int data, int columns) {
                Component c = super.prepareRenderer(r, data, columns);

                if (columns % 2 == 0) {
                    c.setBackground(Color.WHITE);
                } else {
                    c.setBackground(Color.LIGHT_GRAY);
                }

                if (isCellSelected(data, columns)) {
                    c.setBackground(Color.GREEN);
                }

                return c;
            }
        };

        RowSorter<TableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        getContentPane().add(new JScrollPane(table));

        table.setPreferredScrollableViewportSize(new Dimension(450, 140));
        table.setFillsViewportHeight(true);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String msg = (String) cb.getSelectedItem();
        switch (msg) {
            case "Aangemelde pakketten":
                System.out.println("aangemelde");

                break;
            case "Verzonden pakketten":
                System.out.println("verzonden");
//
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

        setVisible(true);
    }

}
