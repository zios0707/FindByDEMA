package com.findbydema.domain.user.service;

import com.findbydema.domain.user.controller.dto.request.LoginRequest;
import com.findbydema.domain.user.controller.dto.response.LoginResponse;
import com.findbydema.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository repository;

    public LoginResponse login(LoginRequest request) {



        return LoginResponse.builder()
                .accessToken("")
                .build();
    }
}
