package android.example.cuppacoffee;

import android.app.ProgressDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity  extends AppCompatActivity {
    Button login;
    Button register;
    TextView skipit;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog =new ProgressDialog(this);
        login = (Button) findViewById(R.id.buttonLogin1);
        register = (Button) findViewById(R.id.buttonReg1);
        skipit = (TextView) findViewById(R.id.textView2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signin_Activity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Login has been clicked", Toast.LENGTH_SHORT).show();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup_Activity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "SignUp has been clicked", Toast.LENGTH_SHORT).show();
            }
        });
        skipit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Hey, Make your mind up about what to eat until login is successfull");
                progressDialog.show();
                Intent intent = new Intent(MainActivity.this, OrderPage_Activity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Welcome to Cuppa Coffee", Toast.LENGTH_SHORT).show();
            }
        });

    }

}