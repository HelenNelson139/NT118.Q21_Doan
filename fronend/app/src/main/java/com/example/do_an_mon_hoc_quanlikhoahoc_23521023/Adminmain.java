package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Adminmain extends AppCompatActivity {

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
        Intent intent = new Intent(this, AdminHomeActivity.class);

        // Bắt đầu Activity mới
        startActivity(intent);

        // Kết thúc MainActivity để người dùng không quay lại màn hình trống khi nhấn nút Back
        finish();
    }
}
