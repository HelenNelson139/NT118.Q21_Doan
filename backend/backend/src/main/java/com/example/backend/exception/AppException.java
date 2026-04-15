package com.example.backend.exception;
import lombok.*;


@NoArgsConstructor
@Data
public class AppException extends RuntimeException {
    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode){
        super(errorCode.toString()); //goi constructor của class cha RunTimeException
        this.errorCode = errorCode; //lưu code
    }
}
