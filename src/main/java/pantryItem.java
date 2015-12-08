/**
 * Created by dev on 12/7/15.
 */
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Created by dev on 12/4/15.
 */

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class pantryItem implements Serializable{
    private String item;

    private int amount;



    public pantryItem(String itemName , int currentAmount){

        item = itemName;

        amount = currentAmount;

    }

}


