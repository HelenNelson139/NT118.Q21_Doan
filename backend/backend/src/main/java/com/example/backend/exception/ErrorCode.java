package com.example.backend.exception;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(1001, "User Not Found"),
    UN_AUTHENTICATED(1002, "Cannot Authenticate");

    private int code;
    private String message;

}
