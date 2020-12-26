package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.example.cuppacoffee.Adapters.MainAdapter;
import android.example.cuppacoffee.Models.MainModel;
import android.example.cuppacoffee.databinding.ActivityBurgerBinding;
import android.example.cuppacoffee.databinding.ActivityCoffeeBinding;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class coffee_Activity extends AppCompatActivity {

    @NonNull
    ActivityCoffeeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCoffeeBinding.inflate(getLayoutInflater());

        //setContentView(R.layout.activity_burger_);
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.cappuccino_coffee, "Cappuccino","190","Our extra special cheezy veg burger!"));
        list.add(new MainModel(R.drawable.black_coffee, "Black Coffee","130","Healthy Veg burger!"));
        list.add(new MainModel(R.drawable.latte_cffee, "Latte","170","Cheezy veg burger!"));
        list.add(new MainModel(R.drawable.espresso_cofee, "Espresso","160","Sale ends on Sunday!"));
        list.add(new MainModel(R.drawable.americano_coffee, "Americano","210","Cheezy chicken burger!"));
        list.add(new MainModel(R.drawable.flatwhite_coffe, "Flat White","140","Spicy chilli veg burger!"));
        list.add(new MainModel(R.drawable.cold_coffee, "Cold Coffee","150","Spicy chilli veg burger!"));
        MainAdapter adapter= new MainAdapter(list,this);
        binding.recyclerviewcoffee.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.recyclerviewcoffee.setLayoutManager(layoutManager);




    }

}