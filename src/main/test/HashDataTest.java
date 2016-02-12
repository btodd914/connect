import org.junit.Test;

/**
 * Created by dev on 1/20/16.
 */
public class HashDataTest {


    @Test
    public void itemShouldConsist(){

        String itemExpected = "Chocolate";

        HashData testItem = new HashData();
        testItem.itemConsists(itemExpected);
    }

}
