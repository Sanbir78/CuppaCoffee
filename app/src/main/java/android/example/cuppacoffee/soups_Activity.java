package android.example.cuppacoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class soups_Activity extends AppCompatActivity {
    ListView lst;
    Integer[] images = {R.drawable.potato_soup, R.drawable.tomato_soup, R.drawable.soup_icon, R.drawable.noodles_soup, R.drawable.squid_soup, R.drawable.shrimp_soup};
    String[] names = {"Potato Soup", "Tomato Soup", "Beef Soup", "Noodles Soup", "Squid Soup", "Shrimp Soup"};
    String[] prices =  {"₹180", "₹180", "₹320", "₹240", "₹240", "₹370"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soups_);
        lst = (ListView) findViewById(R.id.soups_list);
        CustomListView customListView = new CustomListView(this, names, prices, images);
        lst.setAdapter(customListView);
    }
}