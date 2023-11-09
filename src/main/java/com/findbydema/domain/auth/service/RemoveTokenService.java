package com.findbydema.domain.auth.service;

import com.findbydema.domain.auth.entity.RefreshToken;
import com.findbydema.domain.auth.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RemoveTokenService {

    private final RefreshTokenRepository tokenRepository;

    public void execute(String accessToken) {
        tokenRepository.findByAccessToken(accessToken)
                .ifPresent(tokenRepository::delete);
    }

}
