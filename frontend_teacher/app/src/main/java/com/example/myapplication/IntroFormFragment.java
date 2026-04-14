package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class IntroFormFragment extends Fragment {

    private EditText edtDescription, edtWhatYouLearn, edtSkills;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_intro_form, container, false);

        edtDescription = view.findViewById(R.id.edtDescription);
        edtWhatYouLearn = view.findViewById(R.id.edtWhatYouLearn);
        edtSkills = view.findViewById(R.id.edtSkills);

        return view;
    }

    public String getDescription() {
        return edtDescription != null ? edtDescription.getText().toString().trim() : "";
    }

    public String getWhatYouLearn() {
        return edtWhatYouLearn != null ? edtWhatYouLearn.getText().toString().trim() : "";
    }

    public String getSkills() {
        return edtSkills != null ? edtSkills.getText().toString().trim() : "";
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(getDescription());
    }
}