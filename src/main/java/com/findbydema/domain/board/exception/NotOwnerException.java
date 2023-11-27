package com.findbydema.domain.board.exception;

import com.findbydema.global.exception.CustomException;
import com.findbydema.global.exception.error.ErrorCode;

public class NotOwnerException extends CustomException {
    public static final CustomException EXCEPTION = new NotOwnerException();

    private NotOwnerException() {
        super(ErrorCode.NOT_OWNER);
    }


}
