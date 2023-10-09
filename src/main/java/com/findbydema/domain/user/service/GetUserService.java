package com.findbydema.domain.user.service;

import com.findbydema.domain.user.controller.dto.request.GetUserRequest;
import com.findbydema.domain.user.controller.dto.response.GetResponse;
import com.findbydema.domain.user.exception.UserNotFoundException;
import com.findbydema.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserService {
    private final UserRepository repository;

    public GetResponse get(GetUserRequest request) {
        return GetResponse.builder()
                .user(repository.findById(request.getId())
                        .orElseThrow(() -> UserNotFoundException.EXCEPTION))
                .build();
    }
}
