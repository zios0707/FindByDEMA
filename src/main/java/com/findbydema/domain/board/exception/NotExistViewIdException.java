package com.findbydema.domain.board.exception;

import com.findbydema.global.exception.CustomException;
import com.findbydema.global.exception.error.ErrorCode;

public class NotExistViewIdException extends CustomException {
    public static final CustomException EXCEPTION = new NotExistViewIdException();

    private NotExistViewIdException() {
        super(ErrorCode.VIEW_ID_NOT_FOUND);
    }


}
