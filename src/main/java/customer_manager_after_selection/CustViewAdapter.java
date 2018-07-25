package customer_manager_after_selection;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sayali.placemyorder.R;
import java.util.Vector;

import dbClasses.QuantifiedList;

public class CustViewAdapter extends RecyclerView.Adapter<CustRViewHolder> {
    public static Vector<ItemsReadyToOrder> itemVector;
    public static Vector<QuantifiedList> quantifiedList=new Vector<QuantifiedList>();
    private Context context;

    public CustViewAdapter(Context context,Vector<ItemsReadyToOrder> i)
    {
        itemVector=i;
        this.context=context;
    }

    @Override
    public  CustRViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View LayoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cust_view,parent,false);
        CustRViewHolder rcv= new CustRViewHolder(LayoutView,quantifiedList);
        return rcv;
    }

    @Override
    public void onBindViewHolder(CustRViewHolder holder, int position)
    {
        holder.title.setText(itemVector.get(position).getName());
        int x=(itemVector.get(position).getPrice());
        holder.items_price.setText(Integer.toString(x));
    }

    @Override
    public int getItemCount() {
        return this.itemVector.size();
    }
    public Vector<QuantifiedList> getItemVector(){
        return quantifiedList;
    }
}
