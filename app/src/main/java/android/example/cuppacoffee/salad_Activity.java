package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.example.cuppacoffee.Adapters.MainAdapter;
import android.example.cuppacoffee.Models.MainModel;
import android.example.cuppacoffee.databinding.ActivityBurgerBinding;
import android.example.cuppacoffee.databinding.ActivitySaladBinding;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class salad_Activity extends AppCompatActivity {

    @NonNull
    ActivitySaladBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaladBinding.inflate(getLayoutInflater());

        //setContentView(R.layout.activity_burger_);
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.egg_salad, "Egg Salad","80","Our extra special cheezy veg burger!"));
        list.add(new MainModel(R.drawable.vegetable_salad, "Vegetable Salad","60","Healthy Veg burger!"));
        list.add(new MainModel(R.drawable.spinach_salad, "Spinach Salad","70","Cheezy veg burger!"));
        list.add(new MainModel(R.drawable.strawberry_salad, "Strawberry Salad","100","Sale ends on Sunday!"));
        list.add(new MainModel(R.drawable.watermelon_salad, "Watermelon Salad","60","Cheezy chicken burger!"));
        list.add(new MainModel(R.drawable.pasta_salad, "Pasta Salad","120","Spicy chilli veg burger!"));

        MainAdapter adapter= new MainAdapter(list,this);
        binding.recyclerviewsalad.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.recyclerviewsalad.setLayoutManager(layoutManager);

    }

}