package dbClasses;

import java.io.Serializable;

/**
 * Created by sayali on 9/10/17.
 */

public class QuantifiedList implements Serializable{
    public String name;
    public int qty;
    public int price;

    public QuantifiedList(String name,int price,int qty){
        this.name=name;
        this.price=price;
        this.qty=qty;

    }


    public String getName(){return name;}
    public int getPrice(){
        return price;
    }
    public int getQty(){return qty;}

}
