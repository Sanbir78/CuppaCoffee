package android.example.cuppacoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class logout_Activity extends AppCompatActivity {
         private Button home;
         private Button logout;
         FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_);
        home=(Button)findViewById(R.id.back_home);
        logout=(Button)findViewById(R.id.log_out);
        mAuth= FirebaseAuth.getInstance();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                //finish();
                startActivity(new Intent(logout_Activity.this,MainActivity.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(logout_Activity.this,OrderPage_Activity.class));
            }
        });
    }
}