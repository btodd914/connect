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
        setResizable(false);

    }

    private void createView(){
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        header = new JLabel("Welcome to your UI!");
        header.setPreferredSize(
                new Dimension(300,600));
        panel.add(header);


        buttonNew = new JButton("Add New Item");
        buttonNew.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String itemAdded = addItem.getText();
                int amountWanted = itemAmount.getX();



            }
        });

        panel.add(buttonNew);

        buttonEdit = new JButton("Edit An Item In Your Pantry");
        panel.add(buttonEdit);

        buttonDelete = new JButton("Delete An Item");
        panel.add(buttonDelete);

        buttonList = new JButton("Update Your List");
        panel.add(buttonList);

        listnew = new JList();
        listnew.setVisibleRowCount(4);

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
