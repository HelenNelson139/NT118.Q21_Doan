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

public class TeacherCourseListActivity extends AppCompatActivity {

    private MaterialCardView btnMenuCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_classes);

        btnMenuCard = findViewById(R.id.btnMenuCard);

        if (btnMenuCard != null) {
            btnMenuCard.setOnClickListener(v -> showSidebarMenu());
        }
    }

    private void showSidebarMenu() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.teacher_layout_sidebar);

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
        LinearLayout menuMyClasses = dialog.findViewById(R.id.menuMyClasses);
        TextView txtLogout = dialog.findViewById(R.id.txtLogout);

        if (btnCloseMenu != null) {
            btnCloseMenu.setOnClickListener(v -> dialog.dismiss());
        }

        if (menuProfile != null) {
            menuProfile.setOnClickListener(v -> {
                startActivity(new Intent(
                        TeacherCourseListActivity.this,
                        TeacherProfileActivity.class
                ));
                dialog.dismiss();
            });
        }

        if (menuMyClasses != null) {
            menuMyClasses.setOnClickListener(v -> dialog.dismiss());
        }

        if (txtLogout != null) {
            txtLogout.setOnClickListener(v -> {
                Intent intent = new Intent(
                        TeacherCourseListActivity.this,
                        MainActivity.class
                );
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                dialog.dismiss();
            });
        }

        dialog.show();
    }
}