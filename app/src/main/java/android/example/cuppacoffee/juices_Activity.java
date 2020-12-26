package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.example.cuppacoffee.Adapters.MainAdapter;
import android.example.cuppacoffee.Models.MainModel;
import android.example.cuppacoffee.databinding.ActivityBurgerBinding;
import android.example.cuppacoffee.databinding.ActivityJuicesBinding;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class juices_Activity extends AppCompatActivity {

    @NonNull
    ActivityJuicesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJuicesBinding.inflate(getLayoutInflater());

        //setContentView(R.layout.activity_burger_);
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.lemon_juice, "Lemon Juice","15","Our extra special cheezy veg burger!"));
        list.add(new MainModel(R.drawable.apple_juice, "Apple Juice","70","Healthy Veg burger!"));
        list.add(new MainModel(R.drawable.orange_juice, "Orange Juice ","30","Cheezy veg burger!"));
        list.add(new MainModel(R.drawable.beetroot_juice, "Beetroot Juice","60","Sale ends on Sunday!"));
        list.add(new MainModel(R.drawable.strawberry_juice, "Strawberry Juice","25","Cheezy chicken burger!"));
        list.add(new MainModel(R.drawable.canberry_juice, "Canberry Juice","100","Spicy chilli veg burger!"));

        MainAdapter adapter= new MainAdapter(list,this);
        binding.recyclerviewjuices.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.recyclerviewjuices.setLayoutManager(layoutManager);




    }

}