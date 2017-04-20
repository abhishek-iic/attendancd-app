package com.example.abhishek.attendance_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import android.widget.Toast;
import android.text.TextUtils;
import android.app.ProgressDialog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.api.model.StringList;

/**
 * Created by abhishek on 14/4/17.
 */

public class signup_activity extends AppCompatActivity {
    //defining view objects
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignup;
    private ProgressDialog progressDialog;
    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();
        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSignup = (Button) findViewById(R.id.buttonSignup);
        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }


    /*protected void signing_up(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }*/

    private void registerUser() {
        //getting email and password from edit texts
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //checking if email and password are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        //if the email and password are not empty displaying a progress dialog
        progressDialog.setMessage("Registering Please wait...");
        progressDialog.show();


        //creating a user
        firebaseAuth.createUserWithEmailAndPassword("user email here", "user password here")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signup_activity.this, "Successfully registered", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(signup_activity.this, "Registration Error", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }


}