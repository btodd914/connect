import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;



/**
 * Created by dev on 2/3/16.
 */
public class UI extends JFrame {

    private JButton buttonNew, buttonEdit, buttonDelete, buttonList;
    private JLabel header;
    private List listNew;
    private JTextField addItem, itemAmount;
    private final HashData loadHash = new HashData();


    public UI(){
        createView();

        setTitle("Look At Your Pantry!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(true);

    }

    private void createView(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);
        header = new JLabel("Welcome to your UI!");
        header.setPreferredSize(
                new Dimension(600, 600));
        panel.add(header);

        JPanel panelWest = new JPanel(new BorderLayout());
        panel.add(panelWest, BorderLayout.WEST);

        JPanel panelNorth = new JPanel(new FlowLayout());
        panel.add(panelNorth, BorderLayout.NORTH);

        JPanel panelCenter = new JPanel(new FlowLayout());
        panel.add(panelCenter, BorderLayout.CENTER);

        JPanel panelEast = new JPanel((new FlowLayout()));
        panel.add(panelEast, BorderLayout.EAST);



        buttonNew = new JButton("Add New Item");
        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShoppingItem.addItem();
                addItem.getText();
                itemAmount.getComponentCount();


            }
        });
        panelNorth.add(buttonNew);

        buttonEdit = new JButton("Edit An Item In Your Pantry");
        panelNorth.add(buttonEdit);

        buttonDelete = new JButton("Delete An Item");
        panelWest.add(buttonDelete, BorderLayout.NORTH);

        buttonList = new JButton("Update Your List");
        panelWest.add(buttonList, BorderLayout.SOUTH);

        listNew = new List();
        Iterator<PantryItem> iterator = loadHash.getItems().iterator();
        while(iterator.hasNext()){
            PantryItem next = iterator.next();
            listNew.add(next.getItemName());

        }
        panelCenter.add(listNew);
        listNew.setPreferredSize(new Dimension(300, 300));
        listNew.

        addItem = new JTextField();
        addItem.setPreferredSize(new Dimension(150, 30));
        panelEast.add(addItem);

        itemAmount = new JTextField();
        itemAmount.setPreferredSize(new Dimension(75, 30));
        panelEast.add(itemAmount);


    }

    public static void main (String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

}
