import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by dev on 1/20/16.
 */
public class PantryDataStorageTest {


    @Test
    public void itemShouldConsist(){

        String itemExpected = "Chocolate";

        PantryDataStorage testItem = new PantryDataStorage();
        testItem.itemConsists(itemExpected);
    }

}
