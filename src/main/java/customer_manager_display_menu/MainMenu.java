package customer_manager_display_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.FloatingActionButton;
import android.widget.Toast;
import com.example.sayali.placemyorder.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import customer_manager_after_selection.ItemsReadyToOrder;
import customer_manager_after_selection.MainSelectedItems;
import dbClasses.AppDatabase;
import dbClasses.Item;


public class MainMenu extends AppCompatActivity {
    public String menu;
    Button button;
    MenuViewAdapter m;
    private Item item;
    private AppDatabase database;
    public ArrayList<Item> l;

    RecyclerView rView;
    private LinearLayoutManager lLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        database=AppDatabase.getDatabase(getApplicationContext());

        lLayout = new LinearLayoutManager(MainMenu.this);
        rView = (RecyclerView) findViewById(R.id.mainList);
        rView.setLayoutManager(lLayout);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("FAB","fab clicked");
                Vector<ItemsReadyToOrder> l=new Vector<ItemsReadyToOrder>();
                l=m.getList();
                Intent intent=new Intent(MainMenu.this,MainSelectedItems.class);
                intent.putExtra("FinalVector",l);
                startActivity(intent);

            }
        });
        List<Item> x=database.itemDao().getAllItem();
        Vector<Item> d=new Vector<Item>(x);
        m=new MenuViewAdapter(MainMenu.this,d);
        rView.setAdapter(m);





    }

}
