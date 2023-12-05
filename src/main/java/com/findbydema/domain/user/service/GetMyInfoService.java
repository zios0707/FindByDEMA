package com.findbydema.domain.user.service;

import com.findbydema.domain.user.controller.dto.response.UserResponse;
import com.findbydema.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMyInfoService {

    private final UserFacade userFacade;

    public UserResponse execute() {
        User user = userFacade.getInfo();
        return userFacade.sidToResponse(user.getSid());
    }
}
