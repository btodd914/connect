import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by dev on 2/3/16.
 */
public class UI extends JFrame {

    private final HashData hashData = new HashData();
    private JButton buttonNew, buttonEdit, buttonDelete, buttonList;
    private JLabel header;
    private JList listnew;
    private JTextField addItem, itemAmount;


    public UI(){
//        createView();

        createTest();

        setTitle("Look At Your Pantry!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(true);

    }

    private void createTest() {
        JPanel p = new JPanel(new BorderLayout());
        getContentPane().add(p);

        //This will build sub panels for our man panel
        JPanel northSide = new JPanel(new FlowLayout());
        JPanel westSide = new JPanel(new BorderLayout());
        JPanel eastSide = new JPanel(new FlowLayout());
        JPanel centerSide = new JPanel(new FlowLayout());

        //This adds our sub panels to our main panel
        p.add(northSide,BorderLayout.NORTH);
        p.add(eastSide,BorderLayout.EAST);
        p.add(westSide,BorderLayout.WEST);
        p.add(centerSide,BorderLayout.CENTER);

        List lst = new List();
        //Gets all of the items from the hash data class
        //and creates an iterator to use
        Iterator<PantryItem> iterator = hashData.getItems().iterator();
        //uses that iterator to go through and add all of the item names to a list to display
        while (iterator.hasNext()){
            PantryItem next = iterator.next();
            lst.add(next.getItemName());
        }

        //Building the buttons the same way you had below
        buttonNew = new JButton("Add New Item");
        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemAdded = addItem.getText();
                int amountWanted = itemAmount.getX();
            }
        });
        buttonEdit = new JButton("Edit An Item In Your Pantry");
        buttonDelete = new JButton("Delete An Item");
        buttonList = new JButton("Update Your List");
        addItem = new JTextField();
        addItem.setPreferredSize(new Dimension(150, 30));
        itemAmount = new JTextField();
        itemAmount.setPreferredSize(new Dimension(75, 30));

        //Since this is the only thing in the center side no organization needed
        centerSide.add(lst);
        //This uses flow layout so it will go from left to right an lay these components out
        northSide.add(buttonNew);
        northSide.add(buttonEdit);
        //This makes the button in the north location of the west side panel
        westSide.add(buttonDelete,BorderLayout.NORTH);
        westSide.add(buttonList,BorderLayout.SOUTH);
        //This uses flow layout so it will go from left to right an lay these components out
        eastSide.add(addItem);
        eastSide.add(itemAmount);
    }

    private void createView(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);
        header = new JLabel("Welcome to your UI!");
        header.setPreferredSize(
                new Dimension(300, 600));
        panel.add(header);

        JPanel panelWest = new JPanel(new BorderLayout());
        panel.add(panelWest, BorderLayout.WEST);

        JPanel panelNorth = new JPanel(new BorderLayout());
        panel.add(panelNorth, BorderLayout.NORTH);

        JPanel panelSouth = new JPanel(new BorderLayout());
        panel.add(panelSouth, BorderLayout.SOUTH);

        JPanel panelCenter = new JPanel(new BorderLayout());
        panel.add(panelCenter, BorderLayout.CENTER);



        buttonNew = new JButton("Add New Item");
        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemAdded = addItem.getText();
                int amountWanted = itemAmount.getX();

            }
        });

        panelWest.add(buttonNew, BorderLayout.NORTH);

        buttonEdit = new JButton("Edit An Item In Your Pantry");
        panelWest.add(buttonEdit, BorderLayout.NORTH);

        buttonDelete = new JButton("Delete An Item");
        panelWest.add(buttonDelete, BorderLayout.WEST);

        buttonList = new JButton("Update Your List");
        panelWest.add(buttonList, BorderLayout.WEST);

        listnew = new JList();
        listnew.setVisibleRowCount(200);
        panelCenter.add(listnew, BorderLayout.EAST);

        addItem = new JTextField();
        addItem.setPreferredSize(new Dimension(150, 30));
        panel.add(addItem);

        itemAmount = new JTextField();
        itemAmount.setPreferredSize(new Dimension(75, 30));
        panel.add(itemAmount);


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
