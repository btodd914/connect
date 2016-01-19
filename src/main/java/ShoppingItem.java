/**
 * Created by dev on 12/7/15.
 */

import io.orchestrate.client.OrchestrateClient;
import io.orchestrate.client.Result;
import io.orchestrate.client.SearchResults;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
/**
 * Created by ryantodd on 12/1/15.
 */


/**
 * Created by dev on 9/27/15.
 */
public class ShoppingItem {



    public static Scanner user_input = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Please choose what option you would like to do.");
        System.out.println("Type 'new' to add something to your pantry");
        System.out.println("Type 'delete' to delete something from your pantry");
        System.out.println("Type 'edit' to adjust the items in your pantry");
        System.out.println("Type 'list' to get a list of all items that are currently in your pantry");


        String choice = user_input.next();

        //using a switch statement to determine next steps depending on user input
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
        }
    }

    public static void addItem() {

        System.out.println("What item would you like to add to your pantry?");
        String itemName = user_input.next();
        int amount = 0;
        if (PantryDataStorage.itemConsists(itemName)) {
            System.out.println("That item is already in your pantry. Please edit this item instead.");
        } else {
            System.out.println("What is the amount that you would like to add?");
            amount = user_input.nextInt();
        }

        PantryItem pantryItem = new PantryItem(itemName, amount);

        PantryDataStorage.savePantryItem(itemName, pantryItem);

        System.out.println("You have added " + amount + " " + itemName + " to your pantry.");

    }

    public static void deleteItem() {
        System.out.println("What item would you like to delete?");
        String itemName = user_input.next();
        if (PantryDataStorage.itemConsists(itemName)) {
            PantryDataStorage.deletePantryItem(itemName);
            System.out.println(itemName + " has been removed from your pantry.");
        } else {
            System.out.println("That item does not exist in your pantry.");
        }
    }

    public static void editItem() {
        System.out.println("What item would you like to edit?");
        String itemName = user_input.next();

        if (PantryDataStorage.itemConsists(itemName)) {
            System.out.println("That item does not exist in your pantry.");
        } else {
            System.out.println("What is the amount that you would like to change to?");
            int amount = user_input.nextInt();
            PantryItem updatedPantryItem = new PantryItem(itemName, amount);

            PantryDataStorage.savePantryItem(itemName, updatedPantryItem);

            System.out.println("You have changed " + itemName + " to the amount of " + amount);
        }
    }

    public static void listItem() {
        System.out.println("Here is a list of all of the items in your pantry!");

        PantryDataStorage.iteratorMethod();
    }
}




