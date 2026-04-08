package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class LessonActivity extends AppCompatActivity {

    TextView txtLessonTitle, txtObjective, txtContent, txtExample;
    ImageView imgExample;
    ImageButton btnBack, btnNext;

    int currentIndex;
    List<Lesson> lessonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        txtLessonTitle = findViewById(R.id.txtLessonTitle);
        txtObjective = findViewById(R.id.txtObjective);
        txtContent = findViewById(R.id.txtContent);
        txtExample = findViewById(R.id.txtExample);
        imgExample = findViewById(R.id.imgExample);

        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);

        lessonList = LessonData.getAllLessons();

        currentIndex = getIntent().getIntExtra("index", 0);

        loadLesson();

        btnNext.setOnClickListener(v -> {
            if (currentIndex < lessonList.size() - 1) {
                currentIndex++;
                loadLesson();
            }
        });

        btnBack.setOnClickListener(v -> {

            if (currentIndex == 0) {

                finish();
            } else {
                currentIndex--;
                loadLesson();
            }

        });
    }

    void loadLesson() {

        Lesson lesson = lessonList.get(currentIndex);

        txtLessonTitle.setText(lesson.getLesson() + ": " + lesson.getTitle());
        txtObjective.setText(lesson.getObjective());
        txtContent.setText(lesson.getContent());
        txtExample.setText(lesson.getExample());
        imgExample.setImageResource(lesson.getImage());

        btnBack.setVisibility(View.VISIBLE);

        if (currentIndex == lessonList.size() - 1) {
            btnNext.setVisibility(View.INVISIBLE);
        } else {
            btnNext.setVisibility(View.VISIBLE);
        }
    }
}