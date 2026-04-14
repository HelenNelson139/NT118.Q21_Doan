package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class TeacherProfileActivity extends AppCompatActivity {

    private TextView txtName, txtEmail, txtPhone, txtDOB, txtGender, txtAddress;
    private TextView txtRole, txtUserId, txtCourses, txtStatus;
    private MaterialButton btnEdit;

    private ActivityResultLauncher<Intent> editProfileLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        txtDOB = findViewById(R.id.txtDOB);
        txtGender = findViewById(R.id.txtGender);
        txtAddress = findViewById(R.id.txtAddress);

        txtRole = findViewById(R.id.txtRole);
        txtCourses = findViewById(R.id.txtCourses);
        txtStatus = findViewById(R.id.txtStatus);

        btnEdit = findViewById(R.id.btnEdit);
        showProfileData();

        editProfileLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Intent data = result.getData();

                        txtName.setText(data.getStringExtra("name"));
                        txtEmail.setText(data.getStringExtra("email"));
                        txtPhone.setText(data.getStringExtra("phone"));
                        txtDOB.setText(data.getStringExtra("dob"));
                        txtGender.setText(data.getStringExtra("gender"));
                        txtAddress.setText(data.getStringExtra("address"));
                    }
                }
        );

        btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(TeacherProfileActivity.this, TeacherEditProfileActivity.class);
            intent.putExtra("name", txtName.getText().toString());
            intent.putExtra("email", txtEmail.getText().toString());
            intent.putExtra("phone", txtPhone.getText().toString());
            intent.putExtra("dob", txtDOB.getText().toString());
            intent.putExtra("gender", txtGender.getText().toString());
            intent.putExtra("address", txtAddress.getText().toString());
            editProfileLauncher.launch(intent);
        });
    }

    private void showProfileData() {
        txtName.setText("Nguyễn Văn A");
        txtEmail.setText("email@example.com");
        txtPhone.setText("0123456789");
        txtDOB.setText("01/01/2000");
        txtGender.setText("Nam");
        txtAddress.setText("TP.HCM");

        txtRole.setText("Giảng viên");
        txtCourses.setText("5");
        txtStatus.setText("Đang hoạt động");
    }
}