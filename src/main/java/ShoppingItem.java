/**
 * Created by dev on 12/7/15.
 */
//import org.apache.log4j.Logger;
import java.util.Scanner;

/**
 * Created by ryantodd on 12/1/15.
 */


/**
 * Created by dev on 9/27/15.
 */
public class ShoppingItem {

    public static HashData pantryHash = new HashData();
    public static Scanner user_input = new Scanner(System.in);
    public static void menuPrompt() {

        System.out.println("\n");
        System.out.println("Please choose what option you would like to do.");
        System.out.println("Type 'new' to add a NEW item to your pantry");
        System.out.println("Type 'delete' to delete something from your pantry");
        System.out.println("Type 'edit' to adjust the items in your pantry");
        System.out.println("Type 'list' to get a list of all items that are currently in your pantry");
        System.out.println("Type 'exit' to quit the program.");
        System.out.println("\n");
    }

//    private static Logger logger = Logger.getLogger(ShoppingItem.class);


    public static void main(String[] args) {


        //using a switch statement to determine next steps depending on user input
        while(true){

            menuPrompt();
            String choice = user_input.next().toLowerCase();


            switch (choice) {
                case "new":
                    addItem();
                    break;
                case "delete":
                    deleteItem();
                    break;
                case "edit":
                    editItem();
                    break;
                case "list":
                    listItem();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("That is not a valid choice.");
                    break;

            }
        }
    }

    public static void addItem() {

//        if (logger.isDebugEnabled()) {
//            logger.debug("addItem | Start...");
//        }
//        logger.debug("This is outside of an if block");

        System.out.println("What item would you like to add to your pantry?");
        String itemName = user_input.next();
        int amount = 0;
        if (pantryHash.itemConsists(itemName)) {
            System.out.println("That item is already in your pantry. Please edit this item instead.");
        } else {
            System.out.println("What is the amount that you would like to add?");
            amount = user_input.nextInt();

            PantryItem pantryItem = new PantryItem(itemName, amount);

           pantryHash.savePantryItem(itemName, pantryItem);

            System.out.println("You have added " + amount + " " + itemName + " to your pantry.");

        }


    }

    public static void deleteItem() {
        System.out.println("What item would you like to delete?");
        String itemName = user_input.next();
        if (HashData.itemConsists(itemName)) {
            HashData.deletePantryItem(itemName);
            System.out.println(itemName + " has been removed from your pantry.");
        } else {
            System.out.println("That item does not exist in your pantry.");
        }
    }

    public static void editItem() {
        System.out.println("What item would you like to edit?");
        String itemName = user_input.next();

        if (HashData.itemConsists(itemName)) {
            System.out.println("What is the amount that you would like to change to?");
            int amount = user_input.nextInt();
            PantryItem updatedPantryItem = new PantryItem(itemName,amount);

            HashData.savePantryItem(itemName, updatedPantryItem);
            System.out.println("You have changed " + itemName + " to the amount of " + amount);
        } else {
            System.out.println("That item does not exist in your pantry");
        }
    }

    public static void listItem() {
        System.out.println("Here is a list of all of the items in your pantry!");

        HashData.iteratorMethod();
    }
}




