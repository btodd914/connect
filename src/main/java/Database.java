/**
 * Created by dev on 2/11/16.
 */

import io.orchestrate.client.OrchestrateClient;
import io.orchestrate.client.Result;
import io.orchestrate.client.SearchResults;

import java.util.HashMap;
import java.util.Iterator;

public class Database {

    private static final String COLLECTION_NAME = "pantry";
    private static String API_KEY = "c3672b0c-b96c-4145-8b75-bd6895b5458e";
    private static OrchestrateClient client = new OrchestrateClient(API_KEY);

    public static void saveToDB(String itemName, PantryItem updatedPantryItem){

        client.kv(COLLECTION_NAME, itemName).put(updatedPantryItem).get().getKey();
    }

    public static void deleteFromDB(String itemName){

        client.kv(COLLECTION_NAME,itemName)
                .delete()
                .get();
    }

    public static HashMap<String, PantryItem> getDatabaseItems(){
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
        return listHash; }

}
