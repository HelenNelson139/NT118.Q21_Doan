package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CurriculumFormFragment extends Fragment {

    private EditText edtLessons;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_curriculum_form, container, false);

        edtLessons = view.findViewById(R.id.edtLessons);

        return view;
    }

    public String getLessons() {
        return edtLessons != null ? edtLessons.getText().toString().trim() : "";
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(getLessons())) {
            edtLessons.setError("Nhập nội dung giáo trình");
            return false;
        }
        return true;
    }
}