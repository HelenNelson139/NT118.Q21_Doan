package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class mycourseactivity extends AppCompatActivity {

    private MaterialCardView btnMenuCard;

    // Thêm 2 card khóa học
    private MaterialCardView cardLearningCourse;
    private MaterialCardView cardCompletedCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_course);

        btnMenuCard = findViewById(R.id.btnMenuCard);
        btnMenuCard.setOnClickListener(v -> showSidebarMenu());

        // ====== Bắt card khóa học ======
        cardLearningCourse = findViewById(R.id.cardLearningCourse);
        cardCompletedCourse = findViewById(R.id.cardCompletedCourse);

        // ====== Khi ấn vào khóa học đang học ======
        cardLearningCourse.setOnClickListener(v -> {
            Intent intent = new Intent(mycourseactivity.this, LessonActivity.class);
            startActivity(intent);
        });

        // ====== Khi ấn vào khóa học đã hoàn thành ======
        cardCompletedCourse.setOnClickListener(v -> {
            Intent intent = new Intent(mycourseactivity.this, LessonActivity.class);
            startActivity(intent);
        });

    }

    private void showSidebarMenu() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_sidebar);

        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setGravity(Gravity.END);
        }

        MaterialCardView btnCloseMenu = dialog.findViewById(R.id.btnCloseMenu);
        LinearLayout menuProfile = dialog.findViewById(R.id.menuProfile);
        LinearLayout menuCourses = dialog.findViewById(R.id.menuCourses);
        LinearLayout menuMyCourses = dialog.findViewById(R.id.menuLearning);
        TextView txtLogout = dialog.findViewById(R.id.txtLogout);

        btnCloseMenu.setOnClickListener(v -> dialog.dismiss());

        menuProfile.setOnClickListener(v -> {
            startActivity(new Intent(this, ProfileActivity.class));
            dialog.dismiss();
        });

        menuCourses.setOnClickListener(v -> {
            startActivity(new Intent(this, CourseListActivity.class));
            dialog.dismiss();
        });

        menuMyCourses.setOnClickListener(v -> {
            startActivity(new Intent(this, mycourseactivity.class));
            dialog.dismiss();
        });

        txtLogout.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
            );
            startActivity(intent);
            dialog.dismiss();
            finish();
        });

        dialog.show();
    }
}