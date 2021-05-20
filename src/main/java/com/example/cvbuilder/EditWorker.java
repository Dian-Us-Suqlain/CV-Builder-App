package com.example.cvbuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EditWorker extends AppCompatActivity {

    Button btnUpdate;
    EditText etDialogWorkerName, etDialogWorkerPhone, etDialogWorkerAddress, etDialogProject1,
            etDialogProject1Desc, etDialogProject2, etDialogProject2Desc, etDialogAreaOfInterest, etDialogAreaOfInterestDesc,
            etDialogKeySkill1, etDialogKeySkill2, etDialogKeySkill3;
    Worker worker;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_worker);

        etDialogWorkerName =     findViewById(R.id.et_dialog_name);
        etDialogWorkerPhone =    findViewById(R.id.et_dialog_phone);
        etDialogWorkerAddress =  findViewById(R.id.et_dialog_address);
        etDialogProject1 =       findViewById(R.id.et_dialog_project1);
        etDialogProject1Desc =   findViewById(R.id.et_dialog_project1_desc);
        etDialogProject2 =       findViewById(R.id.et_dialog_project2);
        etDialogProject2Desc =   findViewById(R.id.et_dialog_project2_desc);
        etDialogAreaOfInterest =     findViewById(R.id.et_dialog_area_of_interest);
        etDialogAreaOfInterestDesc = findViewById(R.id.et_dialog_desc_area);
        etDialogKeySkill1 =   findViewById(R.id.et_dialog_keyskill1);
        etDialogKeySkill2 =   findViewById(R.id.et_dialog_keyskill2);
        etDialogKeySkill3 =   findViewById(R.id.et_dialog_keyskill3);

        btnUpdate = findViewById(R.id.btn_update_worker);

        btnUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Map<String, Object> map = new HashMap<>();
                map.put("username", etDialogWorkerName.getText().toString());
                map.put("phone", etDialogWorkerPhone.getText().toString());
                map.put("address", etDialogWorkerAddress.getText().toString());
                map.put("project1", etDialogProject1.getText().toString());
                map.put("project1Desc", etDialogProject1Desc.getText().toString());
                map.put("project2", etDialogProject2.getText().toString());
                map.put("project2Desc", etDialogProject2Desc.getText().toString());
                map.put("areaOfInterest", etDialogAreaOfInterest.getText().toString());
                map.put("getAreaOfInterestDesc", etDialogAreaOfInterestDesc.getText().toString());
                map.put("keySkill1", etDialogKeySkill1.getText().toString());
                map.put("keySkill2", etDialogKeySkill2.getText().toString());
                map.put("keySkill3", etDialogKeySkill3.getText().toString());

                FirebaseDatabase.getInstance().getReference("Worker")
                        .child(mRef.getKey())
                        .updateChildren(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(EditWorker.this, "Worker's CV has been updated", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}

