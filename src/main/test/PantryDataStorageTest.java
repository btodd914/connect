import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by dev on 1/20/16.
 */
public class PantryDataStorageTest {

    @Test
    public void shouldSavePantryItem(){
        String itemExpected = "Onions";
        int amountExpected = 10;

        PantryDataStorage target = new PantryDataStorage();
        PantryItem newItem = new PantryItem(itemExpected,amountExpected);
        target.savePantryItem();





    }

}
