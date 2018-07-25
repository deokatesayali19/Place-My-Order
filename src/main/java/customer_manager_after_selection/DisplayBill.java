package customer_manager_after_selection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sayali.placemyorder.MainActivity;
import com.example.sayali.placemyorder.R;

import java.util.ArrayList;
import java.util.Vector;

import dbClasses.QuantifiedList;

import static customer_manager_after_selection.MainSelectedItems.total;

public class DisplayBill extends AppCompatActivity {
    TextView t;
    TextView e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_bill);

        ArrayList<QuantifiedList> l=new ArrayList<QuantifiedList>();
        l=(ArrayList<QuantifiedList>) getIntent().getSerializableExtra("FinalOrder");
        Vector<QuantifiedList> a=new Vector<QuantifiedList>(l);
        Log.d("Total Bill:",Integer.toString(total));
        t=(TextView) findViewById(R.id.label);
        e=(TextView) findViewById(R.id.value);
        e.setText(Integer.toString(total));
        String tableString= MainActivity.result.substring(1,3);
        SendOrder o=new SendOrder(DisplayBill.this,total,Integer.parseInt(tableString),a);
        Toast.makeText(DisplayBill.this,"ORDER PLACED SUCCESSFULLY!!!",Toast.LENGTH_LONG);

    }
}
