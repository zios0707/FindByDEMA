package com.findbydema.domain.user.controller.dto.response;

import com.findbydema.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class GetResponse {
    private String nickname;
    private String sid;
    private String img;
    private Date makeDate;
}
