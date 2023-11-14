package com.findbydema.domain.auth.exception;

import com.findbydema.global.exception.CustomException;
import com.findbydema.global.exception.error.ErrorCode;

public class TokenNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new TokenNotFoundException();

    private TokenNotFoundException() {
        super(ErrorCode.TOKEN_NOT_FOUND);
    }
}
