package com.findbydema.domain.auth.service;

import com.findbydema.domain.auth.entity.RefreshToken;
import com.findbydema.domain.auth.repository.RefreshTokenRepository;
import com.findbydema.domain.user.controller.dto.request.LoginRequest;
import com.findbydema.domain.user.controller.dto.response.LoginResponse;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.auth.exception.NotMatchPasswordException;
import com.findbydema.domain.user.service.UserFacade;
import com.findbydema.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {
    private final UserFacade userFacade;
    private final RefreshTokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider provider;

    public LoginResponse login(LoginRequest loginRequest) {

        User user = userFacade.findBySid(loginRequest.getSid());

        if(passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw NotMatchPasswordException.EXCEPTION;
        }

        String accessToken = provider.createAccessToken(user.getSid());
        String refreshToken = provider.createRefreshToken(user.getSid());

        tokenRepository.save(RefreshToken.builder()
                .id(user.getSid())
                .refreshToken(refreshToken)
                .accessToken(accessToken)
                .build());


        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}

