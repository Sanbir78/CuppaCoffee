package android.example.cuppacoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class pastry_Activity extends AppCompatActivity {
    ListView lst;
    Integer[] images = {R.drawable.chocolate_pastry, R.drawable.cheese_pastry, R.drawable.blackforest_pastry, R.drawable.redvelvet_pastry, R.drawable.banana_pastry, R.drawable.puff_pastry};
    String[] names = {"Chocolate Pastry", "Cheese Pastry", "Blackforest Pastry", "Redvelvet Pastry", "Banana Pastry", "Puff Pastry"};
    String[] prices = {"₹160", "₹140", "₹270", "₹240", "₹120", "₹310"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastry_);
        lst = (ListView) findViewById(R.id.pastry_list);
        CustomListView customListView = new CustomListView(this, names, prices, images);
        lst.setAdapter(customListView);
    }
}