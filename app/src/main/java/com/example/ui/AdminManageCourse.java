package com.example.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.List;

public class AdminManageCourse extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private MaterialCardView btnMenu;
    private RecyclerView rvCourseList;
    private EditText edtSearch;
    private AdminCourseSummaryAdapter adapter;
    private List<AdminCourseSummary> courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Lưu ý: Đảm bảo tên file XML là "admin_course_manage" (khớp với file bạn đã gửi)
        setContentView(R.layout.admin_course_manage);

        // 1. Ánh xạ các View chính
        drawerLayout = findViewById(R.id.drawerLayout);
        btnMenu = findViewById(R.id.btnMenuCard);
        rvCourseList = findViewById(R.id.rvCourseList);
        edtSearch = findViewById(R.id.edtSearch);

        // 2. Thiết lập Sidebar Navigation
        AdminSidebarNavigationHelper.setupSidebar(this, drawerLayout);

        // 3. Xử lý mở Menu
        btnMenu.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.END));

        // 4. Khởi tạo RecyclerView và Dữ liệu
        setupRecyclerView();

        // 5. Xử lý Tìm kiếm/Lọc
        setupSearch();

        // 6. Xử lý nút Back (Cách mới thay cho onBackPressed đã bị deprecated)
        setupBackPressed();
    }

    private void setupRecyclerView() {
        courseList = new ArrayList<>();
        // Thêm dữ liệu mẫu để test giao diện miniview
        courseList.add(new AdminCourseSummary("1", "Lập trình C++ căn bản", "Nguyễn Huỳnh Tiến", "13/04/2026"));
        courseList.add(new AdminCourseSummary("2", "Lập trình Android Java", "Trần Minh Quang", "12/04/2026"));
        courseList.add(new AdminCourseSummary("3", "Cấu trúc dữ liệu & Giải thuật", "Lê Thị Hoa", "11/04/2026"));

        // Thiết lập LayoutManager
        rvCourseList.setLayoutManager(new LinearLayoutManager(this));

        // Thiết lập Adapter
        adapter = new AdminCourseSummaryAdapter(this, courseList);
        rvCourseList.setAdapter(adapter);
    }

    private void setupSearch() {
        View icFilter = findViewById(R.id.icFilter);
        if (icFilter != null) {
            icFilter.setOnClickListener(v -> {
                String query = edtSearch.getText().toString();
                if (!query.isEmpty()) {
                    Toast.makeText(this, "Đang tìm khóa học: " + query, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Vui lòng nhập từ khóa tìm kiếm", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void setupBackPressed() {
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
                    drawerLayout.closeDrawer(GravityCompat.END);
                } else {
                    // Nếu drawer đã đóng, cho phép thoát activity
                    setEnabled(false);
                    onBackPressed();
                }
            }
        });
    }
}