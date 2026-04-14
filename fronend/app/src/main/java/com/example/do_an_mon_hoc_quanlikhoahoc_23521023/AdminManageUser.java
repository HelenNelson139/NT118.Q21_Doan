package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;

import android.graphics.Color; // Thêm để dùng Color.parseColor
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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.List;

public class AdminManageUser extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private MaterialCardView btnMenu;
    private RecyclerView rvUserList;
    private EditText edtSearch;
    private MaterialButton btnLecturerTab, btnStudentTab;

    private AdminUserSummaryAdapter adapter;
    private List<AdminUserSummary> lecturerList;
    private List<AdminUserSummary> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_user_manage);

        initViews();

        // Đảm bảo tên Class Helper này đúng với file bạn đã tạo
        AdminSidebarNavigationHelper.setupSidebar(this, drawerLayout);

        btnMenu.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.END));

        setupData();
        setupRecyclerView();
        setupTabEvents();
        setupSearch();
        setupBackPressed();
    }

    private void initViews() {
        drawerLayout = findViewById(R.id.drawerLayout);
        btnMenu = findViewById(R.id.btnMenuCard);
        rvUserList = findViewById(R.id.rvUserList);
        edtSearch = findViewById(R.id.edtSearch);
        btnLecturerTab = findViewById(R.id.btnLecturerTab);
        btnStudentTab = findViewById(R.id.btnStudentTab);
    }

    private void setupData() {
        lecturerList = new ArrayList<>();
        // SỬA LỖI CONSTRUCTOR: Chỉ truyền 3 tham số (ID, Tên, ID Ảnh)
        lecturerList.add(new AdminUserSummary("L01", "Dr. Nguyễn Văn A", R.drawable.ic_profile));
        lecturerList.add(new AdminUserSummary("L02", "ThS. Trần Thị B", R.drawable.ic_profile));

        studentList = new ArrayList<>();
        studentList.add(new AdminUserSummary("S01", "Lê Văn C", R.drawable.ic_profile));
        studentList.add(new AdminUserSummary("S02", "Phạm Minh D", R.drawable.ic_profile));
    }

    private void setupRecyclerView() {
        rvUserList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdminUserSummaryAdapter(this, lecturerList);
        rvUserList.setAdapter(adapter);
        updateTabUI(true);
    }

    private void setupTabEvents() {
        btnLecturerTab.setOnClickListener(v -> {
            adapter.updateList(lecturerList);
            updateTabUI(true);
        });

        btnStudentTab.setOnClickListener(v -> {
            adapter.updateList(studentList);
            updateTabUI(false);
        });
    }

    private void updateTabUI(boolean isLecturerSelected) {
        // SỬA LỖI MÀU SẮC: Không dùng R.id.3F72AF mà dùng mã màu HEX trực tiếp
        int activeColor = Color.parseColor("#3F72AF");
        int inactiveColor = Color.parseColor("#112D4E");

        if (isLecturerSelected) {
            btnLecturerTab.setTextColor(activeColor);
            btnLecturerTab.setAlpha(1.0f);
            btnStudentTab.setTextColor(inactiveColor);
            btnStudentTab.setAlpha(0.5f);
        } else {
            btnStudentTab.setTextColor(activeColor);
            btnStudentTab.setAlpha(1.0f);
            btnLecturerTab.setTextColor(inactiveColor);
            btnLecturerTab.setAlpha(0.5f);
        }
    }

    private void setupSearch() {
        View filterIcon = findViewById(R.id.icFilter);
        if (filterIcon != null) {
            filterIcon.setOnClickListener(v -> {
                String query = edtSearch.getText().toString();
                Toast.makeText(this, "Tìm kiếm user: " + query, Toast.LENGTH_SHORT).show();
            });
        }
    }

    private void setupBackPressed() {
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.END)) {
                    drawerLayout.closeDrawer(GravityCompat.END);
                } else {
                    setEnabled(false);
                    onBackPressed();
                }
            }
        });
    }
}