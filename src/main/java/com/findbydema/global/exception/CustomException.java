package com.findbydema.global.exception;

import com.findbydema.global.exception.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;
}
