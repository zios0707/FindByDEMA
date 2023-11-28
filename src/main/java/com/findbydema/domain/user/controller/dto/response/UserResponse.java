package com.findbydema.domain.user.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class UserResponse {
    private String nickname;
    private String sid;
    private String img;
    private Date makeDate;
}
