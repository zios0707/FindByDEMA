package com.findbydema.domain.user.service;

import com.findbydema.domain.user.controller.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchBySidService {

    private final UserFacade userFacade;

    public UserResponse execute(String sid) {
        return userFacade.sidToResponse(sid);
    }
}
