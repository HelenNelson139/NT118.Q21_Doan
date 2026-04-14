package com.example.myapplication;

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


public class RegisterActivity extends AppCompatActivity {

    private EditText editName, editEmail, editPassword;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        buttonSubmit = findViewById(R.id.buttonSubmitRegister);

        buttonSubmit.setOnClickListener(v -> handleRegister());
    }

    private void handleRegister() {
        String name = editName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Email không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 6) {
            Toast.makeText(this, "Mật khẩu phải từ 6 ký tự trở lên", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
        //có backend thì sẽ thay doan nay
        //sendRegisterRequest(name, email, password);

    }

    /*
     private void sendRegisterRequest(String name, String email, String password) {
     *     String url = "http://your-api/register";
     *
     *     StringRequest request = new StringRequest(Request.Method.POST, url,
     *             response -> {
     *                 String result = response.trim();
     *
     *                 if (result.equalsIgnoreCase("success")) {
     *                     Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
     *
     *                     Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
     *                     startActivity(intent);
     *                     finish();
     *                 } else if (result.equalsIgnoreCase("exists")) {
     *                     Toast.makeText(this, "Email đã tồn tại", Toast.LENGTH_SHORT).show();
     *                 } else {
     *                     Toast.makeText(this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
     *                 }
     *             },
     *             error -> {
     *                 Toast.makeText(this, "Lỗi kết nối server", Toast.LENGTH_SHORT).show();
     *             }
     *     ) {
     *         @Override
     *         protected java.util.Map<String, String> getParams() {
     *             java.util.Map<String, String> params = new java.util.HashMap<>();
     *             params.put("name", name);
     *             params.put("email", email);
     *             params.put("password", password);
     *             return params;
     *         }
     *     };
     *
     *     RequestQueue queue = Volley.newRequestQueue(this);
     *     queue.add(request);
     * }
     */
}