package com.findbydema.domain.user.controller.dto.response;

import com.findbydema.domain.user.entity.User;
import lombok.Builder;

@Builder
public class GetResponse {
    private User user;
}
