package android.example.cuppacoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class salad_Activity extends AppCompatActivity {
    ListView lst;
    Integer[] images = {R.drawable.egg_salad, R.drawable.spinach_salad, R.drawable.pasta_salad, R.drawable.strawberry_salad, R.drawable.watermelon_salad, R.drawable.vegetable_salad};
    String[] names = {"Egg Salad", "Spinach Salad", "Pasta Salad", "Strawberry Salad", "Watermelon Salad", "Vegetable Salad"};
    String[] prices = {"₹210", "₹160", "₹260", "₹240", "₹140", "₹190"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad_);
        lst = (ListView) findViewById(R.id.salad_list);
        CustomListView customListView = new CustomListView(this, names, prices, images);
        lst.setAdapter(customListView);
    }
}