package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.example.cuppacoffee.Adapters.MainAdapter;
import android.example.cuppacoffee.Models.MainModel;
import android.example.cuppacoffee.databinding.ActivityBurgerBinding;
import android.example.cuppacoffee.databinding.ActivityTeaBinding;
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

    @NonNull
    ActivityTeaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTeaBinding.inflate(getLayoutInflater());

        //setContentView(R.layout.activity_burger_);
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.green_tea, "Green Tea","50","Our extra special cheezy veg burger!"));
        list.add(new MainModel(R.drawable.black_tea, "Black Tea","20","Healthy Veg burger!"));
        list.add(new MainModel(R.drawable.white_tea, "White Tea","30","Cheezy veg burger!"));
        list.add(new MainModel(R.drawable.masala_tea, "Masala Tea","40","Sale ends on Sunday!"));
        list.add(new MainModel(R.drawable.oolong_tea, "Oolong Tea","70","Cheezy chicken burger!"));
        list.add(new MainModel(R.drawable.yellow_tea, "Yellow Tea","80","Spicy chilli veg burger!"));

        MainAdapter adapter= new MainAdapter(list,this);
        binding.recyclerviewtea.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.recyclerviewtea.setLayoutManager(layoutManager);




    }

}

