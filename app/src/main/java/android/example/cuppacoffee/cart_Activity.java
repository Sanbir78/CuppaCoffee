package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.example.cuppacoffee.Adapters.MainAdapter;
import android.example.cuppacoffee.Adapters.OrdersAdapter;
import android.example.cuppacoffee.Models.MainModel;
import android.example.cuppacoffee.Models.OrdersModel;
import android.example.cuppacoffee.databinding.ActivityCartBinding;
import android.example.cuppacoffee.databinding.ActivityCoffeeBinding;
import android.os.Bundle;

import java.util.ArrayList;

public class cart_Activity extends AppCompatActivity {

    @NonNull
    ActivityCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());

        //setContentView(R.layout.activity_burger_);
        setContentView(binding.getRoot());

        DBHelper helper=new DBHelper(this);
        ArrayList<OrdersModel> list=helper.getOrders();

        OrdersAdapter adapter = new OrdersAdapter( list, this);
        binding.recyclerviewcart.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerviewcart.setLayoutManager(layoutManager);
    }
}
