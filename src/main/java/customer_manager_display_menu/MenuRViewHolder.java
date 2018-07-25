package customer_manager_display_menu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sayali.placemyorder.R;
import java.util.Vector;

import customer_manager_after_selection.ItemsReadyToOrder;
import dbClasses.Item;


public class MenuRViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView title, description, cost;
    public Vector<ItemsReadyToOrder> orders=new Vector<>();
    public Vector<Item> menu;


    public MenuRViewHolder(View itemView, Vector<Item> items, Vector<ItemsReadyToOrder> order)
    {
        super(itemView);
        title=(TextView)itemView.findViewById(R.id.item_title);
        description=(TextView)itemView.findViewById(R.id.item_description);
        cost=(TextView)itemView.findViewById(R.id.item_cost);
        menu=items;
        orders=order;

        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int itemPosition=getAdapterPosition();
                Item i= menu.get(itemPosition);
                add(i,view);
                //Toast.makeText(vie w.getContext(),orders.get(itemPosition).getName(), Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void add(Item i, View view){
        orders.add(new ItemsReadyToOrder(i.getName(),Integer.parseInt(i.getCost())));

    }

   /* @Override
    public  void onClick(View view){


        //int itemPosition = (int) view.getTag();
        int itemPosition=getAdapterPosition();
        Item i= menu.get(itemPosition);
        orders.add(new ItemsReadyToOrder(i.getName(),Integer.parseInt(i.getCost())));
        Toast.makeText(view.getContext(),orders.get(0).getName(), Toast.LENGTH_SHORT).show();
    }*/

   /*public Vector<ItemsReadyToOrder> returnList(){
        return orders;
    }*/


}
