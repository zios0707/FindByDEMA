package com.findbydema.domain.user.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignRequest {
    private String nickname;

    private String email;

    private String img;

    private String sid;

    private String pass;
}
