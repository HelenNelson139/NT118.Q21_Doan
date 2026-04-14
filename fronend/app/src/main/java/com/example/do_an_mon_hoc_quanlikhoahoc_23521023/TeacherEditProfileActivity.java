package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class TeacherEditProfileActivity extends AppCompatActivity {

    private EditText edtName, edtEmail, edtPhone, edtDOB, edtAddress;
    private Spinner spinnerGender;
    private MaterialButton btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        edtDOB = findViewById(R.id.edtDOB);
        edtAddress = findViewById(R.id.edtAddress);
        spinnerGender = findViewById(R.id.spinnerGender);
        btnSave = findViewById(R.id.btnSave);

        String[] genders = {"Nam", "Nữ", "Khác"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genders);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter);

        Intent intent = getIntent();
        if (intent != null) {
            edtName.setText(intent.getStringExtra("name"));
            edtEmail.setText(intent.getStringExtra("email"));
            edtPhone.setText(intent.getStringExtra("phone"));
            edtDOB.setText(intent.getStringExtra("dob"));
            edtAddress.setText(intent.getStringExtra("address"));

            String gender = intent.getStringExtra("gender");
            if (gender != null) {
                int pos = adapter.getPosition(gender);
                spinnerGender.setSelection(pos);
            }
        }

        btnSave.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", edtName.getText().toString());
            resultIntent.putExtra("email", edtEmail.getText().toString());
            resultIntent.putExtra("phone", edtPhone.getText().toString());
            resultIntent.putExtra("dob", edtDOB.getText().toString());
            resultIntent.putExtra("address", edtAddress.getText().toString());
            resultIntent.putExtra("gender", spinnerGender.getSelectedItem().toString());
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}