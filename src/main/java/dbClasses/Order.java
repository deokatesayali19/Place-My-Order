package dbClasses;



import java.io.Serializable;
import java.util.Vector;

/**
 * Created by sayali on 9/10/17.
 */

public class Order implements Serializable{
    public int table_no;
    public int bill;
    public Vector<QuantifiedList> items;
    public Order(){

    }

    public Order(int table_no,int bill,Vector<QuantifiedList> items){
        this.table_no=table_no;
        this.bill=bill;
        this.items=items;
    }
    public int getTable_no(){return table_no;}
    public int getBill(){return bill;}
    public Vector<QuantifiedList> getItems(){return items;}
}
