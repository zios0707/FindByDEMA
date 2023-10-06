package com.findbydema.domain.user.service;

import com.findbydema.domain.user.controller.dto.request.GetRequest;
import com.findbydema.domain.user.controller.dto.response.GetResponse;
import com.findbydema.domain.user.exception.UserNotFoundException;
import com.findbydema.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetService {
    private final UserRepository repository;

    public GetResponse get(GetRequest request) {
        return GetResponse.builder()
                .user(repository.findById(request.getId())
                        .orElseThrow(() -> UserNotFoundException.EXCEPTION))
                .build();
    }
}
