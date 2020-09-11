package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class OrderPage_Activity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView tea, burger, salad, soup, juices, shakes, coffee, pastry;
    TextView tea_t, coffee_t, burger_t, salad_t, shakes_t, pastry_t, juices_t, soup_t;
    private Object OrderPage_Activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page_);



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
                                                                     case R.id.fav_page:
                                                                         Intent a = new Intent(OrderPage_Activity.this, fav_Activity.class);
                                                                         startActivity(a);
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
}


