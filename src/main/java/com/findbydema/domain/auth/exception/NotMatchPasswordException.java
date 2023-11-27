package com.findbydema.domain.auth.exception;

import com.findbydema.global.exception.CustomException;
import com.findbydema.global.exception.error.ErrorCode;

public class NotMatchPasswordException extends CustomException {
    public static final NotMatchPasswordException EXCEPTION = new NotMatchPasswordException();

    private NotMatchPasswordException() {
        super(ErrorCode.NOT_MATCH_PASS);
    }


}
