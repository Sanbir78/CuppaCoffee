package android.example.cuppacoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class burger_Activity extends AppCompatActivity {
    ListView lst;
    Integer[] images = {R.drawable.special_burger, R.drawable.ham_burger, R.drawable.beef_burger, R.drawable.veggie_burger, R.drawable.cheese_burger, R.drawable.chili_burger};
    String[] names = {"Our Special Burger", "Hamburger", "Beef Burger", "Veggie burger", "Cheese Burger", "Chili Burger"};
    String[] prices =  {"₹250", "₹150", "₹170", "₹80", "₹120", "₹100"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_);
        lst = (ListView) findViewById(R.id.burger_list);
        CustomListView customListView = new CustomListView(this, names, prices, images);
        lst.setAdapter(customListView);
    }
}