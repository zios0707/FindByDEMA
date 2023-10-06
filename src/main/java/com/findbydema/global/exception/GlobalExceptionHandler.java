package com.findbydema.global.exception;

import com.findbydema.global.exception.error.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /*
     * timestamp: 에러가 발생한 시간
     * status: 에러의 Http 상태
     * error: 에러 코드
     * path: 에러가 발생한 uri
     * exception: 최상위 예외 클래스의 이름(설정 필요)
     * message: 에러에 대한 내용(설정 필요)
     * errors: BindingExecption에 의해 생긴 에러 목록(설정 필요)
     * trace: 에러 스택 트레이스(설정 필요)
     *
     **/
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(CustomException e) {
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidException(MethodArgumentNotValidException e) {
        return ErrorResponse.fromValidationException(e);
    }
}
