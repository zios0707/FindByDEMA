package com.findbydema.global.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    COMPACT_FAIL( 400, "cant compact with that data"),
    INVALID_DATA(400, "data was corrupted"),

    USER_NOT_FOUND(404, "user not found");

    private final int httpStatus;
    private final String message;
}