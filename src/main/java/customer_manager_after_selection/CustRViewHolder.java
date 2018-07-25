package customer_manager_after_selection;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sayali.placemyorder.R;

import java.util.Vector;

import dbClasses.QuantifiedList;

public class CustRViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView title, items_price;
    public Spinner spinner;
    public Vector<QuantifiedList> Qlist=new Vector<QuantifiedList>();
    public CustRViewHolder(View itemView, final Vector<QuantifiedList> Qlist)
    {
        super(itemView);
        this.Qlist=Qlist;
        itemView.setOnClickListener(this);
        title=(TextView) itemView.findViewById(R.id.ordered_item_name);
        items_price=(TextView)  itemView.findViewById(R.id.ordered_item_amount);
        spinner=(Spinner) itemView.findViewById(R.id.ordered_item_quantity);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String qty= adapterView.getItemAtPosition(i).toString();
                int q=Integer.parseInt(qty);
                String price=items_price.getText().toString();
                int p=Integer.parseInt(price);
                String name=title.getText().toString();
                int x=q*p;
                int dec=(p*(q-1));
                items_price.setText(Integer.toString(x));
                if(q>1) {
                    Qlist.add(new QuantifiedList(name, x, q));
                    MainSelectedItems.total=MainSelectedItems.total+(x-dec);
                }

                //MainSelectedItems.total=MainSelectedItems.total+(x-dec);
                else {
                    MainSelectedItems.total = x + MainSelectedItems.total;
                }
                Log.w("Holder",Integer.toString(q));
                Log.w("Holder",Integer.toString(MainSelectedItems.total));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    public  void onClick(View view){

    }

}
