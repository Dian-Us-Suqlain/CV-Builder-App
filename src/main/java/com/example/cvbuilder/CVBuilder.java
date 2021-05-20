package com.example.cvbuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CVBuilder extends AppCompatActivity {

    EditText etEmail, etPassword, etUsername, etPhone, etAddress, etWorkerAbout,
            etInstitute, etDegree, etMajor1, etMajor2, etMajor3,
            etProject1, etProject2, etProject1Desc, etProject2Desc,
            etAreaOfInterest, etAreaOfInterestDesc, etKeySkill1, etKeySkill2, etKeySkill3;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_builder);

        init();
    }

    void init(){
        etEmail =        findViewById(R.id.et_email);
        etPassword =     findViewById(R.id.et_password);
        etUsername =     findViewById(R.id.et_name);
        etPhone =        findViewById(R.id.et_phone);
        etWorkerAbout =  findViewById(R.id.et_about);
        etAddress =      findViewById(R.id.et_home_address);
        etInstitute =    findViewById(R.id.et_institute_name);
        etDegree =       findViewById(R.id.et_degree);
        etMajor1 =       findViewById(R.id.et_course1);
        etMajor2 =       findViewById(R.id.et_course2);
        etMajor3 =       findViewById(R.id.et_course3);
        etProject1 =     findViewById(R.id.et_project1);
        etProject2 =     findViewById(R.id.et_project2);
        etProject1Desc = findViewById(R.id.et_project1_description);
        etProject2Desc = findViewById(R.id.et_project2_description);
        etAreaOfInterest =     findViewById(R.id.et_area_of_interest);
        etAreaOfInterestDesc = findViewById(R.id.et_area_of_interest_description);
        etKeySkill1 =   findViewById(R.id.et_key_skill01);
        etKeySkill2 =  findViewById(R.id.et_key_skill02);
        etKeySkill3 =   findViewById(R.id.et_key_skill03);
    }

    public void GenerateCV(View view){
        String username =    etUsername.getText().toString().trim();
        String workerAbout = etWorkerAbout.getText().toString().trim();
        String phone =       etPhone.getText().toString().trim();
        String email =       etEmail.getText().toString().trim();
        String password =    etPassword.getText().toString().trim();
        String address =     etAddress.getText().toString().trim();

        String institute = etInstitute.getText().toString().trim();
        String degree =    etDegree.getText().toString().trim();
        String major1 =    etMajor1.getText().toString().trim();
        String major2 =    etMajor2.getText().toString().trim();
        String major3 =    etMajor3.getText().toString().trim();

        String project1 =     etProject1.getText().toString().trim();
        String project2 =     etProject2.getText().toString().trim();
        String project1Desc = etProject1Desc.getText().toString().trim();
        String project2Desc = etProject2Desc.getText().toString().trim();

        String areaOfInterest =     etAreaOfInterest.getText().toString().trim();
        String areaOfInterestDesc = etAreaOfInterestDesc.getText().toString().trim();

        String keySkill1 = etKeySkill1.getText().toString().trim();
        String keySkill2 = etKeySkill2.getText().toString().trim();
        String keySkill3 = etKeySkill3.getText().toString().trim();

        //boolean flag = true;

        /*if(username.isEmpty() || workerAbout.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() || address.isEmpty() ||
                institute.isEmpty() || degree.isEmpty() || major1.isEmpty() || major2.isEmpty() || major3.isEmpty() ||
                project1.isEmpty() || project1Desc.isEmpty() || project2.isEmpty() || project2Desc.isEmpty() ||
                areaOfInterest.isEmpty() || areaOfInterestDesc.isEmpty() ||
                keySkill1.isEmpty() || keySkill2.isEmpty() || keySkill3.isEmpty()){
            flag = false;
            Toast.makeText(this, "Enter details first", Toast.LENGTH_SHORT).show();
        }*/

        //if(flag){
        auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(CVBuilder.this, "New user created", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(CVBuilder.this, "Error!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("Worker");
        String id = mRef.push().getKey();  // This will create a unique key in firebase every single time

        Worker worker = new Worker(username, workerAbout, phone, email, address, institute, degree, major1, major2, major3,
                project1, project2, project1Desc, project2Desc, areaOfInterest, areaOfInterestDesc, keySkill1, keySkill2, keySkill3);

        assert id != null;
        mRef.child(id).setValue(worker);
        Toast.makeText(this, "New Worker added", Toast.LENGTH_SHORT).show();

        finish();
        //}
        }
}
