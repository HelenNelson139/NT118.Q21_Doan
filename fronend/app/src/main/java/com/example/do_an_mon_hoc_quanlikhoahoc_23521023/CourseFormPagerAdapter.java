package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
public class CourseFormPagerAdapter extends FragmentStateAdapter {

    private final IntroFormFragment introFragment = new IntroFormFragment();
    private final CurriculumFormFragment curriculumFragment = new CurriculumFormFragment();

    public CourseFormPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) return introFragment;
        return curriculumFragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public IntroFormFragment getIntroFragment() {
        return introFragment;
    }

    public CurriculumFormFragment getCurriculumFragment() {
        return curriculumFragment;
    }
}