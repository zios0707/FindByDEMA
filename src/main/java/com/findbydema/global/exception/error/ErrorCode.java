package com.findbydema.global.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    COMPACT_FAIL( 400, "cannot compact with that data"),
    INVALID_DATA(400, "data was corrupted"),

    NOT_OWNER(403, "not the owner of this"),

    USER_NOT_FOUND(404, "user not found"),
    TOKEN_NOT_FOUND(404, "user not found"),
    VIEW_ID_NOT_FOUND(404, "view id not found"),
    ROOM_ID_NOT_FOUND(404, "room id not found"),
    NOT_MATCH_PASS(404, "not matched password"),
    NOT_MATCH_TOKEN(404, "not matched tokens"),

    EXIST_EMAIL(409, "this email was collide"),
    EXIST_SID(409, "this StudentID was collide");

    private final int httpStatus;
    private final String message;
}
