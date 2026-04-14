package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputEditText;

public class AdminUserDetailActivity extends AppCompatActivity {

    // Ánh xạ đúng các View từ XML
    private ShapeableImageView imgDetailAvatar;
    private TextView txtDetailId, txtDetailEmail, txtDetailRole, txtDetailStatus;
    private EditText edtFullName, edtDob;
    private TextInputEditText edtPassword;
    private MaterialButton btnLock, btnDelete, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Đảm bảo tên layout này chính xác trong thư mục res/layout
        setContentView(R.layout.admin_user_detail);

        // 1. Khởi tạo và ánh xạ View
        initViews();

        // 2. Nhận dữ liệu từ Intent gửi từ AdminUserSummaryAdapter
        if (getIntent() != null) {
            String userId = getIntent().getStringExtra("USER_ID");
            String userName = getIntent().getStringExtra("USER_NAME");

            // Hiển thị dữ liệu lên giao diện dựa trên ID trong XML
            if (userId != null) {
                txtDetailId.setText("ID: " + userId);
            }
            if (userName != null) {
                edtFullName.setText(userName);
            }

            // Các trường như Email, Role, Status... thường sẽ được load thêm từ Database/API
            // dựa vào userId đã nhận được.
        }

        // 3. Thiết lập các sự kiện nút bấm
        setupClickListeners();
    }

    private void initViews() {
        // Khớp ID với file XML
        imgDetailAvatar = findViewById(R.id.imgDetailAvatar);
        txtDetailId = findViewById(R.id.txtDetailId);
        txtDetailEmail = findViewById(R.id.txtDetailEmail);
        txtDetailRole = findViewById(R.id.txtDetailRole);
        txtDetailStatus = findViewById(R.id.txtDetailStatus);

        edtFullName = findViewById(R.id.edtFullName);
        edtDob = findViewById(R.id.edtDob);
        edtPassword = findViewById(R.id.edtPassword);

        btnLock = findViewById(R.id.btnLock);
        btnDelete = findViewById(R.id.btnDelete);
        btnBack = findViewById(R.id.btnBack);
    }

    private void setupClickListeners() {
        // Quay lại trang trước đó
        btnBack.setOnClickListener(v -> finish());

        // Chức năng Khóa (Ví dụ)
        btnLock.setOnClickListener(v -> {
            Toast.makeText(this, "Đã thực hiện thay đổi trạng thái khóa", Toast.LENGTH_SHORT).show();
        });

        // Chức năng Xóa (Ví dụ)
        btnDelete.setOnClickListener(v -> {
            Toast.makeText(this, "Người dùng đã bị xóa", Toast.LENGTH_SHORT).show();
            finish(); // Quay lại sau khi xóa
        });
    }
}