import io.orchestrate.client.OrchestrateClient;
import io.orchestrate.client.Result;
import io.orchestrate.client.SearchResults;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by dev on 1/14/16.
 */
public class PantryDataStorage {

    private static final String COLLECTION_NAME = "pantry";
    private static HashMap<String, PantryItem> pantry = getDatabaseItems();
    private static String API_KEY = "c3672b0c-b96c-4145-8b75-bd6895b5458e";
    private static OrchestrateClient client = new OrchestrateClient(API_KEY);
    ShoppingItem shoppingItem = new ShoppingItem();



    public static void savePantryItem(String itemName, PantryItem updatedPantryItem){

        pantry.put(itemName, updatedPantryItem);
        client.kv(COLLECTION_NAME, itemName).put(updatedPantryItem).get().getKey();

    }

    public static void deletePantryItem(String itemName){

        pantry.remove(itemName);
        client.kv(COLLECTION_NAME, itemName)
        .delete()
        .get();
    }

    public static HashMap<String, PantryItem>getDatabaseItems(){

        SearchResults<PantryItem> result = client
                .searchCollection(COLLECTION_NAME)
                .limit(100)
                .get(PantryItem.class, "*")
                .get();

        Iterator<Result<PantryItem>> iterator = result.getResults().iterator();
        HashMap<String, PantryItem> listHash = new HashMap<String, PantryItem>();

        while(iterator.hasNext()){
            PantryItem pantryitem = iterator.next().getKvObject().getValue();
            listHash.put(pantryitem.getItemName(), pantryitem);
        }
        return listHash;
    }
    public static boolean itemConsists(String itemName){

        pantry.containsKey(itemName);
        return true;
    }

    public static void iteratorMethod(){
        Iterator<PantryItem> pantryItemIterator = pantry.values().iterator();

        while (pantryItemIterator.hasNext()) {
            System.out.println(pantryItemIterator.next());
        }
    }

}
