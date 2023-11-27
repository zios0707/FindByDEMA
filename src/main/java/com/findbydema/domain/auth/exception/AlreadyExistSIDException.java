package com.findbydema.domain.auth.exception;

import com.findbydema.global.exception.CustomException;
import com.findbydema.global.exception.error.ErrorCode;

public class AlreadyExistSIDException extends CustomException {
    public static final CustomException SID_EXCEPTION = new AlreadyExistSIDException();

    private AlreadyExistSIDException() {
        super(ErrorCode.EXIST_SID);
    }

}
