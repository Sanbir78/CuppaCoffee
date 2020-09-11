package android.example.cuppacoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class coffee_Activity extends AppCompatActivity {
    ListView lst;
    Integer[] images = {R.drawable.cappuccino_coffee, R.drawable.black_coffee, R.drawable.latte_cffee, R.drawable.espresso_cofee, R.drawable.americano_coffee, R.drawable.flatwhite_coffe,R.drawable.cold_coffee};
    String[] names = {"Cappuccino", "Black Coffee", "Latte ", "Espresso", "Americano", "Flat White","Cold Coffee"};
    String[] prices = {"₹190", "₹130", "₹170", "₹160", "₹210", "₹140","₹150"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_);

        lst = (ListView) findViewById(R.id.coffee_list);
        CustomListView customListView = new CustomListView(this, names, prices, images);
        lst.setAdapter(customListView);
        // listview.setAdapter(new CustomAdapter());
    }
}