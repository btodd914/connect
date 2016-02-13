import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by dev on 2/3/16.
 */
public class UI extends JFrame {

    private JButton buttonNew, buttonEdit, buttonDelete, buttonList;
    private JLabel header;
    private JList listnew;
    private JTextField addItem, itemAmount;
    public static HashData loadHash = new HashData();


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
