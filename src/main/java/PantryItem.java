/**
 * Created by dev on 12/7/15.
 */

import java.io.Serializable;

/**
 * Created by dev on 12/4/15.
 */

public class PantryItem implements Serializable {
    private String itemName;
    private int amount;

    public PantryItem(String itemName, int currentAmount) {
        this.itemName = itemName;
        amount = currentAmount;
    }

    public PantryItem() {

    }

    public int getAmount() {
        return amount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String toString() {
        return "PantryItem: " + itemName + " Amount:" + amount;
    }
}


