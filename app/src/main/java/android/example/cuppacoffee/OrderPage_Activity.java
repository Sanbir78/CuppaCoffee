package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.example.cuppacoffee.Adapters.MainAdapter;
import android.example.cuppacoffee.Models.MainModel;
import android.example.cuppacoffee.databinding.ActivityOrderPageBinding;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class OrderPage_Activity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView tea, burger, salad, soup, juices, shakes, coffee, pastry;
    TextView tea_t, coffee_t, burger_t, salad_t, shakes_t, pastry_t, juices_t, soup_t;
    private Object OrderPage_Activity;
    RecyclerView datalist;
    List<String>titles;
    List<Integer>images;
     GridAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page_);
      /* datalist=findViewById(R.id.datalist);

        titles=new ArrayList<>();
        images=new ArrayList<>();
        titles.add("Tea");
        titles.add("Coffee");
        titles.add("Burgers");
        titles.add("Salad");
        titles.add("Shakes");
        titles.add("Juices");
        titles.add("Soups");
        titles.add("Pastries");
        images.add(R.drawable.tea_im);
        images.add(R.drawable.cofee_im);
        images.add(R.drawable.burger_im);
        images.add(R.drawable.salads_icon);
        images.add(R.drawable.shak_im);
        images.add(R.drawable.juice_im);
        images.add(R.drawable.soup_im);
        images.add(R.drawable.pastry_im);

        adapter=new GridAdapter(this,titles,images);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        datalist.setLayoutManager(gridLayoutManager);
        datalist.setAdapter(adapter);
*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                                                             @Override
                                                             public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                                                                 switch (menuItem.getItemId()) {
                                                                     case R.id.home_page:
                                                                         drawerLayout.closeDrawer(GravityCompat.START);
                                                                         break;
                                                                     case R.id.about_us:
                                                                         Intent intent = new Intent(OrderPage_Activity.this, AboutUs_Activity.class);
                                                                         startActivity(intent);
                                                                         break;
                                                                     case R.id.cart_page:
                                                                         Intent b = new Intent(OrderPage_Activity.this, cart_Activity.class);
                                                                         startActivity(b);
                                                                         break;

                                                                     case R.id.logout_page:
                                                                         Intent i = new Intent(OrderPage_Activity.this, logout_Activity.class);
                                                                         startActivity(i);
                                                                         break;
                                                                 }
                                                                 return true;
                                                             }
                                                         });


       setupUIViews();

        tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, tea_Activity.class);
                startActivity(intent);
            }
        });
        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, coffee_Activity.class);
                startActivity(intent);
            }
        });
        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, burger_Activity.class);
                startActivity(intent);
            }
        });
        juices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, juices_Activity.class);
                startActivity(intent);
            }
        });
        salad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, salad_Activity.class);
                startActivity(intent);
            }
        });
        shakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, shakes_Activity.class);
                startActivity(intent);
            }
        });
        soup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, soups_Activity.class);
                startActivity(intent);
            }
        });
        pastry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, pastry_Activity.class);
                startActivity(intent);
            }
        });
        tea_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, tea_Activity.class);
                startActivity(intent);
            }
        });
        coffee_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, coffee_Activity.class);
                startActivity(intent);
            }
        });
        burger_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, burger_Activity.class);
                startActivity(intent);
            }
        });
        juices_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, juices_Activity.class);
                startActivity(intent);
            }
        });
        salad_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, salad_Activity.class);
                startActivity(intent);
            }
        });
        shakes_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, shakes_Activity.class);
                startActivity(intent);
            }
        });
        soup_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, soups_Activity.class);
                startActivity(intent);
            }
        });
        pastry_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPage_Activity.this, pastry_Activity.class);
                startActivity(intent);
            }
        });
    }

  private void setupUIViews() {
        tea = (ImageView) findViewById(R.id.button_tea);
        coffee = (ImageView) findViewById(R.id.button_coffee);
        burger = (ImageView) findViewById(R.id.button_burger);
        salad = (ImageView) findViewById(R.id.button_salad);
        juices = (ImageView) findViewById(R.id.button_juice);
        shakes = (ImageView) findViewById(R.id.button_shake);
        soup = (ImageView) findViewById(R.id.button_soup);
        pastry = (ImageView) findViewById(R.id.button_pastry);
        tea_t = (TextView) findViewById(R.id.tea);
        coffee_t = (TextView) findViewById(R.id.coffee);
        burger_t = (TextView) findViewById(R.id.burgers);
        salad_t = (TextView) findViewById(R.id.salad);
        juices_t = (TextView) findViewById(R.id.juices);
        shakes_t = (TextView) findViewById(R.id.shakes);
        soup_t = (TextView) findViewById(R.id.soups);
        pastry_t = (TextView) findViewById(R.id.pastry);
    }
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_myorders, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.order_cart:
                startActivity(new Intent(OrderPage_Activity.this,cart_Activity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


