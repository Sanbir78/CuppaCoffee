package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.example.cuppacoffee.Adapters.MainAdapter;
import android.example.cuppacoffee.Models.MainModel;
import android.example.cuppacoffee.databinding.ActivityBurgerBinding;
import android.example.cuppacoffee.databinding.ActivityShakesBinding;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class shakes_Activity extends AppCompatActivity {

    @NonNull
    ActivityShakesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShakesBinding.inflate(getLayoutInflater());

        //setContentView(R.layout.activity_burger_);
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.strawberry_shake, "Strawberry Shake","30","Our extra special cheezy veg burger!"));
        list.add(new MainModel(R.drawable.cream_shake, "Cream Shake","30","Healthy Veg burger!"));
        list.add(new MainModel(R.drawable.vanilla_shake, "Vanilla Shake","30","Cheezy veg burger!"));
        list.add(new MainModel(R.drawable.chocolate_shake, "Chocolate Shake","50","Sale ends on Sunday!"));
        list.add(new MainModel(R.drawable.brownie_shake, "Brownie Shake","80","Cheezy chicken burger!"));
        list.add(new MainModel(R.drawable.blueberry_shake, "Blueberry Shake","100","Spicy chilli veg burger!"));

        MainAdapter adapter= new MainAdapter(list,this);
        binding.recyclerviewshakes.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.recyclerviewshakes.setLayoutManager(layoutManager);




    }

}