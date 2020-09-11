package android.example.cuppacoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class shakes_Activity extends AppCompatActivity {
    ListView lst;
    Integer[] images = {R.drawable.strawberry_shake, R.drawable.cream_shake, R.drawable.blueberry_shake, R.drawable.chocolate_shake, R.drawable.vanilla_shake, R.drawable.brownie_shake};
    String[] names = {"Strawberry Shake", "Cream Shake", "Bluberry Shake", "Chocolate Shake", "Vanilla Shake", "Brownie Shake"};
    String[] prices = {"₹120", "₹120", "₹170", "₹220", "₹120", "₹235"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shakes_);
        lst = (ListView) findViewById(R.id.shakes_list);
        CustomListView customListView = new CustomListView(this, names, prices, images);
        lst.setAdapter(customListView);
    }
}