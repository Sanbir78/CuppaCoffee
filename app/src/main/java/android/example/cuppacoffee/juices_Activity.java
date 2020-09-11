package android.example.cuppacoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class juices_Activity extends AppCompatActivity {
    ListView lst;
    Integer[] images = {R.drawable.lemon_juice, R.drawable.apple_juice, R.drawable.canberry_juice, R.drawable.beetroot_juice, R.drawable.strawberry_juice, R.drawable.orange_juice};
    String[] names = {"Lemon Juice", "Apple Juice", "Canberry Juice", "Beetroot Juice", "Strawberry Juice", "Orange Juice"};
    String[] prices =  {"₹30", "₹150", "₹180", "₹170", "₹90", "₹60"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juices_);
        lst = (ListView) findViewById(R.id.juices_list);
        CustomListView customListView = new CustomListView(this, names, prices, images);
        lst.setAdapter(customListView);
    }
}