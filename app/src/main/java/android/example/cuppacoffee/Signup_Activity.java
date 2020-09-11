package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Signup_Activity extends AppCompatActivity {

    private EditText userPassword;
    private EditText userEmail;
    EditText userName;
    private Button userRegis;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_);

        setupUIViews();
        firebaseAuth = FirebaseAuth.getInstance();
       // FirebaseUser user= firebaseAuth.getCurrentUser();


        userRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email=userEmail.getText().toString();
                String user_password=userPassword.getText().toString();
                if (user_email.isEmpty() && user_password.isEmpty()){
                    Toast.makeText(Signup_Activity.this,"Feilds are Empty!",Toast.LENGTH_SHORT).show();
                }
                else if (user_password.isEmpty()){
                    userPassword.setError("Please enter your password");
                    userPassword.requestFocus();
                }
                else if (user_email.isEmpty())
                {
                    userEmail.setError("Please enter email id");
                    userEmail.requestFocus();
                }
                else
                {
                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(Signup_Activity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Signup_Activity.this,"SignUp Unsuccessful,Please try later!",Toast.LENGTH_SHORT).show();
                            } else {
                                sendEmailVerification();
                            }
                        }
                    });
                }
            }
        });
   userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup_Activity.this,Signin_Activity.class));
            }
        });
    }

    private void setupUIViews(){
        userName = (EditText) findViewById(R.id.edituser);
        userEmail= (EditText)findViewById(R.id.edituseremail);
        userPassword=(EditText)findViewById(R.id.edituserpass) ;
        userRegis =(Button) findViewById(R.id.buttonregister);
        userLogin= (TextView)findViewById(R.id.textView101);
    }

    private void sendEmailVerification(){
        final FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Signup_Activity.this,"Successfully Registered, Verification mail sent!",Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(Signup_Activity.this,Signin_Activity.class));
                    }else {
                        Toast.makeText(Signup_Activity.this,"Verification mail has'nt been sent! Please try again later.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}