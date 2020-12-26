package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.example.cuppacoffee.Adapters.MainAdapter;
import android.example.cuppacoffee.Models.MainModel;
import android.example.cuppacoffee.databinding.ActivityBurgerBinding;
import android.example.cuppacoffee.databinding.ActivityPastryBinding;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class pastry_Activity extends AppCompatActivity {

    @NonNull
    ActivityPastryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPastryBinding.inflate(getLayoutInflater());

        //setContentView(R.layout.activity_burger_);
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.chocolate_pastry, "Chocolate Pastry","100","Our extra special cheezy veg burger!"));
        list.add(new MainModel(R.drawable.cheese_pastry, "Cheese Pastry","80","Healthy Veg burger!"));
        list.add(new MainModel(R.drawable.blackforest_pastry, "Black Forest Pastry","120","Cheezy veg burger!"));
        list.add(new MainModel(R.drawable.redvelvet_pastry, "Red Velvet Pastry","100","Sale ends on Sunday!"));
        list.add(new MainModel(R.drawable.banana_pastry, "Banana Pastry","60","Cheezy chicken burger!"));
        list.add(new MainModel(R.drawable.puff_pastry, "Puff Pastry","60","Spicy chilli veg burger!"));

        MainAdapter adapter= new MainAdapter(list,this);
        binding.recyclerviewpatry.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.recyclerviewpatry.setLayoutManager(layoutManager);




    }
}