package com.findbydema.global.security.jwt.exception;

import com.findbydema.global.exception.CustomException;
import com.findbydema.global.exception.error.ErrorCode;

public class JwtCompactFailException extends CustomException {
    public static final CustomException EXCEPTION = new JwtCompactFailException();

    private JwtCompactFailException() {
        super(ErrorCode.COMPACT_FAIL);
    }
}
