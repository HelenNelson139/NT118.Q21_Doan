package com.example.myapplication;

public class Course {
    private String title;
    private int imageResource;
    private String description;
    private String teacher;

    public Course(String title, int imageResource, String description, String teacher) {
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