package com.findbydema.domain.user.exception.auth;

import com.findbydema.global.exception.CustomException;
import com.findbydema.global.exception.error.ErrorCode;

public class AlreadyExistEmailException extends CustomException {
    public static final CustomException EMAIL_EXCEPTION = new AlreadyExistEmailException();

    private AlreadyExistEmailException() {
        super(ErrorCode.EXIST_EMAIL);
    }

}
