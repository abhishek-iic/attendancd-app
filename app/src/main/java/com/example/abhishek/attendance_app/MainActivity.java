package com.example.abhishek.attendance_app;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmailLogin;
    private EditText editTextPasswordLogin;
    private Button login_btn;

    private ProgressDialog progressDialog;
    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_page);
        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        //if getCurrentUser does not returns null
        if(firebaseAuth.getCurrentUser() != null){
            //that means user is already logged in
            //so clos}+


            //and open profile activity
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }
        editTextEmailLogin=(EditText)findViewById(R.id.editTextEmailLogin);
        editTextPasswordLogin=(EditText)findViewById(R.id.editTextPasswordLogin);
        login_btn=(Button)findViewById(R.id.login_btn);
        progressDialog = new ProgressDialog(this);
        //attaching listener to button
        login_btn.setOnClickListener(this);
    }
    /*
    private void userlogin(){
        String email=editTextEmailLogin.getText().toString().trim();
        String password = editTextPasswordLogin.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }


        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,new OnCompleteListener<AuthResult>(){
                public void onComplete(@NonNull Task<AuthResult> task){
                    if(task.isSuccessful()){
                        finish();
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                    }
                }
                });

    }
*/
    public  void onClick(View view){


        startActivity(new Intent(this,ProfileActivity.class));
    }

    public void create_new_user(View view){
        Intent intent=new Intent(this,signup_activity.class);
        startActivity(intent);
    }
}