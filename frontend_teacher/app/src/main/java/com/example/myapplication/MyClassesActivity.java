package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MyClassesActivity extends AppCompatActivity {

    private RecyclerView rvCourseList;
    private List<Course> filteredList;
    private CourseAdapter adapter;

    private MaterialCardView btnMenuCard;
    private View btnAddCourse;

    private Uri selectedImageUri;
    private ImageView imgPreview;
    private ActivityResultLauncher<String> imagePickerLauncher;

    private List<View> lessonViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_classes);

        btnMenuCard = findViewById(R.id.btnMenuCard);
        btnAddCourse = findViewById(R.id.btnAddCourse);

        rvCourseList = findViewById(R.id.rvCourseList);
        rvCourseList.setLayoutManager(new LinearLayoutManager(this));

        loadData();

        adapter = new CourseAdapter(filteredList);
        rvCourseList.setAdapter(adapter);

        imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                uri -> {
                    selectedImageUri = uri;
                    if (uri != null && imgPreview != null) {
                        imgPreview.setImageURI(uri);
                    }
                }
        );

        btnMenuCard.setOnClickListener(v -> showSidebarMenu());
        btnAddCourse.setOnClickListener(v -> showAddDialog());
    }

    private void showAddDialog() {
        View view = LayoutInflater.from(this)
                .inflate(R.layout.dialog_add_course, null);

        EditText edtTitle = view.findViewById(R.id.edtCourseTitle);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TextView tabTextView = (TextView) LayoutInflater.from(this).inflate(R.layout.tab_item_layout, null);
            tabTextView.setText(tabLayout.getTabAt(i).getText());
            tabTextView.setTextSize(14);
            tabLayout.getTabAt(i).setCustomView(tabTextView);
        }

        LinearLayout containerIntro = view.findViewById(R.id.containerIntro);
        LinearLayout containerCurriculum = view.findViewById(R.id.containerCurriculum);

        ImageView imgCourseCover = view.findViewById(R.id.imgCourseCover);
        MaterialButton btnUploadImage = view.findViewById(R.id.btnUploadImage);

        LinearLayout lessonContainer = view.findViewById(R.id.lessonContainer);
        MaterialButton btnAddLesson = view.findViewById(R.id.btnAddLesson);

        MaterialButton btnSave = view.findViewById(R.id.btnSaveCourse);
        MaterialButton btnCancel = view.findViewById(R.id.btnCancel);

        selectedImageUri = null;
        imgPreview = imgCourseCover;
        imgCourseCover.setImageResource(android.R.drawable.ic_menu_camera);

        Dialog dialog = new Dialog(this, R.style.CustomDialogTheme);
        dialog.setContentView(view);

        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT); // Chiếm toàn bộ chiều rộng, chiều cao tự động
            window.setGravity(Gravity.CENTER);
            window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        }

        tabLayout.removeAllTabs();
        tabLayout.addTab(tabLayout.newTab().setText("Giới thiệu"));
        tabLayout.addTab(tabLayout.newTab().setText("Giáo trình"));

        containerIntro.setVisibility(View.VISIBLE);
        containerCurriculum.setVisibility(View.GONE);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    containerIntro.setVisibility(View.VISIBLE);
                    containerCurriculum.setVisibility(View.GONE);
                } else {
                    containerIntro.setVisibility(View.GONE);
                    containerCurriculum.setVisibility(View.VISIBLE);
                }
            }

            @Override public void onTabUnselected(TabLayout.Tab tab) {}
            @Override public void onTabReselected(TabLayout.Tab tab) {}
        });

        btnUploadImage.setOnClickListener(v -> {
            imagePickerLauncher.launch("image/*");
        });

        btnAddLesson.setOnClickListener(v -> addLesson(lessonContainer));

        btnSave.setOnClickListener(v -> {
            String title = edtTitle.getText().toString().trim();

            if (title.isEmpty()) {
                edtTitle.setError("Nhập tên khóa học");
                return;
            }

            Course course = new Course(
                    title,
                    selectedImageUri != null ? R.drawable.course_python : R.drawable.course_python,
                    "course",
                    "teacher"
            );

            filteredList.add(course);
            adapter.notifyItemInserted(filteredList.size() - 1);

            dialog.dismiss();
        });

        btnCancel.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    private void addLesson(LinearLayout lessonContainer) {

        View lessonView = LayoutInflater.from(this)
                .inflate(R.layout.item_lesson, null);

        EditText edtObjective = lessonView.findViewById(R.id.txtObjective);
        EditText edtContent = lessonView.findViewById(R.id.txtContent);
        EditText edtExample = lessonView.findViewById(R.id.txtExample);

        ImageView imgLesson = lessonView.findViewById(R.id.imgCourseCover);
        MaterialButton btnPickImage = lessonView.findViewById(R.id.btnUploadImage);

        btnPickImage.setOnClickListener(v -> {
            imagePickerLauncher.launch("image/*");
            imgPreview = imgLesson;
        });

        if (lessonViews.size() > 0) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.topMargin = 20;
            lessonView.setLayoutParams(params);
        }

        lessonContainer.addView(lessonView);
        lessonViews.add(lessonView);
    }

    private void loadData() {
        filteredList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            filteredList.add(new Course(
                    "Phân tích dữ liệu với Python và Machine Learning",
                    R.drawable.course_python,
                    "DESC",
                    "teacher"
            ));
        }
    }

    private void showSidebarMenu() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_sidebar);

        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setGravity(Gravity.END);
        }

        MaterialCardView btnCloseMenu = dialog.findViewById(R.id.btnCloseMenu);
        LinearLayout menuProfile = dialog.findViewById(R.id.menuProfile);
        LinearLayout menuMyClasses = dialog.findViewById(R.id.menuMyClasses);

        btnCloseMenu.setOnClickListener(v -> dialog.dismiss());

        menuProfile.setOnClickListener(v -> {
            startActivity(new Intent(this, ProfileActivity.class));
            dialog.dismiss();
        });

        menuMyClasses.setOnClickListener(v -> {
            startActivity(new Intent(this, MyClassesActivity.class));
            dialog.dismiss();
        });

        dialog.show();
    }
}