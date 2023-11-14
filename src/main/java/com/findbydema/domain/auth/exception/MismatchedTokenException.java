package com.findbydema.domain.auth.exception;

import com.findbydema.global.exception.CustomException;
import com.findbydema.global.exception.error.ErrorCode;

public class MismatchedTokenException extends CustomException {
    public static final CustomException EXCEPTION = new MismatchedTokenException();

    private MismatchedTokenException() {
        super(ErrorCode.NOT_MATCH_TOKEN);
    }

}
