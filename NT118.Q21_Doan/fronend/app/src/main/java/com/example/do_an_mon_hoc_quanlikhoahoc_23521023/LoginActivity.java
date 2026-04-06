package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail, editPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Ánh xạ
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLoginSubmit);

        buttonLogin.setOnClickListener(v -> handleLogin());
    }

    private void handleLogin() {

        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        // Validate
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Email không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        sendLoginRequest(email, password);
    }

    private void sendLoginRequest(String email, String password) {

        String url = "API CSDL backend";

        StringRequest request = new StringRequest(Request.Method.POST, url,
                response -> {
                    // backend trả về OK
                    Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                    // chuyển sang màn chính (Home)
                    // startActivity(new Intent(this, HomeActivity.class));

                },
                error -> {
                    Toast.makeText(this, "Sai tài khoản hoặc lỗi server", Toast.LENGTH_SHORT).show();
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}