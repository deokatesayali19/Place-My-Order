package customer_manager_after_selection;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

import dbClasses.Order;
import dbClasses.QuantifiedList;

import static com.example.sayali.placemyorder.ClientThread.s;
public class SendOrder implements Runnable {
    Context context;
    int bill;
    int table_no;
    Vector<QuantifiedList> items;
    public SendOrder(Context context,int bill,int table_no,Vector<QuantifiedList> items){
        Log.w("SendOrder","welcome");
        this.context=context;
        this.bill=bill;
        this.table_no=table_no;
        this.items=items;
        Thread t=new Thread(this);
        t.start();
    }
    public void run(){
        try {

            Log.w("SendOrder","yo");
            ObjectOutputStream oos=null;
            if(s!=null)
                Log.w("SendOrder"," s is not null");
            Log.w("SendOrder",Integer.toString(table_no));
            Log.w("SendOrder",Integer.toString(bill));
            Vector<Order> x=new Vector<Order>();
            x.add(new Order(table_no,bill,items));
            oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(x);
            Log.w("SendOrder","sent");
            s.shutdownOutput();

            oos.close();
            s.close();



        }catch (IOException exc){

        }

    }


}
