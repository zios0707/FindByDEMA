package com.findbydema.domain.user.controller.dto.request;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private String StudentID;
    private String password;
}
