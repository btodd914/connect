import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dev on 1/20/16.
 */

public class PantryItemTest {

    @Test

    public void shouldSetAndGetPantryItemAmount() {

        int expectedAmount = 20;

        PantryItem target = new PantryItem();
        target.setAmount(expectedAmount);

        Assert.assertEquals(expectedAmount, target.getAmount());


    }
    @Test

    public void shouldSetAndGetPantryItemName(){

        String itemWanted = "pumpkin";

        PantryItem target = new PantryItem();
        target.setItemName(itemWanted);

        Assert.assertEquals(itemWanted, target.getItemName());
    }

}
