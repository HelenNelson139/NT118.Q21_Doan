package com.example.ui;

public class AdminUserSummary {
    private String userId;
    private String userName;
    private int avatarResource;

    // Constructor với 3 tham số (ID, Tên, Ảnh)
    public AdminUserSummary(String userId, String userName, int avatarResource) {
        this.userId = userId;
        this.userName = userName;
        this.avatarResource = avatarResource;
    }

    // Getters
    public String getUserId() { return userId; }
    public String getUserName() { return userName; }
    public int getAvatarResource() { return avatarResource; }
}