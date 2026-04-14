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

    // Tài khoản admin cố định để test khi chưa có backend
    private static final String ADMIN_EMAIL = "admin@gmail.com";
    private static final String ADMIN_PASSWORD = "123456789";

    // Tài khoản student cố định để test khi chưa có backend
    private static final String STUDENT_EMAIL = "student@gmail.com";
    private static final String STUDENT_PASSWORD = "123456789";

    // Tài khoản teacher cố định để test khi chưa có backend
    private static final String TEACHER_EMAIL = "teacher@gmail.com";
    private static final String TEACHER_PASSWORD = "123456789";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Ánh xạ view
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLoginSubmit);

        buttonLogin.setOnClickListener(v -> handleLogin());
    }

    private void handleLogin() {
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ email và mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Email không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        // TÀI KHOẢN ADMIN CỐ ĐỊNH
        // Nếu nhập đúng admin thì mở AdminHomeActivity
        if (email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD)) {
            Toast.makeText(this, "Đăng nhập admin thành công", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, AdminHomeActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        // TÀI KHOẢN TEACHER CỐ ĐỊNH
        // Nếu nhập đúng teacher thì mở TeacherHome
        if (email.equals(TEACHER_EMAIL) && password.equals(TEACHER_PASSWORD)) {
            Toast.makeText(this, "Đăng nhập giảng viên thành công", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, TeacherHome.class);
            startActivity(intent);
            finish();
            return;
        }

        // TÀI KHOẢN STUDENT CỐ ĐỊNH
        // Nếu nhập đúng student thì mở HomeActivity
        if (email.equals(STUDENT_EMAIL) && password.equals(STUDENT_PASSWORD)) {
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        Toast.makeText(this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();

        // sendLoginRequest(email, password);
    }

    /*
    BACKEND / CSDL
    private void sendLoginRequest(String email, String password) {

        String url = "http://your-api/login";
        StringRequest request = new StringRequest(Request.Method.POST, url,
                response -> {
                    String result = response.trim();

                    if (result.equalsIgnoreCase("admin")) {
                        Toast.makeText(this, "Đăng nhập admin thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, AdminHomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else if (result.equalsIgnoreCase("teacher")) {
                        Toast.makeText(this, "Đăng nhập giảng viên thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, TeacherHome.class);
                        startActivity(intent);
                        finish();
                    } else if (result.equalsIgnoreCase("student")) {
                        Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    Toast.makeText(this, "Lỗi kết nối server", Toast.LENGTH_SHORT).show();
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
    */
}