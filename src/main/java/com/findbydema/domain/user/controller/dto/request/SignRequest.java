package com.findbydema.domain.user.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignRequest {
    private String nickname;

    private String StudentID;

    private String email;

    private String password;

    private String img;
}
