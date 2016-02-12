import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dev on 2/3/16.
 */
public class UI extends JFrame {

    private JButton buttonNew, buttonEdit, buttonDelete, buttonList;
    private JLabel header;


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
        buttonNew.addActionListener(
                new ButtonNewActionListener());

        panel.add(buttonNew);

        buttonEdit = new JButton("Edit An Item In Your UI");
        panel.add(buttonEdit);

        buttonDelete = new JButton("Delete An Item");
        panel.add(buttonDelete);

        buttonList = new JButton("List Items In Your UI");
        panel.add(buttonList);
    }



    public static void main (String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    private class ButtonNewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("You clicked on Add");
            ShoppingItem.addItem();

        }
    }
}
