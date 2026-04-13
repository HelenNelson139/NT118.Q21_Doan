package com.example.ui; // Hãy đảm bảo trùng với package name trong project của bạn

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Bạn có thể thiết lập một layout chào mừng (splash screen) nếu muốn
        // setContentView(R.layout.activity_main);

        // Chuyển hướng sang AdminHomeActivity
        navigateToAdminHome();
    }

    private void navigateToAdminHome() {
        // Sử dụng Intent để khởi tạo việc chuyển màn hình
        Intent intent = new Intent(MainActivity.this, AdminHomeActivity.class);

        // Bắt đầu Activity mới
        startActivity(intent);

        // Kết thúc MainActivity để người dùng không quay lại màn hình trống khi nhấn nút Back
        finish();
    }
}