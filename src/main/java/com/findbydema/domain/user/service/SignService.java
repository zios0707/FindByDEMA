package com.findbydema.domain.user.service;

import com.findbydema.domain.user.controller.dto.request.LoginRequest;
import com.findbydema.domain.user.controller.dto.request.SignRequest;
import com.findbydema.domain.user.controller.dto.response.LoginResponse;
import com.findbydema.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignService {
    private final UserRepository repository;
    private final LoginService loginService;

    public LoginResponse sign(SignRequest request) {




        return loginService.login(LoginRequest.builder() // 바로 로그인으로 진행
                .StudentID(request.getStudentID())
                .password(request.getPassword())
                .build());
    }


}
