package customer_manager_after_selection;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import com.example.sayali.placemyorder.R;

import java.util.ArrayList;
import java.util.Vector;

import dbClasses.Item;
import dbClasses.QuantifiedList;

public class MainSelectedItems extends AppCompatActivity{
    private LinearLayoutManager lLayout;
    RecyclerView rView;
    private FloatingActionButton f;
    public static  int total;
    public CustViewAdapter c;
    Spinner s;
    int x;
    Vector<Item> A=new Vector<>();
    ArrayList<ItemsReadyToOrder> l=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selected_items);


        f=(FloatingActionButton) findViewById(R.id.ok);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainSelectedItems.this,DisplayBill.class);
                Vector<QuantifiedList> q=new Vector<QuantifiedList>();
                q=c.getItemVector();
                Log.w("selected",Integer.toString(q.get(0).getQty()));
                Log.d("Total",Integer.toString(total));
                i.putExtra("FinalOrder",q);
                startActivity(i);
            }
        });

        lLayout = new LinearLayoutManager(MainSelectedItems.this);
        rView = (RecyclerView) findViewById(R.id.selectedList);
        rView.setLayoutManager(lLayout);




        l=(ArrayList<ItemsReadyToOrder>) getIntent().getSerializableExtra("FinalVector");
        Vector<ItemsReadyToOrder> a=new Vector<ItemsReadyToOrder>(l);
        Log.w("Mainselected",Integer.toString(total));
        c=new CustViewAdapter(MainSelectedItems.this, a);
        rView.setAdapter(c);
        int x=c.getItemCount();







    }



}
