package com.example.cvbuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class WorkerAuthentication extends AppCompatActivity {

    EditText etEmail, etPassword;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_authentication);

        init();
    }

    void init(){
        etEmail = findViewById(R.id.et_email_verify);
        etPassword = findViewById(R.id.et_password_verify);
    }

    public void VerifyUser(View view){
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please enter your login details first", Toast.LENGTH_SHORT).show();
        }
        else{
            auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(WorkerAuthentication.this, EditWorker.class));
                            }
                            else{
                                Toast.makeText(WorkerAuthentication.this, "Wrong Password or Email", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}
