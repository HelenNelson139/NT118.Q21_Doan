package com.example.do_an_mon_hoc_quanlikhoahoc_23521023;
public class TeacherCourse {
    private String title;
    private int imageResource;
    private String description;
    private String teacher;

    public TeacherCourse(String title, int imageResource, String description, String teacher) {
        this.title = title;
        this.imageResource = imageResource;
        this.description = description;
        this.teacher = teacher;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDescription() {
        return description;
    }

    public String getTeacher() {
        return teacher;
    }
}