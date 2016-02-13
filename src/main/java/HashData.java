import io.orchestrate.client.OrchestrateClient;
import io.orchestrate.client.Result;
import io.orchestrate.client.SearchResults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dev on 1/14/16.
 */
public class HashData {

    private static final String COLLECTION_NAME = "pantry";

    private static HashMap<String, PantryItem> pantry;// = new HashMap<String, PantryItem>();
    ShoppingItem shoppingItem = new ShoppingItem();


    public HashData() {
        pantry = new HashMap<String, PantryItem>();
        pantry = Database.getDatabaseItems();
    }

    public static void savePantryItem(String itemName, PantryItem updatedPantryItem){

        pantry.put(itemName, updatedPantryItem);
        Database.saveToDB(itemName,updatedPantryItem);

    }

    public static void deletePantryItem(String itemName){

        pantry.remove(itemName);
        Database.deleteFromDB(itemName);

    }

    public static boolean itemConsists(String itemName){

        return pantry.containsKey(itemName);

    }

    public static List<PantryItem> getItems(){
      return new ArrayList<>(pantry.values());
    }

    public static void iteratorMethod(){
        Iterator<PantryItem> pantryItemIterator = getItems().iterator();

        while (pantryItemIterator.hasNext()) {
            System.out.println(pantryItemIterator.next());
        }
    }

}
