package android.example.cuppacoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class Signin_Activity extends AppCompatActivity {
    private static int  RC_SIGN_IN = 123;

    private EditText userNam;
     private  EditText userPass;
    private  FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    private Button signing;
     private TextView userRegister;
    private TextView forgotpass;
    @Override
     protected void onStart() {
        super.onStart();

        FirebaseUser usered= mAuth.getCurrentUser();
        if(usered!=null){
            Intent intent=new Intent(getApplicationContext(),OrderPage_Activity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_);
         userNam = (EditText) findViewById(R.id.editemail);
         userPass = (EditText) findViewById(R.id.editpassword);
          signing = (Button) findViewById(R.id.buttonsigng);
           userRegister = (TextView) findViewById(R.id.textView102);
           forgotpass = (TextView) findViewById(R.id.forgot_pass);
           mAuth= FirebaseAuth.getInstance();
          firebaseAuth=FirebaseAuth.getInstance();

        progressDialog=new ProgressDialog(this);



        signing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(userNam.getText().toString(),userPass.getText().toString());
            }
        });

        GoogleSignInOptions goo=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient= GoogleSignIn.getClient(this, goo);

        findViewById(R.id.google).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        userRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signin_Activity.this,Signup_Activity.class));
            }
        });
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signin_Activity.this,password_Activity.class));
            }
        });

    }


    private void validate (String userName, String userPassword)
     {
         progressDialog.setMessage("Hey, What about making your mind up about what to eat until login is successful");
        progressDialog.show();
         firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if (task.isSuccessful()){
                     progressDialog.dismiss();
                     checkEmailVerification();
                 }
                 else {
                     Toast.makeText(Signin_Activity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                 }
             }
         });

     }

  private void checkEmailVerification(){
        FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
      assert firebaseUser != null;
      boolean email= firebaseUser.isEmailVerified();
        if(email){
            startActivity(new Intent(Signin_Activity.this,OrderPage_Activity.class));
        }
        else{
            Toast.makeText(Signin_Activity.this,"Verify your Email !",Toast.LENGTH_SHORT).show();
            FirebaseAuth.getInstance().signOut();
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                assert account != null;
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(Signin_Activity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                // ...
            }
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acc) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acc.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Signin_Activity.this, "User Signed In", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),OrderPage_Activity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Signin_Activity.this,"Sorry authentication failed!",Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
    private void signIn(){
        Intent signInIntent =mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }

}

