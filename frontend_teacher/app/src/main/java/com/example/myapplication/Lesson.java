package com.example.myapplication;
public class Lesson {

    private String lesson;
    private String title;
    private String objective;
    private String content;
    private String example;
    private int image;

    public Lesson(String lesson, String title, String objective,
                  String content, String example, int image) {

        this.lesson = lesson;
        this.title = title;
        this.objective = objective;
        this.content = content;
        this.example = example;
        this.image = image;
    }

    public String getLesson() {
        return lesson;
    }

    public String getTitle() {
        return title;
    }

    public String getObjective() {
        return objective;
    }

    public String getContent() {
        return content;
    }

    public String getExample() {
        return example;
    }

    public int getImage() {
        return image;
    }
}