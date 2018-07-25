package customer_manager_after_selection;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ItemsReadyToOrder implements Serializable{
    public String name;
    public int qty;
    public int price;

    public ItemsReadyToOrder(String name,int price){
        this.name=name;
        this.price=price;

    }


    public String getName(){return name;}
    public int getPrice(){
        return price;
    }
    public int getQty(){return qty;}


}
