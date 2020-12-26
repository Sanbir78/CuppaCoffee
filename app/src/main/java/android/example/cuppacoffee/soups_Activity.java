package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.example.cuppacoffee.Adapters.MainAdapter;
import android.example.cuppacoffee.Models.MainModel;
import android.example.cuppacoffee.databinding.ActivityBurgerBinding;
import android.example.cuppacoffee.databinding.ActivityCoffeeBinding;
import android.example.cuppacoffee.databinding.ActivitySoupsBinding;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class soups_Activity extends AppCompatActivity {

    ActivitySoupsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySoupsBinding.inflate(getLayoutInflater());

        //setContentView(R.layout.activity_burger_);
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.potato_soup, "Potato Soup", "40", "Our extra special cheezy veg burger!"));
        list.add(new MainModel(R.drawable.tomato_soup, "Tomato Soup", "60", "Healthy Veg burger!"));
        list.add(new MainModel(R.drawable.noodles_soup, "Noodles Soup", "130", "Sale ends on Sunday!"));
        list.add(new MainModel(R.drawable.shrimp_soup, "Shrimp Soup", "310", "Cheezy veg burger!"));
        list.add(new MainModel(R.drawable.squid_soup, "Squid Soup", "210", "Cheezy chicken burger!"));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerviewsoups.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerviewsoups.setLayoutManager(layoutManager);

    }
    }