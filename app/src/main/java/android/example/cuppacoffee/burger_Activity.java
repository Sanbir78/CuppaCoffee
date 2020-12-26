package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.example.cuppacoffee.Adapters.MainAdapter;
import android.example.cuppacoffee.Models.MainModel;
import android.example.cuppacoffee.databinding.ActivityBurgerBinding;
import android.example.cuppacoffee.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class burger_Activity extends AppCompatActivity {

    @NonNull ActivityBurgerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBurgerBinding.inflate(getLayoutInflater());

        //setContentView(R.layout.activity_burger_);
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.special_burger, "Our special","250","Our extra special cheezy veg burger!"));
        list.add(new MainModel(R.drawable.veggie_burger, "Veg Burger","80","Healthy Veg burger!"));
        list.add(new MainModel(R.drawable.cheese_burger, "Cheese burger","120","Cheezy veg burger!"));
        list.add(new MainModel(R.drawable.ham_burger, "Pizza burger","25","Sale ends on Sunday!"));
        list.add(new MainModel(R.drawable.beef_burger, "Chicken Burger","170","Cheezy chicken burger!"));
        list.add(new MainModel(R.drawable.chili_burger, "Chilli Burger","100","Spicy chilli veg burger!"));

        MainAdapter adapter= new MainAdapter(list,this);
        binding.recyclerviewburger.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.recyclerviewburger.setLayoutManager(layoutManager);


    }
}