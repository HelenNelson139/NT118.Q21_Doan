package com.example.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class AdminCourseDetailActivity extends AppCompatActivity {

    private TextView tvHeaderTitle;
    private MaterialButton btnApprove, btnReject, btnBack;
    private ImageView imgCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_course_detail);

        // 1. Ánh xạ các View từ XML
        initViews();

        // 2. Nhận và hiển thị dữ liệu từ Intent (Gửi từ Adapter)
        displayCourseData();

        // 3. Thiết lập sự kiện cho các nút bấm
        setupClickListeners();
    }

    private void initViews() {
        tvHeaderTitle = findViewById(R.id.tvFixedHeader);
        btnApprove = findViewById(R.id.btnApprove);
        btnReject = findViewById(R.id.btnReject);
        btnBack = findViewById(R.id.btnBack);
        imgCourse = findViewById(R.id.imgCourse);
    }

    private void displayCourseData() {
        // Nhận dữ liệu được gửi từ AdminCourseAdapter thông qua Intent
        String title = getIntent().getStringExtra("COURSE_TITLE");

        if (title != null) {
            tvHeaderTitle.setText(title);
        }

        // Bạn có thể nhận thêm ID để truy vấn Database hoặc API tại đây
        // String courseId = getIntent().getStringExtra("COURSE_ID");
    }

    private void setupClickListeners() {
        // Chức năng nút QUAY LẠI
        btnBack.setOnClickListener(v -> {
            // Đóng Activity này để quay lại trang AdminManageCourse (chứa danh sách summary)
            finish();
        });

        // Chức năng nút DUYỆT
        btnApprove.setOnClickListener(v -> {
            // Xử lý logic duyệt khóa học ở đây (Gửi lên Server/Firebase)
            Toast.makeText(this, "Đã duyệt khóa học thành công!", Toast.LENGTH_SHORT).show();
            finish(); // Quay lại trang danh sách sau khi duyệt
        });

        // Chức năng nút TỪ CHỐI
        btnReject.setOnClickListener(v -> {
            // Xử lý logic từ chối
            Toast.makeText(this, "Đã từ chối khóa học.", Toast.LENGTH_SHORT).show();
            finish(); // Quay lại trang danh sách sau khi từ chối
        });
    }
}