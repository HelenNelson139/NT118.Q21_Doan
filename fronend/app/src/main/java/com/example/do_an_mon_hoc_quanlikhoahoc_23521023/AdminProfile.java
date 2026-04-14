package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputEditText;

public class AdminProfile extends AppCompatActivity {

    private ShapeableImageView imgAvatar;
    private EditText edtId, edtFullName, edtGmail, edtDob;
    private TextInputEditText edtPassword;
    private MaterialButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_profile);

        // 1. Ánh xạ View
        initViews();

        // 2. Cấu hình đặc biệt cho ID (Không cho phép chỉnh sửa)
        setupIdField();

        // 3. Xử lý sự kiện nút bấm
        setupClickListeners();
    }

    private void initViews() {
        imgAvatar = findViewById(R.id.imgDetailAvatar);
        edtId = findViewById(R.id.edtId);
        edtFullName = findViewById(R.id.edtFullName);
        edtGmail = findViewById(R.id.edtGmail);
        edtDob = findViewById(R.id.edtDob);
        edtPassword = findViewById(R.id.edtPassword);
        btnBack = findViewById(R.id.btnBack);
    }

    private void setupIdField() {
        // Mặc dù XML đã có focusable="false", ta nên set thêm ở code cho chắc chắn
        edtId.setEnabled(false); // Làm mờ nhẹ và ngăn mọi tác động
        // edtId.setFocusable(false);
    }

    private void setupClickListeners() {
        // Nút quay lại (Giống logic trong AdminSidebarNavigationHelper yêu cầu)
        btnBack.setOnClickListener(v -> {
            finish(); // Đóng Activity hiện tại để quay lại trang trước đó
        });

        // Ví dụ: Bạn muốn lưu dữ liệu khi người dùng thoát hoặc thay đổi nội dung
        // Bạn có thể thêm một nút "Cập nhật" nếu cần,
        // hoặc ghi nhận log mỗi khi người dùng thay đổi Text:
    }

    /**
     * Hàm lấy dữ liệu mới từ các trường (ngoại trừ ID)
     * Dùng khi bạn cần gửi dữ liệu lên Server/Firebase
     */
    private void getUpdatedData() {
        String newName = edtFullName.getText().toString().trim();
        String newEmail = edtGmail.getText().toString().trim();
        String newDob = edtDob.getText().toString().trim();
        String newPass = edtPassword.getText().toString();

        // Xử lý lưu dữ liệu tại đây...
    }
}
