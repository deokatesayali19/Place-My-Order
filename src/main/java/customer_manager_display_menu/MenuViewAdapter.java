package customer_manager_display_menu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sayali.placemyorder.R;

import java.util.Vector;

import customer_manager_after_selection.ItemsReadyToOrder;
import dbClasses.Item;

public class MenuViewAdapter extends RecyclerView.Adapter<MenuRViewHolder> {
    public Vector<Item> itemList;
    public Vector<ItemsReadyToOrder> orderedList=new Vector<>();
    private Context context;
    MenuRViewHolder rcv;
    public MenuViewAdapter(){

    }

    public MenuViewAdapter(Context context,Vector<Item> i)
    {
        itemList=i;
        this.context=context;
    }

    @Override
    public  MenuRViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Log.d("MenuCard","Set card");
        View LayoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_card,parent,false);
        rcv= new MenuRViewHolder(LayoutView,itemList,orderedList);
        return rcv;
    }

    @Override
    public void onBindViewHolder(MenuRViewHolder holder, int position)
    {
        Log.d("inmenuHolder","items");
        holder.title.setText(itemList.get(position).getName());
        holder.description.setText(itemList.get(position).getDescription());
        holder.cost.setText(itemList.get(position).getCost()+" Rs");

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public Vector<ItemsReadyToOrder> getList(){
        //orderedList=rcv.returnList();
        return orderedList;
    }


}
