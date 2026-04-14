package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class CurriculumFragment extends Fragment {

    RecyclerView rvChapters;
    LessonAdapter adapter;
    List<Lesson> lessonList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_curriculum_fragment, container, false);

        rvChapters = view.findViewById(R.id.rvChapters);
        rvChapters.setLayoutManager(new LinearLayoutManager(getActivity()));

        lessonList = LessonData.getAllLessons();

        adapter = new LessonAdapter(getActivity(), lessonList);
        rvChapters.setAdapter(adapter);

        return view;
    }
}