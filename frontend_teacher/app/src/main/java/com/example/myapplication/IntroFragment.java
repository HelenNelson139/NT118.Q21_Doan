package com.example.myapplication;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.widget.TextView;
import android.widget.LinearLayout;

import com.google.android.flexbox.FlexboxLayout;

public class IntroFragment extends Fragment {

    Button btnJoin;
    LinearLayout layoutChecklist;
    FlexboxLayout layoutSkills;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_intro_fragment, container, false);

        layoutChecklist = view.findViewById(R.id.layoutChecklist);
        layoutSkills = view.findViewById(R.id.layoutSkills);
        btnJoin = view.findViewById(R.id.btnJoin);

        TextView txtDescription = view.findViewById(R.id.txtDescription);

        txtDescription.setText(
                "Python là một trong những ngôn ngữ lập trình phổ biến nhất hiện nay được sử dụng rộng rãi trong phát triển phần mềm, phân tích dữ liệu và trí tuệ nhân tạo. Khóa học này giúp bạn làm quen với cú pháp Python, cấu trúc dữ liệu, lập trình hướng đối tượng và các thư viện quan trọng để xây dựng các ứng dụng thực tế."
        );

        String[] checklist = new String[]{
                "Hiểu cú pháp cơ bản và cách viết chương trình Python.",
                "Làm việc với các kiểu dữ liệu: số, chuỗi, danh sách, tuple và dictionary.",
                "Sử dụng điều kiện, vòng lặp và hàm trong Python.",
                "Xây dựng chương trình Python để giải quyết bài toán thực tế.",
                "Làm quen với các thư viện phổ biến như NumPy và Pandas."
        };

        for (String item : checklist) {

            TextView tv = new TextView(getContext());

            String text = "✔ " + item;
            SpannableString spannable = new SpannableString(text);

            int green = ContextCompat.getColor(getContext(), R.color.dark_green);
            spannable.setSpan(new ForegroundColorSpan(green), 0, 1, 0);

            tv.setText(spannable);
            tv.setTextSize(17f);
            tv.setPadding(0, 6, 0, 6);

            layoutChecklist.addView(tv);
        }

        String[] skills = new String[]{
                "Python Programming",
                "Data Structures",
                "Data Analysis",
                "NumPy",
                "Pandas",
                "Scikit-learn",
                "Data Visualization",
                "Matplotlib",
                "Algorithm Thinking",
                "Problem Solving"
        };

        for (String skill : skills) {

            TextView tv = new TextView(getContext());

            tv.setText(skill);
            tv.setTextSize(14f);
            tv.setTextColor(ContextCompat.getColor(getContext(), R.color.dark_green));
            tv.setBackgroundResource(R.drawable.bg_skill_tag);
            tv.setPadding(20, 10, 20, 10);

            FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(
                    FlexboxLayout.LayoutParams.WRAP_CONTENT,
                    FlexboxLayout.LayoutParams.WRAP_CONTENT
            );

            lp.setMargins(0, 0, 16, 16);
            tv.setLayoutParams(lp);

            layoutSkills.addView(tv);
        }

        btnJoin.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), LessonActivity.class);

            intent.putExtra("index", 0);

            startActivity(intent);
        });

        return view;
    }
}