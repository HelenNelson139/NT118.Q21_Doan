package com.example.ui;

public class Course {
    private String title;
    private int imageResource; // ID của ảnh trong drawable

    public Course(String title, int imageResource) {
        this.title = title;
        this.imageResource = imageResource;
    }

    public String getTitle() { return title; }
    public int getImageResource() { return imageResource; }
}