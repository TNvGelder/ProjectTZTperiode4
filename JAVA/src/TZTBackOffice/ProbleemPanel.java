/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import static TZTBackOffice.ContactOverzichtPanel.comboBoxItem1;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Jasper
 */
public class ProbleemPanel extends JPanel
        implements ListSelectionListener, ItemListener {

    private JLabel picture;
    private JList lijst1;
    private JList lijst2;
    private JSplitPane splitPane;
    private JPanel lijsten;
    private String[] imageNames = {"254 Niet Gearriveerd", "253 Te laat", "252 Niet Gearriveerd", "251 Niet Gearriveerd", "250 Niet Gearriveerd", "249 Niet Gearriveerd",
        "248 Te laat", "247 Te laat", "246 Niet Gearriveerd", "245 Niet Gearriveerd", "244 Niet Gearriveerd", "243 Niet Gearriveerd"};
    private String[] afgehandeld = {"254 pakket foetsie", "253 pakket stuk", "252 pakket niet gearriveerd", "251 Niet Gearriveerd", "250 Niet Gearriveerd", "249 Niet Gearriveerd",
        "248 Te laat", "247 Te laat", "246 Niet Gearriveerd", "245 Niet Gearriveerd", "244 Niet Gearriveerd", "243 Niet Gearriveerd"};

    public ProbleemPanel() {
        this.setLayout(new GridLayout(1, 1));

        lijst1 = new JList(imageNames);
        lijst1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lijst1.setSelectedIndex(0);
        lijst1.addListSelectionListener(this);
        
        lijst2 = new JList(afgehandeld);
        lijst2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lijst2.setSelectedIndex(0);
        lijst2.addListSelectionListener(this);
        
        JPanel lijstPanel = new JPanel();
        lijstPanel.setLayout(new BorderLayout());
        
        String comboBoxItems[] = {"Problemen", "Afgehandelde Problemen"};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
        lijsten = new JPanel(new CardLayout());
        lijsten.add(lijst1, "Problemen");
        lijsten.add(lijst2, "Afgehandelde Problemen");
        //cb.setBounds(0,0,100, 30);
        //lijsten.setBounds(0,30,200,100);
        lijsten.validate();
        lijsten.setPreferredSize(lijst1.getPreferredSize());
        lijstPanel.setPreferredSize(lijst1.getPreferredSize());
       
        
        JScrollPane lijstScrollPane = new JScrollPane(lijsten);
        picture = new JLabel();
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);

        
        lijstPanel.add(cb, BorderLayout.NORTH);
        lijstPanel.add(lijstScrollPane);
        
        JScrollPane pictureScrollPane = new JScrollPane(picture);

        //Create a split pane with the two scroll panes in it.
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
        lijstPanel, pictureScrollPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);

        //Provide minimum sizes for the two components in the split pane.
        Dimension minimumSize = new Dimension(100, 50);
        lijstScrollPane.setMinimumSize(minimumSize);
        pictureScrollPane.setMinimumSize(minimumSize);

        //Provide a preferred size for the split pane.
        splitPane.setPreferredSize(new Dimension(800, 200));
        updateLabel(imageNames[lijst1.getSelectedIndex()]);
        add(splitPane);
    }

    //Listens to the list
    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList) e.getSource();
        updateLabel(imageNames[list.getSelectedIndex()]);
    }

    //Renders the selected image
    protected void updateLabel(String name) {
//        ImageIcon icon = createImageIcon("images/" + name + ".gif");
//        picture.setIcon(icon);
//        if (icon != null) {
//            picture.setText(null);
//        } else {
//            picture.setText("Image not found");
//        }
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        CardLayout cl = (CardLayout) (lijsten.getLayout());
        cl.show(lijsten, (String) e.getItem());
    }

}
