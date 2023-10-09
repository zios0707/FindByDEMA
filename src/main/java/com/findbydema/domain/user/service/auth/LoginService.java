package com.findbydema.domain.user.service.auth;

import com.findbydema.domain.user.controller.dto.request.LoginRequest;
import com.findbydema.domain.user.controller.dto.response.LoginResponse;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.exception.UserNotFoundException;
import com.findbydema.domain.user.exception.auth.NotMatchPasswordException;
import com.findbydema.domain.user.repository.UserRepository;
import com.findbydema.domain.user.service.UserFacade;
import com.findbydema.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider provider;
    private final UserFacade facade;

    public LoginResponse login(LoginRequest request) {

        User user = repository.findByStudentId(request.getStudentID())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw NotMatchPasswordException.EXCEPTION;
        }

        String accessToken = provider.createAccessToken(user.getStudentId());
        String refreshToken = "provider.createRefreshToken(user.getStudentId());"


        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
