package com.example.ui; // Thay đổi theo package thực tế của bạn

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.card.MaterialCardView;

public class AdminSidebarNavigationHelper {

    public static void setupSidebar(final Activity activity, final DrawerLayout drawerLayout) {
        // 1. Nút đóng Menu (btnCloseMenu)
        MaterialCardView btnClose = activity.findViewById(R.id.btnCloseMenu);
        if (btnClose != null) {
            btnClose.setOnClickListener(v -> drawerLayout.closeDrawer(GravityCompat.END));
        }

        // 2. Menu Trang chủ
        LinearLayout menuHome = activity.findViewById(R.id.menuHome);
        handleNavigation(activity, menuHome, AdminHomeActivity.class, drawerLayout);

        // 3. Menu Quản lý khóa học
        LinearLayout menuCourses = activity.findViewById(R.id.menuCourses);
        handleNavigation(activity, menuCourses, AdminManageCourse.class, drawerLayout);

        // 4. Menu Quản lý người dùng
        LinearLayout menuUser = activity.findViewById(R.id.menuUser);
        handleNavigation(activity, menuUser, AdminManageUser.class, drawerLayout);

        // 5. Menu Hồ sơ
        LinearLayout menuProfile = activity.findViewById(R.id.menuProfile);
        handleNavigation(activity, menuProfile, AdminProfile.class, drawerLayout);
    }

    private static void handleNavigation(Activity activity, View itemView, Class<?> targetClass, DrawerLayout drawerLayout) {
        if (itemView != null) {
            itemView.setOnClickListener(v -> {
                // Đóng drawer trước khi chuyển trang
                drawerLayout.closeDrawer(GravityCompat.END);

                // Nếu đang ở đúng trang đó rồi thì không chuyển nữa để tránh lặp Activity
                if (!activity.getClass().equals(targetClass)) {
                    Intent intent = new Intent(activity, targetClass);
                    activity.startActivity(intent);
                    // Không dùng finish() nếu bạn muốn người dùng nhấn Back quay lại được trang trước
                }
            });
        }
    }
}