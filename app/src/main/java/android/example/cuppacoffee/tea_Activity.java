package android.example.cuppacoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class tea_Activity extends AppCompatActivity {
    ListView lst;
    Integer[] images = {R.drawable.green_tea, R.drawable.black_tea, R.drawable.white_tea, R.drawable.masala_tea, R.drawable.oolong_tea, R.drawable.yellow_tea};
    String[] names = {"Green Tea", "Black Tea", "White Tea", "Masala Tea", "Oolong Tea", "Yellow Tea"};
    String[] prices = {"₹120", "₹70", "₹30", "₹50", "₹100", "₹80"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_);
        lst = findViewById(R.id.tea_list);
        CustomListView customListView = new CustomListView(this, names, prices, images);
        lst.setAdapter(customListView);

    }
}

