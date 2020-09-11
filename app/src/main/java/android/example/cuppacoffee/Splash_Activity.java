package android.example.cuppacoffee;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);
        Thread background = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent= new Intent(Splash_Activity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        background.start();
    }
}