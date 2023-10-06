package com.findbydema.global.exception.error;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Data
@Builder
public class ErrorResponse {
    private int status;
    private String message;
    // 서버 내부에서 발생하는 에러를 잡아서 리스폰에 에러처리를 해주는 것.
    public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode e) {
        // 커스텀 리스폰 설정.
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(ErrorResponse.builder()
                        .status(e.getHttpStatus())
                        .message(e.getMessage())
                        .build());
    }

    public static ResponseEntity<ErrorResponse> fromValidationException(MethodArgumentNotValidException e) {
        // 논커스텀 리스폰 설정.
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(e.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                        .build());
    }
}

