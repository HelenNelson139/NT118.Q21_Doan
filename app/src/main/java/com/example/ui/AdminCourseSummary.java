package com.example.ui;

public class AdminCourseSummary {
    private String id;
    private String title;
    private String lecturer;
    private String postDate;

    public AdminCourseSummary(String id, String title, String lecturer, String postDate) {
        this.id = id;
        this.title = title;
        this.lecturer = lecturer;
        this.postDate = postDate;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getLecturer() { return lecturer; }
    public String getPostDate() { return postDate; }
}