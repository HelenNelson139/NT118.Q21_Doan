package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.card.MaterialCardView;

public class AdminSidebarNavigationHelper {

    public static void setupSidebar(final Activity activity, final DrawerLayout drawerLayout) {
        // 1. Nút đóng Menu
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

        // 6. Đăng xuất
        TextView txtLogout = activity.findViewById(R.id.txtLogout);
        if (txtLogout != null) {
            txtLogout.setOnClickListener(v -> {
                drawerLayout.closeDrawer(GravityCompat.END);

                Intent intent = new Intent(activity, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                activity.startActivity(intent);
                activity.finish();
            });
        }
    }

    private static void handleNavigation(Activity activity, View itemView, Class<?> targetClass, DrawerLayout drawerLayout) {
        if (itemView != null) {
            itemView.setOnClickListener(v -> {
                drawerLayout.closeDrawer(GravityCompat.END);

                if (!activity.getClass().equals(targetClass)) {
                    Intent intent = new Intent(activity, targetClass);
                    activity.startActivity(intent);
                }
            });
        }
    }
}