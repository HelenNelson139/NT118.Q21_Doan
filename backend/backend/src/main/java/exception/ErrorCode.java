package exception;

import lombok.*;

@Data
@AllArgsConstructor
public class ErrorCode {
//    USER_CREATED_ERROR(1003, "Missing infor or error"),
    private String message;
    private int code;
}
