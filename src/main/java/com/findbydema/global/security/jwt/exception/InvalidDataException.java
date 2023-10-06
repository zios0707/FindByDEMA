package com.findbydema.global.security.jwt.exception;

import com.findbydema.global.exception.CustomException;
import com.findbydema.global.exception.error.ErrorCode;

public class InvalidDataException extends CustomException {
    public static final CustomException EXCEPTION = new InvalidDataException();

    private InvalidDataException() {
        super(ErrorCode.INVALID_DATA);
    }

}
