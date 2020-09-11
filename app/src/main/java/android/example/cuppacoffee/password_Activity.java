package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class password_Activity extends AppCompatActivity {
       private EditText enteremail;
       private Button newpass;
       private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_);

        enteremail=(EditText)findViewById(R.id.enter_email);
        newpass=(Button)findViewById(R.id.new_password);

        firebaseAuth=FirebaseAuth.getInstance();
        newpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail= enteremail.getText().toString().trim();
                if (useremail.equals("")){
                    Toast.makeText(password_Activity.this,"Please enter your registered email ID",Toast.LENGTH_SHORT).show();
                }else{
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(password_Activity.this,"Password reset email send!",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(password_Activity.this,Signin_Activity.class));
                            }else
                            {
                                Toast.makeText(password_Activity.this,"Error in sending password reset email",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}