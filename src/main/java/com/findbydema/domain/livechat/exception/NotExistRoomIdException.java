package com.findbydema.domain.livechat.exception;

import com.findbydema.global.exception.CustomException;
import com.findbydema.global.exception.error.ErrorCode;

public class NotExistRoomIdException extends CustomException {
    public static final CustomException EXCEPTION = new NotExistRoomIdException();

    private NotExistRoomIdException() {
        super(ErrorCode.ROOM_ID_NOT_FOUND);
    }


}
